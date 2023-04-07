package Server;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.ListenableFuture;
import gRPC.*;
import io.grpc.Context;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.concurrent.*;

import static com.google.common.util.concurrent.Futures.addCallback;


public class ServerImpl extends PaxosServerGrpc.PaxosServerImplBase {
    // maxID ever seen
    private volatile long max_ID = 0;
    private long accepted_max_ID;
    private ArrayList<ManagedChannel> channelList;
    private ManagedChannel channel;
    private promise promise;
    private ConcurrentHashMap<String, String> map = new ConcurrentHashMap<String, String>();
    private ArrayList<PaxosServerGrpc.PaxosServerFutureStub>stubList;
    private int serverNumber = ServerRegistry.serverPortList.size();
    private static ExecutorService executor = Executors.newFixedThreadPool(10);
    private int port;
    volatile long maxIdAcrossServer = 0;
    volatile int acceptedPromiseCount = 0;
    volatile long responseReceived = 0;
    boolean commitSent = false;
    volatile boolean firstTimePropose = true;

    public ServerImpl start(int port) {
        // build channel list and stub according to server registry
        channelList = new ArrayList<ManagedChannel>();
        stubList = new ArrayList<PaxosServerGrpc.PaxosServerFutureStub>();
        this.port = port;
        System.out.println("gRPC Server start at port: " + port);
        ServerRegistry.serverPortList.forEach((p) -> {
                channel = ManagedChannelBuilder.forAddress(ServerRegistry.name, p).usePlaintext().build();
                channelList.add(channel);
                stubList.add(PaxosServerGrpc.newFutureStub(channel));
            }
        );
        return this;
    }

    @Override
    public void prepare(prepareMessage request, StreamObserver<promise> responseObserver) {
        // other server will use rpc to call this function
        // update max_ID ever seen
        long id = request.getID();
        System.out.println(port + " receive prepare message ID: " + id);

        // reject the proposal if the received ID bigger than max_ID.
        if (id <= max_ID){
            promise = gRPC.promise.newBuilder().setAccept(false).build();
        }
        // Otherwise accept and adjust the max_ID
        else {
            max_ID = id;
            promise = gRPC.promise.newBuilder().setAccept(true).setLargestID(max_ID).build();
        }
        responseObserver.onNext(promise);
        responseObserver.onCompleted();
    }

    @Override
    public void commit(commitMessage request, StreamObserver<commitResponse> responseObserver) {
        System.out.println("Server: " + port + " is committing...");
        long id = request.getId();
        String key = request.getKey();
        String val = request.getVal();
        int method = request.getMethod();
        commitResponse response;
        // TODO: 为什么id 要 == maxid?

        if (id == max_ID){
            accepted_max_ID = id;
            // delete request
            if (method == Method.DELETE){
                map.remove(key);
                System.out.println("Server " + port + " remove key: " + key);
            } else if (method == Method.PUT){
                // put request
                map.put(key, val);
                System.out.println("Server " + port + " put with key: " + key + " val: " + val);

            } else {
                System.out.println("Server receive unknown method");
            }

            // print the updated map
            map.forEach((k, v) -> System.out.println(port + ": " + k + ":" + v));

            response = gRPC.commitResponse.newBuilder()
                    .setAccept(true)
                    .setLargestID(id)
                    .build();
        } else {
            // do not accept the request and respond with no
            System.out.println("Server " + port + " abort committing. max_ID on this server: " + max_ID + " id received: " + id);
            response = gRPC.commitResponse.newBuilder()
                    .setAccept(false)
                    .setLargestID(id)
                    .build();
        }
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void get(getRequest request, StreamObserver<Response> responseObserver) {
        System.out.println("get request received at server: " + port);
        String key = request.getKey();
        Response response = null;
        try {
            System.out.println("setting GET response: " + map.get(key));
            response = response.newBuilder().setResponse(map.get(key)).build();
        } catch (Exception e){
            System.out.println("Error: key:" + key + " not found");
            response = response.newBuilder().setResponse("null").build();
        }
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public synchronized void put(putRequest request, StreamObserver<Response> responseObserver) {
        System.out.println("put request received at server: " + port);
        String key = request.getKey();
        String val = request.getVal();
        Response response = null;

        startPrepare(key, val, Method.PUT);

        System.out.println("Server: " + port + ": PUT finish.");
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void delete(deleteRequest request, StreamObserver<Response> responseObserver) {
        System.out.println("delete request received at server: " + port);
        String key = request.getKey();
        Response response = null;

        startPrepare(key, "", Method.DELETE);

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    // randomly crash the server for testing
    public void crash() throws InterruptedException {
        Thread.sleep(3000);
    }

    public synchronized void update(gRPC.promise promise, long startTime, String key, String val, int method){
        if (promise != null){
            responseReceived ++;
            if (promise.getAccept() == true){
                acceptedPromiseCount ++;
                maxIdAcrossServer = Math.max(promise.getLargestID(), maxIdAcrossServer);
                System.out.println(acceptedPromiseCount);
                System.out.println(maxIdAcrossServer);
            }

//            if(acceptedPromiseCount >= Math.floorDiv(5, 2) + 1 && commitSent == false){
            if(acceptedPromiseCount >= 3){
                System.out.println(port + ": ACCEPT. acceptedPromiseCount: " + acceptedPromiseCount);
                startCommit(maxIdAcrossServer, key, val, method);
            }
        }
    }

    public synchronized long increaseMax_id(){
        return ++max_ID;
    }

    public synchronized void startPrepare(String key, String val, int method) {
        long startTime = System.currentTimeMillis();
        prepareMessage msg;
        // if its the first time, force them to accept propose
        System.out.println("!!! " + max_ID);

        if (firstTimePropose){
             msg = prepareMessage.newBuilder().setID(2).build();
            firstTimePropose = false;
        } else{
            System.out.println("!!!" + max_ID);
            msg = prepareMessage.newBuilder().setID(increaseMax_id()+1).build();
        }

//        resetPromiseCount();
        Context ctx = Context.current().fork();
        // Set ctx as the current context within the Runnable
        ctx.run(() -> {
            // Can start asynchronous work here that will not
            // be cancelled when myRpcMethod returns
            Future<?> future= executor.submit(new Runnable() {
                @Override
                public void run() {
                    for (PaxosServerGrpc.PaxosServerFutureStub stub: stubList){
                        System.out.println("sending prepare id: " + msg.getID() + " to server: " + stub.getChannel().authority());

                        ListenableFuture<promise> promiseListenableFuture= stub.prepare(msg);
                        addCallback(promiseListenableFuture,
                                new FutureCallback<promise>() {

                                    @Override
                                    public void onSuccess(@Nullable gRPC.promise promise) {
                                        System.out.println("Server: " + port + ": Received promise: " + promise.getAccept());
                                        update(promise, startTime, key, val, method);
                                    }

                                    @Override
                                    public void onFailure(Throwable throwable) {
                                        System.out.println(throwable);
                                    }
                                }, executor);
                    };
                }
            });
        });

    }

    public void startCommit(long maxIdAcrossServers, String key, String val, int method){
        System.out.println("Server: " + port + ": start commit");
        commitMessage msg = commitMessage.newBuilder().setId(maxIdAcrossServers)
                .setKey(key)
                .setVal(val)
                .setId(maxIdAcrossServers)
                .setMethod(method)
                .build();

        for (PaxosServerGrpc.PaxosServerFutureStub stub: stubList){
            System.out.println("Server: " + port + " sending commit message to server: "  + stub.getChannel().authority());
            Context ctx = Context.current().fork();
            // Set ctx as the current context within the Runnable
            ctx.run(() -> {
                ListenableFuture<commitResponse> commitResponseListenableFuture= stub.commit(msg);
                addCallback(commitResponseListenableFuture,
                        new FutureCallback<commitResponse>() {

                            @Override
                            public void onSuccess(@Nullable commitResponse commitResponse) {
                                System.out.println("Receive commit response: " + commitResponse.getAccept());
                            }

                            @Override
                            public void onFailure(Throwable throwable) {
                                System.out.println(throwable);
                            }
                        },
                        executor);
            });
        }
    }


}


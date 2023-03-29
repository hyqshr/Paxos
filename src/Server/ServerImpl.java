package Server;

import com.google.common.util.concurrent.ListenableFuture;
import gRPC.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

public class ServerImpl extends PaxosServerGrpc.PaxosServerImplBase {
    private long max_ID = 0;
    private long accepted_max_ID;
    private ArrayList<ManagedChannel> channelList;
    private ManagedChannel channel;
    private promise promise;
    private ConcurrentHashMap<String, String > map;
    private ArrayList<PaxosServerGrpc.PaxosServerFutureStub>stubList;

    public ServerImpl start() {
        // build channel list and stub according to server registry
        channelList = new ArrayList<ManagedChannel>();
        stubList = new ArrayList<PaxosServerGrpc.PaxosServerFutureStub>();

        ServerRegistry.serverPortList.forEach((port) -> {
                channel = ManagedChannelBuilder.forAddress(ServerRegistry.name, port).usePlaintext().build();
                channelList.add(channel);
                stubList.add(PaxosServerGrpc.newFutureStub(channel));
            }
        );

        return this;
    }

    @Override
    public void sendPrepare(prepareMessage request, StreamObserver<promise> responseObserver) {
        // other server will use rpc to call this function
        long id = request.getID();

        // reject the proposal if the received ID bigger than max_ID.
        if (id < max_ID){
            promise = gRPC.promise.newBuilder().setAccept(false).build();
        }
        // Otherwise accept and adjust the max_ID
        else {
            max_ID = id;
            promise = gRPC.promise.newBuilder().setAccept(true).setLargestID(accepted_max_ID).build();
        }
        responseObserver.onNext(promise);
        responseObserver.onCompleted();
    }

    @Override
    public void sendPropose(proposeMessage request, StreamObserver<commitResponse> responseObserver) {
        long id = request.getId();
        if (id == max_ID){
            accepted_max_ID = id;
            // TODO: modify the map according to request
//            map.put()
            // TODO: send accepted to all learners?

        }
    }

    @Override
    public void get(getKey request, StreamObserver<getResponse> responseObserver) {
    }

    // randomly crash the server for testing
    public void crash() throws InterruptedException {
        Thread.sleep(3000);
    }

    public void startPropose(String key){
        prepareMessage msg = prepareMessage.newBuilder().setID(++max_ID).build();
//        stubList.forEach((stub) -> stub.sendPrepare(msg));
        for (PaxosServerGrpc.PaxosServerFutureStub stub: stubList){
            ListenableFuture<gRPC.promise> futurePromise = stub.sendPrepare(msg);
            futurePromise.
        }

    }


}

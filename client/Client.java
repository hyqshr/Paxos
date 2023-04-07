import Server.ServerRegistry;
import gRPC.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

import static Server.ServerRegistry.serverPortList;

public class Client {
    private ManagedChannel channel;
    private String name;
    private int port;
    private ArrayList<ManagedChannel> channelList;
    private PaxosServerGrpc.PaxosServerBlockingStub stub;
    private ArrayList<PaxosServerGrpc.PaxosServerBlockingStub> stubList;
    private ConcurrentHashMap<Integer, PaxosServerGrpc.PaxosServerBlockingStub> portStubMap = new ConcurrentHashMap<Integer, PaxosServerGrpc.PaxosServerBlockingStub>();
    public Client() {
//            ManagedChannel channel = ManagedChannelBuilder.forAddress(ServerRegistry.name, 8081).usePlaintext().build();
//            this.stub = PaxosServerGrpc.newBlockingStub(channel);
//        serverPortList.forEach((port) -> portStubMap.put(port, PaxosServerGrpc.newBlockingStub(
//                ManagedChannelBuilder.forAddress(ServerRegistry.name, port).usePlaintext().build()
//        )));
        for (int port: serverPortList){
            this.channel = ManagedChannelBuilder.forAddress(ServerRegistry.name, port).usePlaintext().build();
            this.stub = PaxosServerGrpc.newBlockingStub(this.channel);
            portStubMap.put(port, this.stub);
        }

        }

    public void put(String key, String val){
        PaxosServerGrpc.PaxosServerBlockingStub stub = getRandomStub();
        putRequest request = putRequest.newBuilder().setKey(key).setVal(val).build();
        System.out.println("Client call grpc PUT service: " + key + " - " + val);
//        stub.withDeadlineAfter(10000, TimeUnit.MILLISECONDS).put(request);
        stub.put(request);
//        System.out.println("PUT Done!");

    }

    public void getFromAllServers(String key) {
        getRequest request = getRequest.newBuilder().setKey(key).build();
        System.out.println("Client call grpc GET service: " + key);
        portStubMap.values().forEach((stub) -> {
            Response response = stub.get(request);
            System.out.println("GET value: " + response.getResponse() + " with key: " + key + " from " + stub.getChannel().authority());
        });
        System.out.println("GET Done!");
    }

    public void get(String key) {
        PaxosServerGrpc.PaxosServerBlockingStub stub = getRandomStub();
        getRequest request = getRequest.newBuilder().setKey(key).build();
        System.out.println("Client call grpc GET service: " + key);
        Response response = stub.get(request);
        System.out.println(response);
        System.out.println("GET Done!");
    }

    public void delete(String key){
        deleteRequest request = deleteRequest.newBuilder().setKey(key).build();
        System.out.println("Client send grpc DELETE service: " + key);
        PaxosServerGrpc.PaxosServerBlockingStub stub = getRandomStub();
        stub.delete(request);
    }

    public PaxosServerGrpc.PaxosServerBlockingStub getRandomStub(){
        Random rand = new Random();
        int randomIndex = rand.nextInt(serverPortList.size());
        int randomElement = serverPortList.get(randomIndex);
        return portStubMap.get(randomElement);
    }

}

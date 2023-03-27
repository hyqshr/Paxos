import gRPC.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class Client {
    private String name;
    private int port;
    private ManagedChannel channel;
    private putServiceGrpc.putServiceBlockingStub putServiceBlockingStub;
    private deleteServiceGrpc.deleteServiceBlockingStub deleteServiceBlockingStub;

    public Client(String name, int port) {
        this.channel = ManagedChannelBuilder.forAddress(name,port).usePlaintext().build();
        this.putServiceBlockingStub = putServiceGrpc.newBlockingStub(channel);
        this.deleteServiceBlockingStub = deleteServiceGrpc.newBlockingStub(channel);
    }
    public void sendGrpcPutRequest(String key, String val){
        putRequest request = putRequest.newBuilder().setKey(key).setVal(val).build();
        System.out.println("Client call grpc PUT service: " + key + " - " + val);
        putResponse response = putServiceBlockingStub.put(request);
        System.out.println(response);
        System.out.println("PUT Done!");
    }

    public void sendGrpcDeleteRequest(String key){
        deleteRequest request = deleteRequest.newBuilder().setKey(key).build();
        System.out.println("Client call grpc DELETE service: " + key);
        deleteResponse response = deleteServiceBlockingStub.delete(request);
        System.out.println(response);
        System.out.println("DELETE Done!");
    }
}

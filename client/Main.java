public class Main {
    public static void main(String[] args) {
        Client client = new Client("localhost", 8081);
        client.sendGrpcPutRequest("1","2");
        client.sendGrpcPutRequest("2","3");
        client.sendGrpcPutRequest("3","4");
        client.sendGrpcPutRequest("4","2");
        client.sendGrpcPutRequest("5","c");
        client.sendGrpcDeleteRequest("1");
        client.sendGrpcDeleteRequest("2");
        client.sendGrpcDeleteRequest("3");
        client.sendGrpcDeleteRequest("4");
        client.sendGrpcDeleteRequest("5");
    }
}

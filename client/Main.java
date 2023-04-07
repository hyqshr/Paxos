public class Main {
    public static void main(String[] args) throws InterruptedException {
        Client client = new Client();
        client.put("1","2");
        client.put("2","3");
        client.put("3","4");
        client.put("5","6");
        client.put("6","9");

        // sleep to prevent racing
        Thread.sleep(200);
        client.getFromAllServers("1");
        client.getFromAllServers("2");
        client.getFromAllServers("3");
        client.getFromAllServers("5");
        client.getFromAllServers("6");
        client.delete("6");
        client.delete("1");
        client.getFromAllServers("6");
        client.getFromAllServers("1");

    }
}

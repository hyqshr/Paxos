package Server;

import java.util.ArrayList;

public class ServerRegistry {
    public static ArrayList<Integer> serverPortList = new ArrayList<Integer>() {
        {
            add(8081);
            add(8082);
            add(8083);
            add(8084);
            add(8085);
        }
    };
    public static int serverPort1 = 8081;
    public static int serverPort2 = 8082;
    public static int serverPort3 = 8083;
    public static int serverPort4 = 8084;
    public static int serverPort5 = 8085;
    public static String  name = "localhost";

}

package Server;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import shared.Log;

public class Main {
	public static String COORDINATOR_IP = "localhost";
	public static int COORDINATOR_PORT = 5476;
	public static boolean VOTE_ABORT_FLAG = false;
	public static int SLEEP_TIME = 0;

	public static void main(String[] args) {
		Map<String, String> map = new ConcurrentHashMap<>();

		try {
			// socket connect to coordinator
			Socket socket = new Socket(COORDINATOR_IP, COORDINATOR_PORT);
			Log log = new Log();

			// join coordinator
			Participant p = new Participant(log, socket, map);
			System.out.println("server at " + socket.getLocalSocketAddress() + " joined the coordinator!");
			while (true){
				p.startParticipating();
			}

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}

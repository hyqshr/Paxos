package Coordinator;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.Map;


public class ListenThread implements Runnable{
	private boolean stop;
	private int port;
	private ServerSocket socket;
	
	Map<Socket, Participant> connections;
	
	public ListenThread(int port, Map<Socket, Participant> connections){
		stop = false;
		this.port = port;
		this.connections = connections;
	}

	@Override
	public void run() {
		try {
			socket = new ServerSocket(port);
			System.out.println("listening on: " + port);
//			socket.setSoTimeout(500);

			// listen for new server joining
			while(!stop){
				Socket newClient = null;
				try{
					// get server IP address and port
					newClient = socket.accept();
					InetAddress ip = newClient.getInetAddress();
					int port = newClient.getPort();

					Participant participant = new Participant(newClient, connections);
					connections.put(newClient, participant);
					System.out.println("New server connection the coordinator: " + ip.toString() + ":" + port );
				}catch(SocketTimeoutException e){
				}catch(IOException e){
					System.out.println("Could not accept client connection");
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			socket.close();
		} catch (IOException e) {}
		
	}
	
	public void finish(){
		System.out.println("stopping tcp server");
		stop = true;
		
	}
	

}

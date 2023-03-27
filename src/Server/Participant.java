package Server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.HashMap;
import java.util.Map;
import shared.Log;
import shared.Message;

public class Participant{
	private Log log;
	private Socket socket;
	private Map map;

	public Participant(Log log, Socket socket, Map map){
		this.log = log;
		this.socket = socket;
		this.map = map;
	}

	public void initiateCommit(){
		System.out.println("send message to coordinator: " + "INIT_VOTE");
		sendMessage(new Message("INIT_VOTE"));
	}

	public void startParticipating(){
		try {
			Thread.sleep(Main.SLEEP_TIME);
//			socket.setSoTimeout(Main.TIMEOUT);
			Message o = receive();

			// receive the vote request from coordinator
			if(o.type.equals("VOTE_REQUEST")){
				if(Main.VOTE_ABORT_FLAG){ //vote abort
					log.write(Log.VOTE_ABORT);
					sendMessage(new Message("VOTE_ABORT"));
					return;
				}else{//vote commit
					log.write(Log.VOTE_COMMIT);
					sendMessage(new Message("VOTE_COMMIT"));
				}
			}
			try{
				// get the decision from the coordinator
				o = receive();
				
				if(o.type.equals("GLOBAL_COMMIT") && (o.method.equals("PUT"))){
					// execute put at this server and print the result
					map.put(o.key, o.val);
					System.out.println(socket.getLocalSocketAddress() + " current map: ");
					System.out.print("{");
					map.forEach((key, value) -> System.out.print(" " + key + ":" + value));
					System.out.println("}");
				}else if(o.type.equals("GLOBAL_COMMIT") && (o.method.equals("DELETE"))){
					// execute delete request and print the result
					map.remove(o.key);
					System.out.println(socket.getLocalSocketAddress() + " current map: ");
					System.out.print("{");
					map.forEach((key, value) -> System.out.print(" " + key + ":" + value));
					System.out.println("}");
				}else if(o.type.equals("GLOBAL_ABORT")){
					log.write(Log.GLOBAL_ABORT);
				}else{
					log.write(Log.VOTE_ABORT);
					sendMessage(new Message("VOTE_ABORT"));
					return;
				}
				
			}catch(SocketTimeoutException e){
				return;
			}
			
		}catch(SocketTimeoutException e){
			log.write("VOTE_ABORT");
			return;
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public void sendMessage(Message message){
		try {
			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
			oos.writeObject(message);
			System.out.println("Sent " + message.type);
		} catch (IOException e) {
			finish();
			e.printStackTrace();
		}
	}
	public void finish(){
		System.out.println("closing " + toString() + ".");

		try {
			socket.close();
		} catch (IOException e) {}
	}
	
	private Message receive() throws SocketTimeoutException{
		ObjectInputStream ois;
		Message o = null;
		try {
			ois = new ObjectInputStream(socket.getInputStream());
			o = (Message) ois.readObject();
		}catch(SocketTimeoutException e){
			throw e;
		}catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Server received " + o.type);
		return o;
	}


}



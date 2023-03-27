package Coordinator;

import java.net.Socket;
import java.util.Map;

import Server.Main;
import shared.Log;
import shared.Message;

public class Coordinator {
	private Log log;
	private Map<Socket, Participant> connections;

	volatile int voteCounter;
	
	public Coordinator(Log log, Map<Socket, Participant> connections) {
		this.log = log;
		this.connections = connections;
	}
	public synchronized void startCommit(String key, String val, String method){
		voteCounter = 0;
		log.write(Log.START_2PC);
		Message voteRequestMessage = new Message("VOTE_REQUEST", key, val, method);
		
		try {
			Thread.sleep(Main.SLEEP_TIME);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(Participant p: connections.values()){
			p.sendMessage(voteRequestMessage, new ResponseEvent() { 
				@Override
				public void notify(Message message) { //successfull
					if(message.type.equals("VOTE_COMMIT")){
						participantCommit(key, val, method);
					}else{
						participantAbort();
					}
				}
			}, new ResponseEvent() {
				@Override
				public void notify(Message message) { //timeout
					participantAbort();
				}
			});
		}
	}
	
	private synchronized void participantCommit(String key, String val, String method){
		voteCounter++;
		String latestLog = log.latest();
		if(voteCounter == connections.size() && !latestLog.equals(Log.GLOBAL_ABORT)){
			log.write(Log.GLOBAL_COMMIT);
			Message globalCommitMessage = new Message("GLOBAL_COMMIT", key, val, method);
			for(Participant pp: connections.values()){
				pp.sendMessage(globalCommitMessage);
			}
		}
		
	}
	private synchronized void participantAbort(){
		log.write(Log.GLOBAL_ABORT);
		Message globalAbortMessage = new Message("GLOBAL_ABORT"); 
		for(Participant pp: connections.values()){
			pp.sendMessage(globalAbortMessage);
		}
	}

}

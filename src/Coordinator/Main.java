package Coordinator;

import java.io.IOException;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import Coordinator.service.DeleteService;
import Coordinator.service.PutService;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import shared.Log;

public class Main {
	public static int LISTEN_PORT = 5476;
	public static int TIMEOUT = 10000;

	public static void main(String[] args) throws IOException, InterruptedException {
		Map<Socket, Participant > connections = new ConcurrentHashMap<>();
		Log log = new Log();

		// listen for service to join
		ListenThread lt = new ListenThread(LISTEN_PORT, connections);
		new Thread(lt).start();

		// create gRPC
		Coordinator coordinator = new Coordinator(log, connections);
		PutService putService = new PutService(coordinator);
		DeleteService deleteService = new DeleteService(coordinator);

		// specify gRPC service with port
		Server server = ServerBuilder.forPort(8081)
				.addService(putService)
				.addService(deleteService)
				.build();

		System.out.println("Coordinator and gRPC server started!");
		server.start();
		server.awaitTermination();
	}

}

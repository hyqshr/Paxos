package Server;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException, InterruptedException {
		// start 5 server, configure more if you want
		Server server1 = ServerBuilder.forPort(ServerRegistry.serverPort1)
				.addService(new ServerImpl().start(ServerRegistry.serverPort1))
				.build();
		Server server2 = ServerBuilder.forPort(ServerRegistry.serverPort2)
				.addService(new ServerImpl().start(ServerRegistry.serverPort2))
				.build();
		Server server3 = ServerBuilder.forPort(ServerRegistry.serverPort3)
				.addService(new ServerImpl().start(ServerRegistry.serverPort3))
				.build();
		Server server4 = ServerBuilder.forPort(ServerRegistry.serverPort4)
				.addService(new ServerImpl().start(ServerRegistry.serverPort4))
				.build();
		Server server5 = ServerBuilder.forPort(ServerRegistry.serverPort5)
				.addService(new ServerImpl().start(ServerRegistry.serverPort5))
				.build();

		server1.start();
		server2.start();
		server3.start();
		server4.start();
		server5.start();

		server1.awaitTermination();
		server2.awaitTermination();
		server3.awaitTermination();
		server4.awaitTermination();
		server5.awaitTermination();
	}

}

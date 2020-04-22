package grpcDemoApp.unary.rpc.server;

import java.io.IOException;

public class ServerStartUp {
	
	/**
	 * Main launches the server.
	 */
	public static void main(String[] args) throws IOException, InterruptedException {
		final OneToOneServer server = new OneToOneServer();
		server.start();
		server.blockUntilShutdown();
	}

}

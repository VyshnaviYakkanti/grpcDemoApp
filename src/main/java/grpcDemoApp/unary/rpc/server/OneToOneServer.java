package grpcDemoApp.unary.rpc.server;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import io.grpc.Server;
import io.grpc.ServerBuilder;

public class OneToOneServer {

	private static final Logger logger = Logger.getLogger(OneToOneServer.class.getName());

	private Server server;

	public void start() throws IOException {
		/* The port on which the server should run */
		int port = 50051;
		server = ServerBuilder.forPort(port).addService(new OneToOneServerImpl()).build().start();
		logger.info("Server started, listening on " + port);
		Runtime.getRuntime().addShutdownHook(new Thread() {
			@Override
			public void run() {
				System.err.println("*** shutting down gRPC server since JVM is shutting down");
				try {
					OneToOneServer.this.stop();
				} catch (InterruptedException e) {
					e.printStackTrace(System.err);
				}
				System.err.println("*** server shut down");
			}
		});
	}

	private void stop() throws InterruptedException {
		if (server != null) {
			server.shutdown().awaitTermination(30, TimeUnit.SECONDS);
		}
	}

	/**
	 * Await termination on the main thread since the grpc library uses daemon
	 * threads.
	 */
	public void blockUntilShutdown() throws InterruptedException {
		if (server != null) {
			server.awaitTermination();
		}
	}

	

}

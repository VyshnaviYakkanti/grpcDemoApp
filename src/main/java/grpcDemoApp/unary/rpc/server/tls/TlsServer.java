package grpcDemoApp.unary.rpc.server.tls;

import io.grpc.Server;
import io.grpc.netty.GrpcSslContexts;
import io.grpc.netty.NettyServerBuilder;
import io.netty.handler.ssl.ClientAuth;
import io.netty.handler.ssl.SslContextBuilder;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

import grpcDemoApp.unary.rpc.server.OneToOneServerImpl;

public class TlsServer {

	private static final Logger logger = Logger.getLogger(TlsServer.class.getName());

	private Server server;

	private final int port;
	private final String certChainFilePath;
	private final String privateKeyFilePath;
	
	//You only need to supply trustCertCollectionFilePath if you want to enable Mutual TLS
	private final String trustCertCollectionFilePath;

	public TlsServer(int port, String certChainFilePath, String privateKeyFilePath,
			String trustCertCollectionFilePath) {
		this.port = port;
		this.certChainFilePath = certChainFilePath;
		this.privateKeyFilePath = privateKeyFilePath;
		this.trustCertCollectionFilePath = trustCertCollectionFilePath;
	}

	private SslContextBuilder getSslContextBuilder() {
		SslContextBuilder sslClientContextBuilder = SslContextBuilder.forServer(new File(certChainFilePath),
				new File(privateKeyFilePath));
		if (trustCertCollectionFilePath != null) {
			sslClientContextBuilder.trustManager(new File(trustCertCollectionFilePath));
			sslClientContextBuilder.clientAuth(ClientAuth.REQUIRE);
		}
		return GrpcSslContexts.configure(sslClientContextBuilder);
	}

	public void start() throws IOException {
		server = NettyServerBuilder.forPort(port).addService(new OneToOneServerImpl())
				.sslContext(getSslContextBuilder().build()).build().start();
		logger.info("Server started, listening on " + port);
		Runtime.getRuntime().addShutdownHook(new Thread() {
			@Override
			public void run() {
				// Use stderr here since the logger may have been reset by its JVM shutdown
				// hook.
				System.err.println("*** shutting down gRPC server since JVM is shutting down");
				TlsServer.this.stop();
				System.err.println("*** server shut down");
			}
		});
	}

	private void stop() {
		if (server != null) {
			server.shutdown();
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

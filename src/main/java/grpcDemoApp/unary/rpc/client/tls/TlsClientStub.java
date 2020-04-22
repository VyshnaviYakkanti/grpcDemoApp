package grpcDemoApp.unary.rpc.client.tls;

import io.grpc.ManagedChannel;
import io.grpc.StatusRuntimeException;
import io.grpc.netty.NettyChannelBuilder;
import io.netty.handler.ssl.SslContext;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLException;

import com.example.grpc.OnetoOneServiceGrpc;
import com.example.grpc.OnetoOneServiceGrpc.OnetoOneServiceBlockingStub;
import com.example.grpc.OnetoOneproto.Request;
import com.example.grpc.OnetoOneproto.Response;

public class TlsClientStub {

	private static final Logger logger = Logger.getLogger(TlsClientStub.class.getName());

	private final ManagedChannel channel;
	private final OnetoOneServiceBlockingStub blockingStub;

	/**
	 * Construct client connecting to server at {@code host:port}.
	 */
	public TlsClientStub(String host, int port, SslContext sslContext) throws SSLException {

		this(NettyChannelBuilder.forAddress(host, port).overrideAuthority("roop").sslContext(sslContext)
				.build());
	}

	/**
	 * Construct client for accessing server using the existing channel.
	 */
	TlsClientStub(ManagedChannel channel) {
		this.channel = channel;
		blockingStub = OnetoOneServiceGrpc.newBlockingStub(channel);
	}

	public void shutdown() throws InterruptedException {
		channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
	}

	/** Call to server. */
	public Response serverCall(String name) {
		logger.info("Will try to welcome " + name + " ...");
		Request request = Request.newBuilder().setName(name).build();
		Response response = null;
		try {
			response = blockingStub.oneToOneCall(request);
		} catch (StatusRuntimeException e) {
			logger.log(Level.WARNING, "RPC failed: {0}", e.getStatus());
			
		}
		logger.info("Server Response : " + response.getWelcome());
		return response;
	}

}

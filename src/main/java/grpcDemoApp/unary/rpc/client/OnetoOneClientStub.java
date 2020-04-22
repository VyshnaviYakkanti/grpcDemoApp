package grpcDemoApp.unary.rpc.client;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.example.grpc.OnetoOneServiceGrpc;
import com.example.grpc.OnetoOneServiceGrpc.OnetoOneServiceBlockingStub;
import com.example.grpc.OnetoOneproto.Request;
import com.example.grpc.OnetoOneproto.Response;

import io.grpc.Channel;
import io.grpc.StatusRuntimeException;

public class OnetoOneClientStub {
	
	
	private static final Logger logger = Logger.getLogger(OnetoOneClientStub.class.getName());

	private final OnetoOneServiceBlockingStub blockingStub;

	/**
	 * Construct client for accessing server using the existing channel.
	 */
	public OnetoOneClientStub(Channel channel) {
		// 'channel' here is a Channel, not a ManagedChannel, so it is not this code's
		// responsibility to
		// shut it down.

		// Passing Channels to code makes code easier to test and makes it easier to
		// reuse Channels.
		blockingStub = OnetoOneServiceGrpc.newBlockingStub(channel);
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

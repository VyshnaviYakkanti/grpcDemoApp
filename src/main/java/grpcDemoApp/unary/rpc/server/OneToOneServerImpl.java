package grpcDemoApp.unary.rpc.server;

import com.example.grpc.OnetoOneServiceGrpc.OnetoOneServiceImplBase;
import com.example.grpc.OnetoOneproto.Request;
import com.example.grpc.OnetoOneproto.Response;

import io.grpc.stub.StreamObserver;

public class OneToOneServerImpl extends OnetoOneServiceImplBase {

	@Override
	public void oneToOneCall(Request req, StreamObserver<Response> responseObserver) {
		Response response = Response.newBuilder().setWelcome("I am responding from server : Hello " + req.getName()).build();
		responseObserver.onNext(response);
		responseObserver.onCompleted();
	}

}

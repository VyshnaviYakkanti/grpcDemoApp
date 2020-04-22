package grpcDemoApp.unary.rpc.client;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.AdditionalAnswers;
import org.mockito.ArgumentCaptor;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import com.example.grpc.OnetoOneServiceGrpc.OnetoOneServiceImplBase;
import com.example.grpc.OnetoOneproto.Request;
import com.example.grpc.OnetoOneproto.Response;
import grpcDemoApp.unary.rpc.client.OnetoOneClientStub;
import io.grpc.ManagedChannel;
import io.grpc.inprocess.InProcessChannelBuilder;
import io.grpc.inprocess.InProcessServerBuilder;
import io.grpc.stub.StreamObserver;
import io.grpc.testing.GrpcCleanupRule;

@RunWith(JUnit4.class)

public class OnetoOneClientStubTest {

	@Rule
	public GrpcCleanupRule grpcCleanup = new GrpcCleanupRule();

	ManagedChannel channel;

	OnetoOneServiceImplBase onetoOneServiceImplBase = Mockito.mock(OnetoOneServiceImplBase.class,
			AdditionalAnswers.delegatesTo(new OnetoOneServiceImplBase() {
				@Override
				public void oneToOneCall(Request req, StreamObserver<Response> responseObserver) {
					Response response = Response.newBuilder()
							.setWelcome("I am responding from server : Hello " + req.getName()).build();
					responseObserver.onNext(response);
					responseObserver.onCompleted();
				}
			}));

	OnetoOneClientStub onetoOneClientStub;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);

		String serverName = InProcessServerBuilder.generateName();

		// Create a server, add service, start, and register for automatic graceful
		// shutdown.
		grpcCleanup.register(InProcessServerBuilder.forName(serverName).directExecutor()
				.addService(onetoOneServiceImplBase).build().start());

		// Create a client channel and register for automatic graceful shutdown.
		channel = grpcCleanup.register(InProcessChannelBuilder.forName(serverName).directExecutor().build());

		// Create a Client using the in-process channel;
		onetoOneClientStub = new OnetoOneClientStub(channel);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test_whenServerCall_thenReturnSuccessResponse() {

		assertThat(onetoOneClientStub.serverCall("RoopTest"), org.hamcrest.Matchers.instanceOf(Response.class));
	}

	@Test
	public void test_oneToOneCall_messageDeliveredToServer() {
		ArgumentCaptor<Request> requestCaptor = ArgumentCaptor.forClass(Request.class);
		onetoOneClientStub.serverCall("RoopTest1");

		Mockito.verify(onetoOneServiceImplBase).oneToOneCall(requestCaptor.capture(),
				ArgumentMatchers.<StreamObserver<Response>>any());

		assertEquals("RoopTest1", requestCaptor.getValue().getName());
	}

}

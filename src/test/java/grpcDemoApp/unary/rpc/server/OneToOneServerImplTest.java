package grpcDemoApp.unary.rpc.server;

import static org.junit.Assert.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.example.grpc.OnetoOneproto.Request;
import com.example.grpc.OnetoOneproto.Response;

import io.grpc.stub.StreamObserver;

@RunWith(MockitoJUnitRunner.class)
public class OneToOneServerImplTest {
	
	OneToOneServerImpl oneToOneServerImpl;
	Request request ;

	@Before
	public void setUp() throws Exception {
		oneToOneServerImpl = new OneToOneServerImpl();
		request = Request.newBuilder()
				.setName("Roop")
				.build();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test_oneToOneCall() {

		StreamObserver<Response> responseObserver = Mockito.mock(StreamObserver.class);

		oneToOneServerImpl.oneToOneCall(request, responseObserver);

		Mockito.verify(responseObserver,Mockito.times(1)).onCompleted();

		ArgumentCaptor<Response> captor = ArgumentCaptor.forClass(Response.class);

		Mockito.verify(responseObserver, Mockito.times(1)).onNext(captor.capture());

		Response response = captor.getValue();
		
		assertThat(response.getWelcome(), org.hamcrest.Matchers.equalTo("I am responding from server : Hello Roop"));
	}



}

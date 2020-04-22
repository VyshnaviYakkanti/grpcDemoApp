package grpcDemoApp.unary.rpc.client.tls;

import java.io.File;

import javax.net.ssl.SSLException;

import io.grpc.netty.GrpcSslContexts;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslContextBuilder;

public class CommonMetaData {

	public static SslContext buildSslContext(String trustCertCollectionFilePath, String clientCertChainFilePath,
			String clientPrivateKeyFilePath) throws SSLException {
		SslContextBuilder builder = GrpcSslContexts.forClient();
		if (trustCertCollectionFilePath != null) {
			builder.trustManager(new File(trustCertCollectionFilePath));
		}
		if (clientCertChainFilePath != null && clientPrivateKeyFilePath != null) {
			builder.keyManager(new File(clientCertChainFilePath), new File(clientPrivateKeyFilePath));
		}
		return builder.build();
	}

}

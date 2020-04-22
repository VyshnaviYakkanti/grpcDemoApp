package grpcDemoApp.unary.rpc.server.tls;

import java.io.IOException;

public class TlsServerStartUp {

//	roopServer2048.key	 2048-bit RSA key 
//	roopServer2048.pem	 2048-bit RSA key 

	/*
	 * TLS with no mutual auth 50440
	 * C:\Users\priti\Downloads\grpcDemoApp\src\main\resources\certification\server.
	 * pem
	 * C:\Users\priti\Downloads\grpcDemoApp\src\main\resources\certification\server.
	 * key
	 */

	/*
	 * TLS with mutual auth 50440
	 * C:\Users\priti\Downloads\grpcDemoApp\src\main\resources\certification\server.
	 * pem
	 * C:\Users\priti\Downloads\grpcDemoApp\src\main\resources\certification\server.
	 * key
	 * C:\Users\priti\Downloads\grpcDemoApp\src\main\resources\certification\ca.pem
	 */

	public static void main(String[] args) throws IOException, InterruptedException {

		if (args.length < 3 || args.length > 4) {
			System.out.println("USAGE: TlsServerStartUp port certChainFilePath privateKeyFilePath "
					+ "[trustCertCollectionFilePath]\n  Note: You only need to supply trustCertCollectionFilePath if you want "
					+ "to enable Mutual TLS.");
			System.exit(0);
		}

		final TlsServer tlsServer = new TlsServer(Integer.parseInt(args[0]), args[1], args[2],
				args.length == 4 ? args[3] : null);

//		port : 50440
//		certChainFilePath : C:\Users\priti\Downloads\grpcDemoApp\src\main\resources\certification\server0.pem
//		privateKeyFilePath : C:\Users\priti\Downloads\grpcDemoApp\src\main\resources\certification\server0.key
//  	privateKeyFilePath : C:\Users\priti\Downloads\grpcDemoApp\src\main\resources\certification\ca.pem
		System.out.println("port : " + args[0]);
		System.out.println("certChainFilePath : " + args[1]);
		System.out.println("privateKeyFilePath : " + args[2]);
		if (args.length == 4) {

			System.out.println("trustCertCollectionFilePath : " + args[3]);

		}
		tlsServer.start();
		tlsServer.blockUntilShutdown();
	}

}

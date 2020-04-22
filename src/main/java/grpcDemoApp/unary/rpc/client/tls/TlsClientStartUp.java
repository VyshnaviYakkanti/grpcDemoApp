package grpcDemoApp.unary.rpc.client.tls;

public class TlsClientStartUp {

//	ca.key	2048-bit RSA key 
//	ca.pem	2048-bit RSA key 
//	client.key	 2048-bit RSA key 
//	client.pem	 2048-bit RSA key 

	/*
	 * Server is TLS with no mutual Client can connect as mutual or no mutual 
	 * Server is TLS with mutual auth then client is mandatory to pass mutual auth
	 * TLS.
	 */

	/*
	 * TLS with mutual no auth localhost 50440
	 * C:\Users\priti\Downloads\grpcDemoApp\src\main\resources\certification\ca.pem
	 */

	/*
	 * TLS with mutual auth localhost 50440
	 * C:\Users\priti\Downloads\grpcDemoApp\src\main\resources\certification\ca.pem
	 * C:\Users\priti\Downloads\grpcDemoApp\src\main\resources\certification\client.
	 * pem
	 * C:\Users\priti\Downloads\grpcDemoApp\src\main\resources\certification\client.
	 * key
	 */

	public static void main(String[] args) throws Exception {

		if (args.length < 2 || args.length == 4 || args.length > 5) {
			System.out.println("USAGE: TlsClientStartUp host port [trustCertCollectionFilePath "
					+ "[clientCertChainFilePath clientPrivateKeyFilePath]]\n  Note: clientCertChainFilePath and "
					+ "clientPrivateKeyFilePath are only needed if mutual auth is desired.");
			System.exit(0);
		}

		TlsClientStub tlsClientStub;
		switch (args.length) {
		case 2:
			/* Use default CA. Only for real server certificates. */
			System.out.println("host : " + args[0]);
			System.out.println("port : " + args[1]);
			tlsClientStub = new TlsClientStub(args[0], Integer.parseInt(args[1]),
					CommonMetaData.buildSslContext(null, null, null));
			break;
		case 3:
			/*
			 * TLS with no mutual auth
			 */
			System.out.println("host : " + args[0]);
			System.out.println("port : " + args[1]);
			System.out.println("trustCertCollectionFilePath : " + args[2]);
			tlsClientStub = new TlsClientStub(args[0], Integer.parseInt(args[1]),
					CommonMetaData.buildSslContext(args[2], null, null));
			break;
		default:

			/*
			 * TLS with mutual auth
			 */
			System.out.println("host : " + args[0]);
			System.out.println("port : " + args[1]);
			System.out.println("trustCertCollectionFilePath : " + args[2]);
			System.out.println("certChainFilePath : " + args[3]);
			System.out.println("privateKeyFilePath : " + args[4]);
			tlsClientStub = new TlsClientStub(args[0], Integer.parseInt(args[1]),
					CommonMetaData.buildSslContext(args[2], args[3], args[4]));
		}

		try {
			tlsClientStub.serverCall("Roopwati");
		} finally {
			tlsClientStub.shutdown();
		}
	}

}

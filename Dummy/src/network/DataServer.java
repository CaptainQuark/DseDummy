package network;

import java.net.Socket;

public class DataServer extends AbstractServer {

	public static void main(String[] args){
				
		DataServer server = new DataServer();
		server.runServer(5001);
	}

	@Override
	protected void startThread(Socket clientSocket) {
		new Thread(
                new DataServerWorkerRunnable(
                    clientSocket)
            ).start();	
	}
}

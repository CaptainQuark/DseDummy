package network;

import java.net.Socket;

public class CostumerRequestServer extends AbstractServer {

	public static void main(String args[]){
		
		CostumerRequestServer server = new CostumerRequestServer();
		server.runServer(5000);
	}

	@Override
	protected void startThread(Socket clientSocket) {
        new Thread(
                new CostumerRequestServerWorkerRunnable(
                    clientSocket)
            ).start();		
	}
}

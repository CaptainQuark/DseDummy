package network;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public abstract class AbstractServer {

	public void runServer(int port){
		
		ServerSocket welcomeSocket = null;
		WorkerRunnable runner = null;
		
		try {
			System.out.println("Port by constructor: " + port);
			welcomeSocket = new ServerSocket(port);
			welcomeSocket.setSoTimeout(60 * 1000);
			
			System.out.println("Port by 'welcomeSocket': " + welcomeSocket.getLocalPort());
			
			while (true) {    
				// Create the Client Socket.
				Socket clientSocket = welcomeSocket.accept();
				System.out.println("Client-socket established...");
				
				/*
				 * From here on, Runnable handles the job.
				 */
				this.startThread(clientSocket);
			}

		} catch (Exception e) {
			System.err.println("Server Error: " + e.getMessage());
			System.err.println("Localized: " + e.getLocalizedMessage());
			System.err.println("Stack Trace: " + e.getStackTrace());
			System.err.println("To String: " + e.toString());
			
		} finally{
			if(welcomeSocket != null)
				try {
					welcomeSocket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}
	
	protected abstract void startThread(Socket clientSocket);
}

package network;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public abstract class AbstractServer {

	public void runServer(int port){
		ServerSocket welcomeSocket = null;
		
		try {
			welcomeSocket = new ServerSocket(port);
			welcomeSocket.setSoTimeout(60 * 1000);
			
			while (true) {    
				// Create the Client Socket.
				Socket clientSocket = welcomeSocket.accept();
				System.out.println("Client-socket established...");
				
				// Create input and output streams to client
				ObjectOutputStream outToClient = new ObjectOutputStream(clientSocket.getOutputStream());
				ObjectInputStream inFromClient = new ObjectInputStream(clientSocket.getInputStream());

				// Create Message object and retrieve information.
				Message<?> inMsg = (Message<?>) inFromClient.readObject();

				// Do something with the Message object.
				Message<?> outMsg = null;
				outMsg = processMessage(inMsg);

				// Send the modified Message object back.
				outToClient.writeObject(outMsg);        
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
	
	public abstract Message<?> processMessage(Message<?> m);
}

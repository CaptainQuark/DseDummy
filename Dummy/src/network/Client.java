package network;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client {

	public Message<?> runClient(String host, int port, Message<?> message){
	    try {
	        // Create the socket.
	        Socket clientSocket = new Socket(host, port);
	        System.out.println("Socket created.");
	        
	        // Create the input & output streams to the server.
	        ObjectOutputStream outToServer = new ObjectOutputStream(clientSocket.getOutputStream());
	        ObjectInputStream inFromServer = new ObjectInputStream(clientSocket.getInputStream());

	        // Create The message Object to send.
	        //Message<String> message = new Message<>("REQ_DEBUG", "Debug from Client!");

	        // Send the message Object to the server.
	        outToServer.writeObject(message);            

	        // Retrieve the reply-message from server.
	        Message<?> msgFrmServer = (Message<?>) inFromServer.readObject();

	        // Do something with the received message.
	        /*
	        if(msgFrmServer.getType() instanceof String){
	        	System.out.println("The received message is of type 'String'");
	        	System.out.println("Message: " + msgFrmServer.getType());
	        }
	        */

	        clientSocket.close();

	        return msgFrmServer;
	        
	    } catch (Exception e) {
	        System.err.println("Client Error: " + e.getMessage());
	        System.err.println("Localized: " + e.getLocalizedMessage());
	        System.err.println("Stack Trace: " + e.getStackTrace());
	    }
	    
		return null;
	}
}

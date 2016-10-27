package network;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public abstract class WorkerRunnable implements Runnable {

    protected Socket clientSocket = null;

    public WorkerRunnable(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }
    
	@Override
	public void run() {

		System.out.println("New thread started.");
		System.out.println("Thread-ID: " + Thread.currentThread().getId());
		try{
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
			
			// Close the streams.
			outToClient.close();
			inFromClient.close();
			
			System.out.println("Sockets closed.");
			
		}catch(IOException e){
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
	}
	
	protected abstract Message<?> processMessage(Message<?> m);
}

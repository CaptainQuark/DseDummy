package network;

import java.net.Socket;

import helper.Tag;

public class CostumerRequestServerWorkerRunnable extends WorkerRunnable {

	public CostumerRequestServerWorkerRunnable(Socket clientSocket) {
		super(clientSocket);
	}

	@Override
	protected Message<?> processMessage(Message<?> m) {

		/*
		 * Check request tag of message and operate correspondingly.
		 */
		
		if(m.getTag().equals(Tag.REQ_DEBUG)){
			Client c = new Client();
			return c.runClient("localhost", 5001, new Message<String>(Tag.REQ_DEBUG, "Requesting data object."));
		}
		
		return null;
	}

}

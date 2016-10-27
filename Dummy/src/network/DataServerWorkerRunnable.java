package network;

import java.net.Socket;

import helper.Tag;
import main.Data;

public class DataServerWorkerRunnable extends WorkerRunnable {

	public DataServerWorkerRunnable(Socket clientSocket) {
		super(clientSocket);
	}

	@Override
	protected Message<?> processMessage(Message<?> m) {

		/*
		 * Check request tag of message and operate correspondingly.
		 */
		
		if(m.getTag().equals(Tag.REQ_DEBUG)){
			Data d = new Data(0, "DEBUG_DATA_OBJECT");
			return new Message<Data>(Tag.REQ_DEBUG, d);
		}
		
		return null;
	}

}

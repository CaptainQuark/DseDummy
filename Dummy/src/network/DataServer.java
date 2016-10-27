package network;

import helper.TAG;
import main.Data;

public class DataServer extends AbstractServer {

	public static void main(String[] args){
		
		DataServer server = new DataServer();
		server.runServer(5001);
	}

	@Override
	public Message<?> processMessage(Message<?> m) {

		/*
		 * Check request tag of message and operate correspondingly.
		 */
		if(m.getTag().equals(TAG.REQ_DEBUG)){
			Data d = new Data(0, "DEBUG_DATA_OBJECT");
			return new Message<Data>(TAG.REQ_DEBUG, d);
		}
		
		return null;
	}
}

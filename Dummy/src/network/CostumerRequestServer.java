package network;

import helper.TAG;

public class CostumerRequestServer extends AbstractServer {

	public static void main(String args[]){
		
		CostumerRequestServer server = new CostumerRequestServer();
		server.runServer(5000);
	}

	@Override
	public Message<?> processMessage(Message<?> m) {

		/*
		 * Check request tag of message and operate correspondingly.
		 */
		if(m.getTag().equals(TAG.REQ_DEBUG)){
			Client c = new Client();
			return c.runClient("localhost", 5001, new Message<String>(TAG.REQ_DEBUG, "Requesting data object."));
		}
		
		return null;
	}
}

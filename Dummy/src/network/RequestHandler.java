package network;

import java.util.ArrayList;

public class RequestHandler {
	
	public static Message<?> handleRequestStatic(final Message<?> msg){
		//DataControl c = new DataControl();
		
		/*
		 * Check the received message and operate as written.
		 * 	Operations are not limited to checking the tag only,
		 * 	the specific type variable can also be used.
		 */
		if(msg.getTag().equals("REQ_DEBUG")){
			return new Message<String>(msg.getTag(), "RequestHandler has received debug-request.");
		}
		
		return new Message<String>(msg.getTag(), "ERROR @ handleRequest : unknown request tag");
	}
}

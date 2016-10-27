package network;

import helper.TAG;
import main.Data;

public class CustomerClient extends Client {

	public static void main(String args[]){
		
		Message<String> message = new Message<>(TAG.REQ_DEBUG, "Debug from Client!");
		Message<?> returnMessage = null;
		
		CustomerClient client = new CustomerClient();
		returnMessage = client.runClient("localhost", 5000, message);
		
		if(returnMessage.getType() instanceof String){
			System.out.println("Response from server received!");
			System.out.println("Tag: " + returnMessage.getTag());
			System.out.println("Msg: " + returnMessage.getType());
		}
		
		if(returnMessage.getType() instanceof Data){
			Data d = (Data) returnMessage.getType();
			System.out.println("Response from server received (of type 'Data')!");
			System.out.println("ID: " + d.getId());
			System.out.println("Name: " + d.getName());
		}
	}
}

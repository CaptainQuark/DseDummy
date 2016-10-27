package network;

import helper.Tag;

/**
 * Class to carry information through the network.
 *
 * @param <T>
 * 			Object of generic type so a Message-object can save any type.
 */
public class Message<T> implements java.io.Serializable{
	protected final T t;
	protected final Tag REQ_TAG;
	
	public Message(Tag tag, T t){ 
		this.t = t; 
		this.REQ_TAG = tag;
	}
	
	/*
	 * Getters.
	 */
	public T getType(){ return t; }
	public Tag getTag(){ return this.REQ_TAG; }
}

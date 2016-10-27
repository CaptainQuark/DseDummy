package network;

import helper.TAG;

/**
 * Class to carry information through the network.
 *
 * @param <T>
 * 			Object of generic type so a Message-object can save any type.
 */
public class Message<T> implements java.io.Serializable{
	protected final T t;
	protected final TAG REQ_TAG;
	
	public Message(TAG tag, T t){ 
		this.t = t; 
		this.REQ_TAG = tag;
	}
	
	/*
	 * Getters.
	 */
	public T getType(){ return t; }
	public TAG getTag(){ return this.REQ_TAG; }
}

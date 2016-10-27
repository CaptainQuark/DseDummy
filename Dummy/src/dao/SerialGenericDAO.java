package dao;

import java.util.ArrayList;

public class SerialGenericDAO<T> implements GenericDAO<T> {
	
	private T t;
	private ArrayList<T> list;

	public SerialGenericDAO(T t){
		this.t = t;
		this.list = new ArrayList<T>();
	}
	
	@Override
	public void add(T t) {
		this.list.add(t);	
	}

	@Override
	public ArrayList<T> get() {
		return this.list;
	}
}

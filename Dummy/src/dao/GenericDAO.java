package dao;

import java.util.ArrayList;

public interface GenericDAO<T> {

	public void add(T t);
	public ArrayList<T> get();
}

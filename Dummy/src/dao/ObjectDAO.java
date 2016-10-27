package dao;

import java.util.ArrayList;
import java.util.Calendar;

public interface ObjectDAO<T> {
	
	public ArrayList<T> getAll();
	public void deleteObject(T t);
	public void saveObject(T t);
}

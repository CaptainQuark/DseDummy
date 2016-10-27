package main;

import java.util.HashMap;
import java.util.Map;

import dao.SerialGenericDAO;

public class DaoDummy {

	public static void main(String[] args) {

		Integer i = 10;
		String s = "Heureka!";
		
		SerialGenericDAO<Integer> iDao = new SerialGenericDAO<Integer>(i);
		SerialGenericDAO<String> sDao = new SerialGenericDAO<String>(s);
		
		iDao.add(i);
		iDao.add(20);
		sDao.add(s);
		
		for(int val : iDao.get()){
			System.out.println(val);
		}
		
		for(String str : sDao.get()){
			System.out.println(str);
		}
		
		Map<Object, SerialGenericDAO<?>> daoMap = new HashMap<>();
		
		daoMap.put(Integer.class, iDao);
		daoMap.put(String.class, sDao);
		
		for(Object index : daoMap.get(Integer.class).get())
		System.out.println(index.toString());
	}

}

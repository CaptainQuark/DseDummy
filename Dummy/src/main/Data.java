package main;

public class Data implements java.io.Serializable{

	protected int id;
	protected String name;
	
	public Data(int i, String s){
		this.id = i;
		this.name = s;
	}
	
	public int getId(){ return this.id; }
	public String getName(){ return this.name; }
}

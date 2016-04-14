package org.model;

public class Profile {
	private int id;
	private String name;
	private double  key[]= new double[102] ;
	
	public void print() {
		System.out.println(getId());
		System.out.println(getName());
		System.out.println(getKey());
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double[] getKey() {
		return key;
	}
	public void setKey(double key[]) {
		this.key = key;
	}
	

}

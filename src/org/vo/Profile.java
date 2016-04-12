package org.vo;

import java.nio.DoubleBuffer;

public class Profile {
	private int id;
	private String name;
	private double  key[]= new double[100] ;
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

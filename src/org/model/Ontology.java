package org.model;

public class Ontology {
	private int id;
	private String name;
	private int parent_id;
//	private int level;
    
	public void printOntology() {
		System.out.print(this.getId());
		System.out.print(this.getName());
		System.out.print(this.getParent_id());
//		System.out.print(this.getLevel());
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

	public int getParent_id() {
		return parent_id;
	}

	public void setParent_id(int parent_id) {
		this.parent_id = parent_id;
	}

//	public int getLevel() {
//		return level;
//	}
//
//	public void setLevel(int level) {
//		this.level = level;
//	}

}

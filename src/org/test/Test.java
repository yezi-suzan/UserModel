package org.test;

import java.util.List;

import org.dao.Dao;
import org.model.Ontology;
import org.model.Profile;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		List<Ontology> list = new Dao().findOntology();
//        System.out.println(list);
		
		Profile profile=new Dao().findProfile("guyajun8029");
		profile.print();
		
		
	}

}

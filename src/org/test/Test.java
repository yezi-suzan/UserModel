package org.test;

import java.util.List;

import org.dao.Dao;
import org.model.Ontology;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Ontology> list = new Dao().findOntology();

	}

}

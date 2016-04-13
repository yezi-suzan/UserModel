package org.dao;

import java.nio.DoubleBuffer;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.model.Ontology;
import org.model.Profile;

public class Dao {
	/*
	 * ��ȡ���ݿ�����
	 * 
	 * @return Connection����
	 */
	public Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:nysql://localhost:3306/db";
			String user = "root";
			String password = "111";
			connection = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return connection;
	}

	/*
	 * ����name��ȡ��Ȥ��
	 */
	public Profile findProfile(String name) {
		Profile profile = new Profile();
		Connection connection = getConnection();
		String sql = "select * from user_profile_2 while name=?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, name);
			ResultSet resultSet = preparedStatement.executeQuery();
			profile.setId(resultSet.getInt("id"));
			profile.setName(resultSet.getString("name"));
			double d[]=new double[100];
			for (int i = 1; i <= 100; i++) {
                 d[i]=resultSet.getDouble("key"+i);
			}
			profile.setKey(d);
			resultSet.close();
			preparedStatement.cancel();
			connection.close();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return profile;
	}
	
	/*
	 * ��ȡontology_base
	 */
	public List<Ontology> findOntology() {
		List<Ontology> list = new ArrayList<Ontology>();
		Connection connection = getConnection();
		String sql = "select * from ontology_base";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				Ontology ontology = new Ontology();
				ontology.setId(resultSet.getInt("id"));
				ontology.setName(resultSet.getString("name"));
				ontology.setParent_id(resultSet.getInt("parent_id"));
				ontology.setLevel(resultSet.getInt("level"));
				list.add(ontology);
			}
			resultSet.close();
			preparedStatement.cancel();
			connection.close();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}

}

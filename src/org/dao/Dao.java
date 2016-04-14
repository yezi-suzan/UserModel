package org.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
			String url = "jdbc:mysql://localhost:3306/db";
			String user = "root";
			String password = "123456";
			connection = DriverManager.getConnection(url, user, password);
			// System.out.println("connnected");
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
		String sql = "select * from user_profile_2 where name=?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, name);
			ResultSet resultSet = preparedStatement.executeQuery();
//			System.out.println("query success");
			while (resultSet.next()) {
				profile.setId(resultSet.getInt("Id"));
				profile.setName(resultSet.getString("name"));
				double d[] = new double[102];
				for (int i = 1; i <= 100; i++) {
					String string="key"+i;
//					System.out.println(string);
					d[i] = resultSet.getDouble(string);
//					System.out.println(d[i]);
				}
				profile.setKey(d);
				profile.print();
			}
             
			resultSet.close();
			preparedStatement.close();
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
		String sql = "select * from ontology_base limit 0,100";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			// System.out.println("sql");
			while (resultSet.next()) {
				Ontology ontology = new Ontology();
				ontology.setId(resultSet.getInt("id"));
				ontology.setName(resultSet.getString("name"));
				ontology.setParent_id(resultSet.getInt("parent_id"));
				// ontology.setLevel(resultSet.getInt("level"));
				// ontology.printOntology();
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

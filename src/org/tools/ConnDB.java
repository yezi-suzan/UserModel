package org.tools;

import java.sql.ResultSet;

import org.omg.CORBA.PUBLIC_MEMBER;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class ConnDB {
	public Connection connection = null;
	public Statement statement = null;
	public ResultSet resultSet = null;
	private static String propFileName = "connDB.properties";
    public ConnDB(){
    	try {
			 
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    }
}

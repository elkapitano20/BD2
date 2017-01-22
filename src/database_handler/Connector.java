package database_handler;

import java.sql.*;

public class Connector {
	
static final String USER = "tferens";
static final String PASS = "tferens";

static final String JDBC_DRIVER = "df";
static final String DB_URL = "jdbc:oracle:thin:@ora3.elka.pw.edu.pl:1521:ora3inf";

static Connection conn = null;
static {
	try {
		Class.forName("oracle.jdbc.OracleDriver");
	} catch (ClassNotFoundException e) {
		System.err.println("Driver not found.");
		System.exit(1);
	}
}

public void connect() {
	
	Statement stmt = null;
	
	try{
		
	System.out.println("Connecting to database...");
	Class.forName("oracle.jdbc.OracleDriver");
	conn = DriverManager.getConnection(DB_URL,USER,PASS);
	
	} catch (ClassNotFoundException e) {
		System.err.println("SQL driver not found.");
		System.exit(1);	
	}catch(SQLException sqlEx){
		sqlEx.printStackTrace();
	}catch(Exception e){
		e.printStackTrace();
	}
	
	if (conn != null) {
	    System.out.println("Connected!");
	}
}

public void disconnect(){
		try{
			if(conn!=null)
				conn.close();
		}catch(SQLException sqlEx){
			sqlEx.printStackTrace();
		}
		System.out.println("Successfully closed connection to database ...");
}
}

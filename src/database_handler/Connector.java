package database_handler;

import java.sql.*;

public class Connector {
	
static final String USER = "mkhombak";
static final String PASS = "mkhombak";

static final String DB_URL = "jdbc:oracle:thin:@ora3.elka.pw.edu.pl:1521:ora3inf";

static Connection conn = null;

public void connect() {
	
	Statement stmt = null;
	
	try{
		
	System.out.println("Connecting to database...");
	
	Class.forName("oracle.jdbc.OracleDriver");
	conn = DriverManager.getConnection(DB_URL, USER, PASS);
	
	} catch (ClassNotFoundException e) {
		System.err.println("SQL driver not found! Exiting...");
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

public ResultSet executeQuery(String query) {
	connect();
	System.out.println("Creating Statement ...");
	Statement stmt = null;
	ResultSet rs = null;
	try{
	stmt = conn.createStatement();
	String command = query.substring(0,4);
	String statement = query.substring(4,query.length());
	switch(command)
	{
	case "#upd":
		stmt.executeUpdate(statement);
		break;
	case "#del":
		break;
	case "#ins":
		break;
	case "#que":
//		System.out.println(statement);
	rs = stmt.executeQuery(statement);
	break;
		default:
			System.out.println(statement);
			throw new RuntimeException("Improper command selected");
	}
	return rs;
	}catch (SQLException sqlEx){
		System.out.println("Couldn't prepare statement");
		sqlEx.printStackTrace();
	}
	disconnect();
	return rs;
}
public void executeUpdateWrapper(String query) {
	String q = "#upd"+query;
	executeQuery(q);
}
}

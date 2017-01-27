package database_handler;

import java.sql.*;
import java.util.Vector;
import java.math.*;
/*
 * Describes Connector class. 
 * It is defined as singleton and provides wrappers for Database Connection operations with JDBC
 */
public class Connector {
	
static final String USER = "mkhombak";
static final String PASS = "mkhombak";

static final String DB_URL = "jdbc:oracle:thin:@ora3.elka.pw.edu.pl:1521:ora3inf";

protected Connector() {
    // Exists only to defeat instantiation.
 }

static Connection conn = null;
//handle for global instance of singleton
public static Connector instance = null;

public static Connector getInstance(){
	if(instance == null){
		instance = new Connector();
	}
	return instance;
}

public void connect() {
	
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

public ResultSet executeDB(String query, Vector<String> args) {
	connect();
	System.out.println("Creating Statement ...");
	PreparedStatement stmt = null;
	ResultSet rs = null;
	try{
		//Extract the command prefix and statement
	String command = query.substring(0,4);
	String statement = query.substring(4,query.length());
	
	stmt = conn.prepareStatement(statement);
	switch(command)
	{
	case "#upd":
		System.out.println(statement);

		stmt.setLong(1,Integer.parseInt(args.elementAt(0)));
		for(int i=1; i<args.size(); i++)
		{
			stmt.setString(i+1,args.elementAt(i));//args for prepared stmts are indexed from 1!
		}
		stmt.executeUpdate();
		break;
	case "#del":
		break;
	case "#ins":
		break;
	case "#que":
	rs = stmt.executeQuery(statement);
	break;
		default:
			System.out.println(statement);
			throw new RuntimeException("Improper command selected");
	}

	if(stmt != null)
		stmt.close();
	
	}catch (SQLException sqlEx){
		System.out.println("Couldn't prepare statement");
		sqlEx.printStackTrace();
	}
	disconnect();
	return rs;
}
}

package database_handler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

/*
 * Describes Connector class. 
 * It is defined as singleton and provides wrappers for Database Connection operations with JDBC
 */
public class Connector {

	static final String USER = "mkhombak";
	static final String PASS = "mkhombak";

	static final String DB_URL = "jdbc:oracle:thin:@ora3.elka.pw.edu.pl:1521:ora3inf";
	PreparedStatement stmt = null;
	static Connection conn = null;
	// handle for global instance of singleton
	public static Connector instance = null;

	
	protected Connector() {
		// Exists only to defeat instantiation.
	}


	public static Connector getInstance() {
		if (instance == null) {
			instance = new Connector();
		}
		return instance;
	}

	public void connect() {

		try {
			System.out.println("Connecting to database...");

			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

		} catch (ClassNotFoundException e) {
			System.err.println("SQL driver not found! Exiting...");
			System.exit(1);
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (conn != null) {
			System.out.println("Connected!");
		}
	}

	public void disconnect() {
		try {
			if (conn != null)
				conn.close();
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		}
		try {
			if (stmt!=null)
				stmt.close();
		} catch (SQLException e){
			e.printStackTrace();
		}
		System.out.println("Successfully closed connection to database ...");
	}

	public void executeDB(String query, Vector<String> args) {
		connect();
		System.out.println("Creating Statement ...");
		stmt = null;
		try {
			// Extract the command prefix and statement
			String command = query.substring(0, 4);
			String statement = query.substring(4, query.length());

			stmt = conn.prepareStatement(statement);
			switch (command) {
			case "#upd":

				stmt.setLong(1, Integer.parseInt(args.elementAt(0)));
				for (int i = 1; i < args.size(); i++) {
					stmt.setString(i + 1, args.elementAt(i));// args for
																// prepared
																// stmts are
																// indexed from
																// 1!
				}
				stmt.executeUpdate();
				break;
			case "#del":
				break;
			case "#ins":
				for (int i = 0; i < args.size(); i++) {
					try{
						stmt.setDouble(i+1, Double.parseDouble(args.elementAt(i)));
					}catch (Exception e){
						stmt.setString(i + 1, args.elementAt(i));
					}
				}
				stmt.executeUpdate();
				break;
			default:
				System.out.println(statement);
				throw new RuntimeException("Improper command selected");
			}

			if (stmt != null)
				stmt.close();

		} catch (SQLException sqlEx) {
			System.out.println("Couldn't prepare statement");
			sqlEx.printStackTrace();
		}
		disconnect();
	}

	/**
	 * Przed wywolaniem nalezy wyonaj funkcje connect a nastepnie disconnect.
	 * 
	 * @param query
	 * @param args
	 * @return
	 */
	public ResultSet executeQuery(String query, Vector<String> args) {
		stmt = null;
		ResultSet rs = null;
		try {

			stmt = conn.prepareStatement(query);
			if(args != null){
				for (int i = 0; i < args.size(); i++) {
					try {
						stmt.setString(i + 1, args.elementAt(i));
					} catch (Exception e) {
						try{
							stmt.setInt(i + 1, Integer.parseInt(args.elementAt(i)));
						}catch(Exception e1){
							stmt.setFloat(i + 1, Float.parseFloat(args.elementAt(i)));
						}
					}
				}
			}
			rs = stmt.executeQuery();

		} catch (SQLException sqlEx) {
			System.out.println("Couldn't prepare statement");
			sqlEx.printStackTrace();
		}
		return rs;
	}
	
	public Connection getConnection(){
		return conn;
	}

}

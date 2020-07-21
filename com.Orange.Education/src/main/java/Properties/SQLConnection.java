package Properties;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.sql.Connection;

public class SQLConnection {
	private static Connection connection = null;
	//private static String username = "root";
	//private static String password = "Dima650065";
	//private static String dbUrl = "jdbc:mysql://127.0.0.1:3306/emp";
	public static String mysqldriver = "com.mysql.jdbc.Driver";
	private static boolean print = false;

	public static void setPrint(boolean p) {
		print = p;
	}

	String SqlQuery = "select * from emp.employee where name = 'Admin';";

	public static Connection getDBConnection(String dbUrl, String username, String password) {
		Connection dbConnection = null;
		try {
			Class.forName(mysqldriver);
		} catch (Exception e) {
			System.out.println("FAIL");
		}
		try {
			dbConnection = DriverManager.getConnection(dbUrl, username, password);
		} catch (

		SQLException e) {

			e.printStackTrace();
		}
		return dbConnection;
	}

	public static void connect(String dbUrl,String username, String password) {
		if (connection == null) {
			connection = getDBConnection(dbUrl,username,password);
		}
	}

	public static ResultSet select(String query) throws SQLException {
		ResultSet result = null;
		PreparedStatement stmt = null;
		try {
			if (print) {
				System.out.println("started: " + query);
			}
			stmt = connection.prepareStatement(query);
			result = stmt.executeQuery();
			while (result.next()) {
				String Name = result.getString(1);
				String Age = result.getString(2);
				System.out.println(Name + "  " + Age);

				System.out.println("complete: " + query);
				System.out.println(result.getString(1));
				return result;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public static boolean execute(String query) {
		boolean result = false;
		Statement stmt = null;
		try {
			System.out.println("started: " + query);
			stmt = connection.createStatement();
			stmt.executeUpdate(query);
			result = true;

			System.out.println("complete: " + query);
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return result;

	}

	public static void close() {
		try {
			connection.close();
			connection = null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
		}

	}
}

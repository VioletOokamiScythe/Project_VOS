import java.io.*;
import java.net.*;
import java.sql.*;
import java.text.*;

public class DB {
	static String SQLEXECUTER;
	static ResultSet rs1;
	static ResultSet rs2;
	static String Name;
	static String URL = "jdbc:sqlserver://211.250.161.63:1433;database=VOS;integreatedSercurity=true";

	public static ResultSet student(String role, String id, String PW, String Name, String Major) {
		if (role.contentEquals("0"))
			SQLEXECUTER = "select from Client_S_INFO_TABLE WHERE id='" + id;
		else if (role.contentEquals("1"))
			SQLEXECUTER = "insert into Client_S_INFO_TABLE values('" + id + "','" + PW + "','" + Name + "','" + Major
					+ "')";
		else if (role.contentEquals("2"))
			SQLEXECUTER = "delete from Client_S_INFO_TABLE WHERE ID='" + id + "'";

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Connection con = DriverManager.getConnection(URL, "student", "1111");
			Statement stmt = con.createStatement();
			System.out.println("Successful connection to SQL Server.");
			stmt.executeUpdate(SQLEXECUTER);
			System.out.println("Query operation was successful.");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Failed connection to SQL Server.");

			// TODO: handle exception
		}
		return rs1;
	}

	public static ResultSet professor(String role, String id, String PW, String Name, String Major) {
		if (role.contentEquals("0"))
			SQLEXECUTER = "select from Client_P_INFO_TABLE WHERE id='" + id;

		else if (role.contentEquals("1"))
			SQLEXECUTER = "insert into Client_P_INFO_TABLE values('" + id + "','" + PW + "','" + Name + "','" + Major
					+ "')";
		else if (role.contentEquals("2"))
			SQLEXECUTER = "delete from Client_P_INFO_TABLE WHERE ID='" + id + "'";

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Connection con = DriverManager.getConnection(URL, "professor", "1111");
			Statement stmt = con.createStatement();
			System.out.println("Successful connection to SQL Server.");
			stmt.executeUpdate(SQLEXECUTER);
			System.out.println("Query operation was successful.");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Failed connection to SQL Server.");

			// TODO: handle exception
		}
		return rs1;
	}

	public static void Check_EC_Duplicate(String ExamCode) {

	}

	public static void Check_ET_Duplicate(String ExamTime) {

	}

	public static void Check_ER_Duplicate(String ExamRoom) {

	}

	public static void CreateEXAM(String ExamCode, String ExamTime, String ExamRoom, String Host_IP) {
		SQLEXECUTER = "CREATE TABLE [" + ExamCode + "](EXAMCODE char(6) NOT NULL)";

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Connection con = DriverManager.getConnection(URL, "professor", "1111");
			Statement stmt = con.createStatement();
			System.out.println("Successful connection to SQL Server.");
			stmt.executeUpdate(SQLEXECUTER);
			System.out.println("Query operation was successful.");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Failed connection to SQL Server.");

			// TODO: handle exception
		}

		SQLEXECUTER = "Insert into ";

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

		} catch (ClassNotFoundException e) { // TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Connection con = DriverManager.getConnection(URL, "professor", "1111");
			Statement stmt = con.createStatement();
			System.out.println("Successful connection to SQL Server.");
			stmt.executeUpdate(SQLEXECUTER);
			System.out.println("Query operation was successful.");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Failed connection to SQL Server.");

			// TODO: handle exception }
		}
	}

	public static void Drop(String ExamCode, String ExamTime, String ExamRoom) {
		SQLEXECUTER = "DROP TABLE [" + ExamCode + "]";

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Connection con = DriverManager.getConnection(URL, "professor", "1111");
			Statement stmt = con.createStatement();
			System.out.println("Successful connection to SQL Server.");
			stmt.executeUpdate(SQLEXECUTER);
			System.out.println("Query operation was successful.");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Failed connection to SQL Server.");

			// TODO: handle exception
		}
		SQLEXECUTER = "DELETE [" + ExamCode + "] where EXAM_INFO_TABLE";

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Connection con = DriverManager.getConnection(URL, "professor", "1111");
			Statement stmt = con.createStatement();
			System.out.println("Successful connection to SQL Server.");
			stmt.executeUpdate(SQLEXECUTER);
			System.out.println("Query operation was successful.");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Failed connection to SQL Server.");

			// TODO: handle exception
		}
	}

	public static ResultSet checkTESTCODE(String ExamCode) {
		SQLEXECUTER = "Select From [" + ExamCode + "] Where EXAM_INFO_TABLE";

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Connection con = DriverManager.getConnection(URL, "professor", "1111");
			Statement stmt = con.createStatement();
			System.out.println("Successful connection to SQL Server.");
			stmt.executeUpdate(SQLEXECUTER);
			System.out.println("Query operation was successful.");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Failed connection to SQL Server.");

			// TODO: handle exception
		}
		return rs1;
	}
}

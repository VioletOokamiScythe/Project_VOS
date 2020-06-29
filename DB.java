import java.io.*;
import java.net.*;
import java.sql.*;
import java.text.*;

public class DB {
	static String SQLEXECUTER;
	static ResultSet rs;
	static String Name;
	static String URL = "jdbc:sqlserver://VioletOokamiScythe.iptime.org:1433;database=VOS;integreatedSercurity=true";

	static String Code;
	static String Room;
	static String Time;

	public ResultSet student(String role, String id, String PW, String Name, String Major) {
		if (role.contentEquals("0"))
			SQLEXECUTER = "select from Client_S_INFO_TABLE WHERE id=" + id;
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
			if (role.contentEquals("1")) {
				SQLEXECUTER = "CREATE TABLE [" + id
						+ "](EXAMCODE char(6) NOT NULL,EXAMROOM nvarchar(MAX) NOT NULL, EXAMTIME datetime2(0) NOT NULL)";
				stmt.executeUpdate(SQLEXECUTER);
			}
			new Dial(1);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Failed connection to SQL Server.");

			// TODO: handle exception
		}
		return rs;
	}

	public ResultSet professor(String role, String id, String PW, String Name, String Major) {
		if (role.contentEquals("0"))
			SQLEXECUTER = "select from Client_P_INFO_TABLE WHERE id='" + id + "'";

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

			if (role.contentEquals("1")) {
				SQLEXECUTER = "CREATE TABLE [" + id
						+ "](SUBJECTCODE char(10) NOT NULL PRIMARY KEY,EXAMCODE char(6) NOT NULL,EXAMROOM nvarchar(MAX) NOT NULL, EXAMTIME datetime2(0) NOT NULL)";
				stmt.executeUpdate(SQLEXECUTER);
			}
			new Dial(1);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Failed connection to SQL Server.");

			// TODO: handle exception
		}
		return rs;
	}

	public ResultSet Check_EC_Duplicate(String ExamCode) {
		SQLEXECUTER = "select from EXAM_INFO_TABLE WHERE EXAM_CODE = '" + ExamCode + "'";
		boolean confirm = false;

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			Connection con = DriverManager.getConnection(URL, "professor", "1111");
			PreparedStatement pstmt = con.prepareStatement(SQLEXECUTER);
			System.out.println("Successful connection to SQL Server.");
			pstmt.setString(1, ExamCode); // int형이면 setInt로 바꿔주세요
			ResultSet checkTable = pstmt.executeQuery();
			while (checkTable.next()) {
				String check = checkTable.getString(1); // 혹시 찾으려는 정보가 테이블의 1번째가 아닌 다른 번째에 있으면 바꿔주세요
				if (check.equals(ExamCode))
					confirm = true; // 중복 발견
			}
			System.out.println("Query operation was successful.");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Failed connection to SQL Server.");
		}
		if (confirm == true) { // 중복 있음
			new Dial(7);
		} else if (confirm == false) { // 중복 없음

		}

		return rs;
	}

	public ResultSet Check_Duplicate(String ExamRoom, String ExamTime) {
		SQLEXECUTER = "select from EXAM_INFO_TABLE WHERE EXAM_ROOM = " + ExamRoom + " AND EXAM_TIME" + ExamTime;
		boolean confirm = false;

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			Connection con = DriverManager.getConnection(URL, "professor", "1111"); // 추가 필요
			PreparedStatement pstmt = con.prepareStatement(SQLEXECUTER);
			System.out.println("Successful connection to SQL Server.");
			pstmt.setString(1, ExamTime); // int형이면 setInt로 바꿔주세요
			ResultSet checkTable = pstmt.executeQuery();
			while (checkTable.next()) {
				String check = checkTable.getString(4); // 혹시 찾으려는 정보가 테이블의 1번째가 아닌 다른 번째에 있으면 바꿔주세요
				Room = check;
				String check2 = checkTable.getString(5);
				Time = check2;
				if (check.equals(ExamRoom) && check2.equals(ExamTime))
					confirm = true; // 중복 발견
			}
			System.out.println("Query operation was successful.");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Failed connection to SQL Server.");
		}
		if (confirm == true) { // 중복 있음
			new Dial(8);
		} else if (confirm == false) { // 중복 없음

		}
		return rs;
	}

	public void CreateEXAM(String ExamCode, String Host_IP, String ExamRoom, String ExamTime) {
		SQLEXECUTER = "CREATE TABLE [" + ExamCode
				+ "](Student_Name nvarchar(MAX) NOT NULL,Studend_ID char(10) NOT NULL,Target_IP char(15))";

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

		SQLEXECUTER = "insert into EXAM_INFO_TABLE values('" + ExamCode + "','" + Host_IP + "','" + ExamRoom + "','"
				+ ExamTime + "')";

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

	public void Drop(String ExamCode) {
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
}

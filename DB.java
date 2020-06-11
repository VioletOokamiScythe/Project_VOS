import java.io.*;
import java.net.*;
import java.sql.*;

public class DB {
    static String UserList;
	static String UserInfo;
	static ResultSet rs1;
    static ResultSet rs2;
    
    public static ResultSet actionUserList(String role, String id, String PW){
        if (role.contentEquals("0")) {
			UserList = "select from Client_S_INFO_TABLE WHERE id='" + id;

		} else if (role.contentEquals("1")) {
			UserList = "insert into Client_S_INFO_TABLE values('" + id + "'," + "'" + PW + "')";

		} else if (role.contentEquals("2")) {
			UserList = "delete from Client_S_INFO_TABLE WHERE ID='" + id + "'";

        }

        String URL = "jdbc:sqlserver://211.250.161.63:1433;database=VOS;integreatedSercurity=true";

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Connection con = DriverManager.getConnection(URL, "stuent", "1111");
			Statement stmt = con.createStatement();
			System.out.println("Successful connection to SQL Server.");
			stmt.executeUpdate(UserList);
			System.out.println("Query operation was successful.");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Failed connection to SQL Server.");

			// TODO: handle exception
		}
		return rs1;
    }
}
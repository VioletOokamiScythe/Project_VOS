import java.sql.*;
import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        new DB();
        DB.student("1", "1234", "1234", "김의종", "컴퓨터공학부");
    }
        
}


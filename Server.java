import java.sql.*;
import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        new DB();
        DB.Drop("7F00FF", "1234", "1234");
    }
        
}


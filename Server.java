import java.sql.*;
import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Server {
    ServerSocket ss = null;
    ArrayList<ConnectedClient> clients = new ArrayList<ConnectedClient>();
    
    public static void main(String[] args) {
        Server server = new Server();
        try {
            server.ss = new ServerSocket(5656);
            System.out.println("Server Socket is created");
            while(true) {
                Socket socket = server.ss.accept(); //소켓 생성
                ConnectedClient cc = new ConnectedClient(socket);
                server.clients.add(cc);
                cc.start();
            }
        } catch(Exception e) {

        }
        
    }
        
}

class ConnectedClient extends Thread {
    Socket socket;
    OutputStream outStream;
    DataOutputStream dataOutStream;
    InputStream inStream;
    DataInputStream dataInStream;
    
    String role;
    String ID;
    String PW;
    String Name;
    String Major;
    DB DB = new DB();

    ConnectedClient(Socket _s) {
        this.socket = _s;
    }

    public void run() {
        try {
            System.out.println(this.socket.toString() + "에서 연결되었습니다.");
            outStream = this.socket.getOutputStream();
            dataOutStream = new DataOutputStream(outStream);
            inStream = this.socket.getInputStream();
            dataInStream = new DataInputStream(inStream);
            while(true) {
                String User = dataInStream.readUTF();
                StringTokenizer st = new StringTokenizer(User, "/");
                role = st.nextToken();
                ID = st.nextToken();
                PW = st.nextToken();
                Name = st.nextToken();
                Major = st.nextToken();
                DB.student(role, ID, PW, Name, Major);
            }
        } catch (Exception e) {

        }
    }
}

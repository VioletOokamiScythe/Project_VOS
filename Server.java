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
            server.ss = new ServerSocket(8484);
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
    String Identity;
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
                Identity = st.nextToken();
                role = st.nextToken();
                ID = st.nextToken();
                PW = st.nextToken();
                if (role.contentEquals("0") || role.contentEquals("2")) {
                    Name = "";
                    Major = "";
                }
                else if (role.contentEquals("1")) {
                    Name = st.nextToken();
                    Major = st.nextToken();
                }
                if (Identity.contentEquals("Student")) DB.student(role, ID, PW, Name, Major);
                else if (Identity.contentEquals("Professor")) DB.professor(role, ID, PW, Name, Major);
            }
        } catch (Exception e) {

        }
    }
}

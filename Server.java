import java.io.*;
import java.net.*;
import java.sql.*;
import java.util.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Server {
    ServerSocket ss = null;
    ArrayList<Login> clients = new ArrayList<Login>();

    public static void main(String[] args) {
        Server server = new Server();
        try {
            server.ss = new ServerSocket(5656);
            System.out.println("Server Socket is created");
            while (true) {
                Socket socket = server.ss.accept(); // 소켓 생성
                Login cc = new Login(socket);
                server.clients.add(cc);
                cc.start();
            }
        } catch (Exception e) {

        }

    }

}

class Login extends Thread {
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
    String Code;
    String Room;
    String Time;
    DB DB = new DB();

    Login(Socket _s) {
        this.socket = _s;
    }

    public void run() {
        try {
            System.out.println(this.socket.toString() + "에서 연결되었습니다.");
            outStream = this.socket.getOutputStream();
            dataOutStream = new DataOutputStream(outStream);
            inStream = this.socket.getInputStream();
            dataInStream = new DataInputStream(inStream);

            while (true) {
                String User = dataInStream.readUTF();
                StringTokenizer st = new StringTokenizer(User, "/");
                String mission = st.nextToken();
                switch (mission) {
                    case "LORC":
                        LoginORCreate(st);
                        break;

                    case "File":
                        break;

                    case "Check":
                        Check_TC(st);
                        break;

                    default:
                        break;
                }
            }
        } catch (Exception e) {

        }
    }

    void LoginORCreate(StringTokenizer st) {
        Identity = st.nextToken();
        role = st.nextToken();
        ID = st.nextToken();
        PW = st.nextToken();

        switch (role) {
            case "0":
                Name = "";
                Major = "";
                if (Identity.contentEquals("Student"))
                    DB.student(role, ID, PW, Name, Major);
                else if (Identity.contentEquals("Professor"))
                    DB.professor(role, ID, PW, Name, Major);
                break;

            case "1":
                Name = st.nextToken();
                Major = st.nextToken();
                if (Identity.contentEquals("Student"))
                    DB.student(role, ID, PW, Name, Major);
                else if (Identity.contentEquals("Professor"))
                    DB.professor(role, ID, PW, Name, Major);
                break;

            case "2":
                Name = "";
                Major = "";
                if (Identity.contentEquals("Student"))
                    DB.student(role, ID, PW, Name, Major);
                else if (Identity.contentEquals("Professor"))
                    DB.professor(role, ID, PW, Name, Major);
                break;
            default:
                break;
        }
    }

    void Check_TC(StringTokenizer st) {
        role = st.nextToken();
        String ExamCode = st.nextToken();

        ResultSet Result;

        switch (role) {
            case "0":
                Result = DB.Check_EC_Duplicate(ExamCode);
                try {
                    if (Result.next()) {
                        new Dial(7);
                    } else {
                        try {
                            outStream = this.socket.getOutputStream();
                            dataOutStream = new DataOutputStream(outStream);
                            dataOutStream.writeInt(0);
                        } catch (Exception e) {
                            // TODO: handle exception
                        }

                    }
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                break;

            default:
                break;
        }
    }

    public class FileReceive {
        public static final int DEFAULT_BUFFER_SIZE = 10000;

        public void main(String[] args) {
            int port = Integer.parseInt("8484");
            String filename = args[1];

            try {
                ServerSocket server = new ServerSocket(port);
                Socket socket = server.accept();
                InetSocketAddress ISA = (InetSocketAddress) socket.getRemoteSocketAddress();

                System.out.println("A client(" + ISA.getAddress().getHostAddress() + " is connected. (Port: "
                        + ISA.getPort() + ")");

                FileOutputStream fos = new FileOutputStream(filename);
                InputStream is = socket.getInputStream();

                double startTime = System.currentTimeMillis();
                byte[] buffer = new byte[DEFAULT_BUFFER_SIZE];
                int readBytes;
                while ((readBytes = is.read(buffer)) != -1) {
                    fos.write(buffer, 0, readBytes);

                }
                double Timeend = System.currentTimeMillis();
                double diffTime = (Timeend - startTime) / 1000;
                ;

                System.out.println("time: " + diffTime + " second(s)");

                is.close();
                fos.close();
                socket.close();
                server.close();
            } catch (IOException e) {

                e.printStackTrace();
            }
        }
    }

    public class FileSend {
        public static final int DEFAULT_BUFFER_SIZE = 10000;

        public void main(String[] args) {
            String serverIP = "VioletOokamiScythe.iptime.org";
            int port = Integer.parseInt("8484");
            String FileName = "text.txt";

            File file = new File(FileName);
            if (!file.exists()) {
                System.out.println("File not Exist.");
                System.exit(0);
            }

            long fileSize = file.length();
            long totalReadBytes = 0;
            byte[] buffer = new byte[DEFAULT_BUFFER_SIZE];
            int readBytes;
            double startTime = 0;

            try {
                FileInputStream fis = new FileInputStream(file);
                Socket socket = new Socket(serverIP, port);
                if (!socket.isConnected()) {

                    System.exit(0);
                }

                startTime = System.currentTimeMillis();
                OutputStream os = socket.getOutputStream();
                while ((readBytes = fis.read(buffer)) > 0) {
                    os.write(buffer, 0, readBytes);
                    totalReadBytes += readBytes;
                    System.out.println("In progress: " + totalReadBytes + "/" + fileSize + " Byte(s) ("
                            + (totalReadBytes * 100 / fileSize) + " %)");
                }

                System.out.println("전송 완료");
                fis.close();
                os.close();
                socket.close();
            } catch (UnknownHostException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

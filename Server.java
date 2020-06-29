import java.io.*;
import java.net.*;
import java.sql.*;
import java.util.*;

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
                    case "SLogin":
                        SLogin(st);
                        break;

                    case "SRegist":
                        SRegist(st);
                        break;

                    case "SSecession":
                        SSecession(st);
                        break;

                    case "PLogin":
                        PLogin(st);
                        break;

                    case "PRegist":
                        PRegist(st);
                        break;

                    case "PSecession":
                        PSecession(st);
                        break;

                    case "Check":
                        Check_TC(st);
                        break;

                    case "Create":
                        CreateE(st);
                        break;

                    case "Drop":
                        DropE(st);
                        break;

                    case "SModify":
                        SModifyINFO(st);
                        break;

                        case "PModify":
                        PModifyINFO(st);
                        break;

                    default:
                        break;
                }
            }
        } catch (Exception e) {

        }
    }

    void SLogin(StringTokenizer st) {
        ID = st.nextToken();
        PW = st.nextToken();

        ResultSet rs;

        rs = DB.student_Login(ID, PW);
    }

    void SRegist(StringTokenizer st) {
        ID = st.nextToken();
        PW = st.nextToken();
        Name = st.nextToken();
        Major = st.nextToken();

        DB.Student_Create(ID, PW, Name, Major);
    }

    void SSecession(StringTokenizer st) {
        ID = st.nextToken();

        DB.Student_Remove(ID);
    }

    void PLogin(StringTokenizer st) {
        ID = st.nextToken();
        PW = st.nextToken();

        ResultSet rs;

        rs = DB.Professor_Login(ID, PW);
    }

    void PRegist(StringTokenizer st) {
        ID = st.nextToken();
        PW = st.nextToken();
        Name = st.nextToken();
        Major = st.nextToken();

        DB.Professor_Create(ID, PW, Name, Major);
    }

    void PSecession(StringTokenizer st) {
        ID = st.nextToken();

        DB.Professor_Remove(ID);
    }

    void Check_TC(StringTokenizer st) {
        String ExamCode = st.nextToken();

        ResultSet Result;

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
                    e.printStackTrace();
                }

            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    void Check_EI(StringTokenizer st) {
        String ExamRoom = st.nextToken();
        String ExamTime = st.nextToken();

        ResultSet Result;

        Result = DB.Check_Duplicate(ExamRoom, ExamTime);
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
                    e.printStackTrace();
                }

            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    void CreateE(StringTokenizer st) {
        String ExamCode = st.nextToken();
        String Host_IP = st.nextToken();
        String ExamRoom = st.nextToken();
        String ExamTime = st.nextToken();

        DB.CreateEXAM(ExamCode, Host_IP, ExamRoom, ExamTime);
    }

    void DropE(StringTokenizer st) {
        String ExamCode = st.nextToken();
        DB.Drop(ExamCode);
    }

    void SModifyINFO(StringTokenizer st) {
        ID = st.nextToken();
        PW = st.nextToken();
        Name = st.nextToken();
        Major = st.nextToken();
        String NID = st.nextToken();
        String NPW = st.nextToken();
        String NName = st.nextToken();
        String NMajor = st.nextToken();

        DB.Modify(ID, PW, Name, Major, NID, NPW, NName, NMajor);
        DB.Rename_Table(ID, NID);
    }
    
    void PModifyINFO(StringTokenizer st) {
        ID = st.nextToken();
        PW = st.nextToken();
        Name = st.nextToken();
        Major = st.nextToken();
        String NID = st.nextToken();
        String NPW = st.nextToken();
        String NName = st.nextToken();
        String NMajor = st.nextToken();

        DB.Modify(ID, PW, Name, Major, NID, NPW, NName, NMajor);
        DB.Rename_Table(ID, NID);
    }
}

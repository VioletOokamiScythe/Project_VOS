import java.io.*;
import java.net.*;
import java.util.*;

public class Server_Image extends Thread {

     
     ArrayList<Image> clients = new ArrayList<Image>();

     public static void main(String[] args) {
          Server_Image SI = new Server_Image();
          ServerSocket SS = null;
          
          try {
               SS=new ServerSocket(5656);
               while (true) {
                    Socket S = SS.accept();
                    Image CI=new Image(S);
                    SI.clients.add(CI);
                    CI.start();

               }

          } catch (Exception e) {
               e.printStackTrace();
          }

     }

}

class Image extends Thread {
     Socket socket;

     Image(Socket S){
          this.socket=S;
     }

     public void run() {
          try {
               System.out.println(this.socket.toString()+"애서 이미지를 전송할 준비가 되었습니다.");

          } catch (Exception e) {

          }
     }
}

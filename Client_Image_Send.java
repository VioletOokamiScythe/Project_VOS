import java.io.*;
import java.net.*;
import java.awt.*;

public class Client_Image_Send {
     
     public static void main(String[] args) {
          Server_Image SI = new Server_Image();
          ServerSocket SS = null;

          try {
               SS = new ServerSocket(5656);
               
               while (true) {
                    Socket S = SS.accept();
                    Image CI = new Image(S);
                    CI.start();
               }

          } catch (Exception e) {
               e.printStackTrace();
          }
     }
}

class Image extends Thread {
     Socket socket;

     Image(Socket S) {
          this.socket = S;
     }

     public void run() {
          try {
               

          } catch (Exception e) {

          }
     }
}

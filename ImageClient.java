import java.io.*;
import java.net.*;
import java.awt.*;
import java.util.*;
import java.awt.image.*;
import javax.imageio.ImageIO;

public class ImageClient {
     public static String ID;

     public static void main(String[] args) {
          try {
               Socket S=new Socket("violetookamiscythe.iptime.org",5656);
               

               Dial dial=new Dial(12);               
               ID=dial.getCode();

               SendThread ST=new SendThread(S);
               ST.start();

               ReceiveThread RT=new ReceiveThread(S);
               RT.start();
          } catch (Exception e) {
               //TODO: handle exception
          }
     }
}

class SendThread extends Thread{

     Socket socket;
     SendThread(Socket S){
          socket=S;
     }

     @Override
     public void run() {
          // TODO Auto-generated method stub
          super.run();

          try {
               BufferedReader BR=new BufferedReader(new InputStreamReader(System.in));
               PrintWriter PW=new PrintWriter((socket.getOutputStream()));

               String Message;

               PW.println("ID/"+ImageClient.ID);
               PW.flush();

               while (true) {
                    Message=BR.readLine();

                    if (Message.equals("EXIT")) {
                         break;
                    }

                    PW.println(Message);
                    PW.flush();
               }

               PW.close();
               BR.close();
               socket.close();

          } catch (Exception e) {
               //TODO: handle exception

               e.printStackTrace();
          }
     }
}

class ReceiveThread extends Thread{

     Socket socket;
     ReceiveThread(Socket S){
          socket=S;
     }

     @Override
     public void run() {
          // TODO Auto-generated method stub
          super.run();
          try {
               BufferedReader BR=new BufferedReader(new InputStreamReader(socket.getInputStream()));

               String Message;
               String[] split;

               while (true) {
                    Message=BR.readLine();
                    split=Message.split(">");
                    if (split.length >= 2 && split[0].equals(ImageClient.ID)) {
                         continue;
                    }
                    System.out.println(Message);
               }
          } catch (Exception e) {
               //TODO: handle exception
          }
     }
}

class ImageCreator extends Thread{
     
}
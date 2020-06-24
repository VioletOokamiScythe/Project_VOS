import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;

public class Client_T_Guest{

     Dial dial = new Dial(6);

     final int w = Toolkit.getDefaultToolkit().getScreenSize().width,
               h = Toolkit.getDefaultToolkit().getScreenSize().height;


     public static void main(String[] args) {
          new Client_T_Guest();
     }

     // 메인에서 호출시킨 생성자부분

     public Client_T_Guest() {

          String serverip = dial.getCode();
          Socket socket = null;
          System.out.println("클라이언트 준비완료");// 일단 소켓생성

          try {

               socket = new Socket(serverip, 5656);
               System.out.println("접속완료 - 클라이언트");

               BufferedImage image; // 스크린샷이 저장될 버퍼공간
               Robot r = new Robot(); // 스크린샷을 찍는 로봇클래스
               BufferedOutputStream bout = new BufferedOutputStream(socket.getOutputStream());

               // 아웃풋스트림을 버퍼아웃풋으로

               while (true) {

                    image = r.createScreenCapture(new Rectangle(0, 0, w/2, h));
                    // 스크린샷을 찍어서 image에 저장해
                    ImageIO.write(image, "JPEG", bout);// 그 이미지를 png파일로 소켓 아웃풋스트림으로 쏴줌
                    bout.flush(); // 버퍼에 쓰인 이미지를 서버로 보냄
               }
          } catch (Exception e) {
               e.printStackTrace(); // 오류 처리
               System.out.println("접속실패 - 클라이언트");
          }
     }

     class bot extends Thread{
          Robot robot;

          public void run() {
               
          }
     }
}
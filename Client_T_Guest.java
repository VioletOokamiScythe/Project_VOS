import java.io.*;
import java.net.*;
import java.util.*;
import java.awt.*;
import java.awt.image.*;
import java.awt.datatransfer.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import javax.imageio.*;

public class Client_T_Guest {

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
               System.out.println("접속완료");
              

               BufferedImage image; // 스크린샷이 저장될 버퍼공간
               Robot r = new Robot(); // 스크린샷을 찍는 로봇클래스
               BufferedOutputStream BOS = new BufferedOutputStream(socket.getOutputStream());
               

               while (true) {
                    BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                    String str;

                    str = br.readLine();

                    StringTokenizer st = new StringTokenizer(str, "/");
                    String mission = st.nextToken();

                    switch (mission) {
                         case "MOUSECLICK":
                         int x=Integer.parseInt(st.nextToken());
                         int y=Integer.parseInt(st.nextToken());
                         r.mouseMove(x, y);
                         r.mousePress(InputEvent.BUTTON1_MASK);
                         r.mouseRelease(InputEvent.BUTTON1_MASK);
                              break;

                         case "SARR":
                              Clipboard CB = Toolkit.getDefaultToolkit().getSystemClipboard();
                              String Answer = st.nextToken();
                              if (Answer != null) {
                                   StringSelection contents = new StringSelection(Answer);
                                   CB.setContents(contents, null);
                              }
                              Transferable Target = CB.getContents(CB);
                              if (Target != null) {
                                   r.keyPress(KeyEvent.VK_CONTROL);
                                   r.keyPress(KeyEvent.VK_V);
                                   r.keyRelease(KeyEvent.VK_CONTROL);
                                   r.keyRelease(KeyEvent.VK_V);
                              }

                              System.out.println(str);
                              break;

                         default:
                              break;
                   }
                   
                   image = r.createScreenCapture(new Rectangle(0, 0, w / 2, h));
                   ImageIO.write(image, "PNG", BOS);
                   BOS.flush();
                   System.out.println(str);
               }
               
               // 아웃풋스트림을 버퍼아웃풋으로

          } catch (Exception e) {
               e.printStackTrace(); // 오류 처리
               System.out.println("접속실패: 서버를 찾을 수 없습니다.");
          }
     }

     
}
import java.io.*;
import java.net.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import javax.imageio.ImageIO;

public class Client_P_Host {

     final int w = Toolkit.getDefaultToolkit().getScreenSize().width / 2,
               h = Toolkit.getDefaultToolkit().getScreenSize().height;

     final int x = Toolkit.getDefaultToolkit().getScreenSize().width / 2 - w / 2,
               y = Toolkit.getDefaultToolkit().getScreenSize().height / 2 - h / 2;

     JFrame frame;

     public static void main(String[] args) {

          new Client_P_Host(); 

     }

     public Client_P_Host() {

          frame = new JFrame("server");

          frame.setBounds(x, y, w, h);

          frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

          frame.setVisible(true);

          frame.setLocation(Toolkit.getDefaultToolkit().getScreenSize().width - w * 2,
                    Toolkit.getDefaultToolkit().getScreenSize().height - h);

          ServerSocket socket_s = null;

          Socket socket = null;

          try {

               PrintWriter PW;
               socket_s = new ServerSocket(5656);

               socket = socket_s.accept();

               System.out.println("연결됨" + socket);

               BufferedInputStream BIS = new BufferedInputStream(socket.getInputStream());

               while (true) {

                    PW = new PrintWriter((socket.getOutputStream()));

                    PW.println("MOUSECLICK/" + MouseInfo.getPointerInfo().getLocation().x + "/" + MouseInfo.getPointerInfo().getLocation().y);
                    PW.flush();

                    

                    PW.println("SARR/"+"가나다라 VOS 12349");
                    PW.flush();

                    frame.getGraphics().drawImage(ImageIO.read(ImageIO.createImageInputStream(BIS)), 0, 0, w, h, frame);

                    Thread.sleep(2000);

               }

          } catch (Exception e) {

               e.printStackTrace();

          }

     }

}
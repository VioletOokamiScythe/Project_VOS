import java.io.*;
import java.net.*;
import java.awt.*;
import javax.swing.*;
import javax.imageio.ImageIO;

public class Client_Image_Receive extends JFrame{

     JPanel panel=new JPanel();

     int w=Toolkit.getDefaultToolkit().getScreenSize().width/2;
     int h=Toolkit.getDefaultToolkit().getScreenSize().height;

     Client_Image_Receive(){

          setContentPane(panel);
          setSize(w, h);
          setVisible(true);
          Socket S=null;
          try {
               S=new Socket("192.168.1.5",5656);
               BufferedInputStream BIS = new BufferedInputStream(S.getInputStream());

               while(true){
                    panel.getGraphics().drawImage(ImageIO.read(ImageIO.createImageInputStream(BIS)), w, h, panel);
               }

          } catch (Exception e) {
               //TODO: handle exception
               e.printStackTrace();
          }

     }

     public static void main(String[] args) {
          new Client_Image_Receive();
     }
}
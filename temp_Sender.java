import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;

public class temp_Sender {
     static final int w = Toolkit.getDefaultToolkit().getScreenSize().width,
               h = Toolkit.getDefaultToolkit().getScreenSize().height;

     public static void main(String[] args) {
          new temp_Sender();
          ServerSocket SS=null;
          Socket S= null;
          try {
               SS=new ServerSocket(8484);
               S=SS.accept();
               BufferedImage image;
               Robot robot=new Robot();
               BufferedOutputStream BOS=new BufferedOutputStream(S.getOutputStream());
               while (true) {
                    image=robot.createScreenCapture(new Rectangle(0,0,w,h));
                    ImageIO.write(image, "png", BOS);
                    BOS.flush();
               }
          } catch (Exception e) {
               //TODO: handle exception
               e.printStackTrace();
          }
         
     }
}
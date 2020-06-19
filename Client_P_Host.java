import java.io.*;
import java.net.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Client_P_Host {

     Client_P_Host() {
          ServerSocket SS = null;
          Socket S = null;

          JFrame frame = new JFrame("Server");
          frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
          frame.setAlwaysOnTop(true);
          frame.setVisible(true);

          try {
               SS = new ServerSocket(5628);

               S = SS.accept();
               BufferedInputStream imageReceive = new BufferedInputStream((S.getInputStream()));

               while (true) {
                    frame.getGraphics().drawImage(ImageIO.read(ImageIO.createImageInputStream(imageReceive)), 1920, 1080, frame);

               }

          } catch (Exception e) {
               // TODO: handle exception
               e.printStackTrace();
          }
     }

     public static void main(String[] args) {
          new Dial(4);
          new Client_P_Host();
     }

}
import java.io.*;
import java.net.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.imageio.*;
import javax.swing.*;
import javax.swing.event.*;

public class Client_T_Guest extends JFrame {
     final int w = Toolkit.getDefaultToolkit().getScreenSize().width,
               h = Toolkit.getDefaultToolkit().getScreenSize().height;
     JPanel basePanel = new JPanel();
     JTextField IP = new JTextField();
     JButton B = new JButton();

     public static void main(String[] args) {
          new Client_T_Guest();
     }

     Client_T_Guest(){
          setContentPane(basePanel);
          basePanel.setLayout(null);
          IP.setBounds(28, 28, 112, 28);
          basePanel.add(IP);
          basePanel.add(B);
          B.setBounds(125, 125, 56, 56);
          B.addActionListener(new ActionListener(){
               public void actionPerformed(ActionEvent arg0){
                    Client_T_Guest.this.Client_work();
               }
          });

          setSize(new Dimension(280,280));
          setVisible(true);
     }

     public void Client_work(){
          String serverip = IP.getText();

          Socket socket =null;
          try {
               socket =new Socket(serverip,5628);

               BufferedImage image;
               Robot R=new Robot();
               BufferedOutputStream bout=new BufferedOutputStream(socket.getOutputStream());

               while (true) {
                    image = R.createScreenCapture(new Rectangle(0,0,w,h));
                    ImageIO.write(image,"bmp",bout);
                    bout.flush();

               }
          } catch (Exception e) {
               //TODO: handle exception
               e.printStackTrace();

          }
     }
}
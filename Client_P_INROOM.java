import java.io.*;
import java.net.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class Client_P_INROOM extends JFrame {

     // 패널 생성
     JPanel basePanel = new JPanel(new BorderLayout());
     JPanel centerPanel = new JPanel(new GridBagLayout());
     JPanel southPanel = new JPanel(new FlowLayout());

     // 컴포넌트 생성
     

     JButton Close_Room = new JButton("Close ROOM");

     GridBagConstraints GBC=new GridBagConstraints();

    

     Client_P_INROOM() {

          GBC.weightx=1;
          GBC.weighty=1;

          GBC.fill=GridBagConstraints.BOTH;

          int k=0;
          int j=0;
          for (int i = 0; i < 72; i++) {
               Coordinate(new JButton(i+"번째"), j, k, 1,1);
               j++;
               if (j==9) {
                    k++;
                    j=0;
               }
               
          }

          class P_InRoom_Action implements ActionListener {

               @Override
               public void actionPerformed(ActionEvent e) {
                    // TODO Auto-generated method stub
                    dispose();
               }

          }

          P_InRoom_Action PIRA = new P_InRoom_Action();

          setContentPane(basePanel);
          basePanel.add(centerPanel, BorderLayout.CENTER);
          basePanel.add(southPanel, BorderLayout.SOUTH);

          southPanel.add(Close_Room);

          Close_Room.addActionListener(PIRA);

          // 기본 설정
          setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
          setTitle("VOS - P INROOM");
          setExtendedState(JFrame.MAXIMIZED_BOTH);
          setAlwaysOnTop(true);
          setUndecorated(true);
          setVisible(true);
     }


	void Coordinate(JButton JC, int x, int y, int w, int h) {
          GBC.gridx = x;
          GBC.gridy = y;
          GBC.gridwidth=w;
          GBC.gridheight=h;
          centerPanel.add(JC, GBC);
          
     }

     public static void main(String[] args) {
          Client_P_INROOM CPI = new Client_P_INROOM();
     }
}
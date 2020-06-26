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
     JButton b1 = new JButton("1번째");

     JButton b2 = new JButton("2번째");

     JButton b3 = new JButton("3번째");

     JButton b4 = new JButton("4번째");

     
     // 컴포넌트 생성
     

     JButton Close_Room = new JButton("Close ROOM");

     GridBagConstraints GBC=new GridBagConstraints();
     GridBagConstraints GBC2=new GridBagConstraints();
     GridBagConstraints GBC3=new GridBagConstraints();
     GridBagConstraints GBC4=new GridBagConstraints();
     

    

     Client_P_INROOM() {
    	 GBC.gridx = 1;
         GBC.gridy = 0;
    	 GBC.gridwidth=1;
    	 GBC.gridheight=1;
    	 GBC.weightx=1;
         GBC.weighty=1;
         
         
         
         GBC2.gridx = 2;
         GBC2.gridy = 0;
    	 GBC2.gridwidth=1;
    	 GBC2.gridheight=1;
    	 GBC2.weightx=1;
         GBC2.weighty=1;
         
         GBC3.gridx = 1;
         GBC3.gridy = 1;
    	 GBC3.gridwidth=1;
    	 GBC3.gridheight=1;
    	 GBC3.weightx=1;
         GBC3.weighty=1;
         
         GBC4.gridx = 2;
         GBC4.gridy = 1;
    	 GBC4.gridwidth=1;
    	 GBC4.gridheight=1;
    	 GBC4.weightx=1;
         GBC4.weighty=1;
         
          GBC.fill=GridBagConstraints.BOTH;
          GBC2.fill=GridBagConstraints.BOTH;
          GBC3.fill=GridBagConstraints.BOTH;
          GBC4.fill=GridBagConstraints.BOTH;
          
          centerPanel.add(b1,GBC);

          centerPanel.add(b2,GBC2);

          centerPanel.add(b3,GBC3);

          centerPanel.add(b4,GBC4);


          class P_InRoom_Action implements ActionListener {

               @Override
               public void actionPerformed(ActionEvent e) {
                    // TODO Auto-generated method stub
                    dispose();
               }

          }
	   b1.addActionListener(new ActionListener() {

              @Override
              public void actionPerformed(ActionEvent bt) {
                   JButton b1 = (JButton)bt.getSource();
                   if(b1.getText().equals("1번째")) {
                   b1.setText("1");
                   basePanel.add(b1);
                   }
                   else if(b1.getText().equals("1")) {
                   b1.setText("1번째");
                   centerPanel.add(b1,GBC);
                   }                   
              } 
         });
         
         b2.addActionListener(new ActionListener() {

             @Override
             public void actionPerformed(ActionEvent bt) {
                  JButton b2 = (JButton)bt.getSource();
                  if(b2.getText().equals("2번째")) {
                  b2.setText("2");
                  basePanel.add(b2);
                  }
                  else if(b2.getText().equals("2")) {
                  b2.setText("2번째");
                  centerPanel.add(b2,GBC2);
                  }                   
             } 
        });
         b3.addActionListener(new ActionListener() {

             @Override
             public void actionPerformed(ActionEvent bt) {
                  JButton b3 = (JButton)bt.getSource();
                  if(b3.getText().equals("3번째")) {
                  b3.setText("3");
                  basePanel.add(b3);
                  }
                  else if(b3.getText().equals("3")) {
                  b3.setText("3번째");
                  centerPanel.add(b3,GBC3);
                  }                   
             } 
        });
         b4.addActionListener(new ActionListener() {

             @Override
             public void actionPerformed(ActionEvent bt) {
                  JButton b4 = (JButton)bt.getSource();
                  if(b4.getText().equals("4번째")) {
                  b4.setText("4");
                  basePanel.add(b4);
                  }
                  else if(b4.getText().equals("4")) {
                  b4.setText("4번째");
                  centerPanel.add(b4,GBC4);
                  }                   
             } 
        });  

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

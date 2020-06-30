import java.io.*;
import java.net.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class Client_P_INROOM extends JFrame {
     //학생 관리 목록
     public static ArrayList<PrintWriter> TargetList;

     JButton b1 = new JButton("1번째");
     JButton b2 = new JButton("2번째");
     JButton b3 = new JButton("3번째");
     JButton b4 = new JButton("4번째");

     

     // 컴포넌트 생성

     JButton Close_Room = new JButton("Close ROOM");

     public static JTextArea TA = new JTextArea();

     GridBagConstraints GBC = new GridBagConstraints();
     GridBagConstraints GBC2 = new GridBagConstraints();
     GridBagConstraints GBC3 = new GridBagConstraints();
     GridBagConstraints GBC4 = new GridBagConstraints();

     // 패널 생성
     JPanel basePanel = new JPanel(new BorderLayout());
     JPanel centerPanel = new JPanel(new GridBagLayout());
     JPanel southPanel = new JPanel(new FlowLayout());
     JScrollPane eastPanel = new JScrollPane(TA);

     //이미지 패널 생성

     JPanel S1_0=new JPanel(new BorderLayout());
     JPanel S1_1=new JPanel();
     JPanel S1_2=new JPanel();

     JPanel S2_0=new JPanel(new BorderLayout());
     JPanel S2_1=new JPanel();
     JPanel S2_2=new JPanel();

     JPanel S3_0=new JPanel(new BorderLayout());
     JPanel S3_1=new JPanel();
     JPanel S3_2=new JPanel();

     JPanel S4_0=new JPanel(new BorderLayout());
     JPanel S4_1=new JPanel();
     JPanel S4_2=new JPanel();
     

     Client_P_INROOM() {




            GBC.gridx = 1; GBC.gridy = 0; GBC.gridwidth=1; GBC.gridheight=1;
            GBC.weightx=1; GBC.weighty=1;
            
            
            
            GBC2.gridx = 2; GBC2.gridy = 0; GBC2.gridwidth=1; GBC2.gridheight=1;
            GBC2.weightx=1; GBC2.weighty=1;
            
            GBC3.gridx = 1; GBC3.gridy = 1; GBC3.gridwidth=1; GBC3.gridheight=1;
            GBC3.weightx=1; GBC3.weighty=1;
            
            GBC4.gridx = 2; GBC4.gridy = 1; GBC4.gridwidth=1; GBC4.gridheight=1;
            GBC4.weightx=1; GBC4.weighty=1;
            
            GBC.fill=GridBagConstraints.BOTH; GBC2.fill=GridBagConstraints.BOTH;
            GBC3.fill=GridBagConstraints.BOTH; GBC4.fill=GridBagConstraints.BOTH;
            
            centerPanel.add(S1_0,GBC);
            
            centerPanel.add(S2_0,GBC2);
            
            centerPanel.add(S3_0,GBC3);
            
            centerPanel.add(S4_0,GBC4);
          
            class P_InRoom_Action implements ActionListener,MouseListener{

               @Override
               public void actionPerformed(ActionEvent e) {
                    // TODO Auto-generated method stub
                    dispose();
                    System.exit(0);
               }

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

          }

          P_InRoom_Action PIRA = new P_InRoom_Action();

          setContentPane(basePanel);


          basePanel.add(centerPanel, BorderLayout.CENTER);
          basePanel.add(southPanel, BorderLayout.SOUTH);
          basePanel.add(eastPanel, BorderLayout.EAST);

          southPanel.add(Close_Room);
          Close_Room.addActionListener(PIRA);



          S1_0.add(S1_1,BorderLayout.WEST);
          S1_0.add(S1_2,BorderLayout.EAST);

          S2_0.add(S2_1,BorderLayout.WEST);
          S2_0.add(S2_2,BorderLayout.EAST);

          S3_0.add(S3_1,BorderLayout.WEST);
          S3_0.add(S3_2,BorderLayout.EAST);

          S4_0.add(S4_1,BorderLayout.WEST);
          S4_0.add(S4_2,BorderLayout.EAST);

          
          S1_0.setBackground(Color.black);
          S1_1.setBackground(Color.white);

          S2_0.setBackground(Color.white);

          S3_0.setBackground(Color.DARK_GRAY);

          S4_0.setBackground(Color.LIGHT_GRAY);

          // 기본 설정
          setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
          setTitle("VOS - P INROOM");
          setExtendedState(JFrame.MAXIMIZED_BOTH);
          //setAlwaysOnTop(true);
          setUndecorated(true);
          setVisible(true);




          // 컴포넌트 설정
          eastPanel.setPreferredSize(new Dimension(280,1080));
          TA.setLineWrap(true);
     }

     void Coordinate(JButton JC, int x, int y, int w, int h) {
          GBC.gridx = x;
          GBC.gridy = y;
          GBC.gridwidth = w;
          GBC.gridheight = h;
          centerPanel.add(JC, GBC);

     }

     public static void main(String[] args) {
          Client_P_INROOM CPI = new Client_P_INROOM();

          TargetList = new ArrayList<PrintWriter>();

          try {
               ServerSocket SS = new ServerSocket(5656);

               while (true) {
                    Socket S = SS.accept();
                    ClientManagerThread CMT = new ClientManagerThread(S);

                    TargetList.add(new PrintWriter(S.getOutputStream()));

                    CMT.start();
               }
          } catch (Exception e) {
               // TODO: handle exception
               e.printStackTrace();
          }
     }
}

class ClientManagerThread extends Thread {
     private Socket socket;
     private String TargetID;

     @Override
     public void run() {
          // TODO Auto-generated method stub
          super.run();
          try {
               BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

               String text;

               while (true) {
                    text = br.readLine();

                    if (text == null) {
                         Client_P_INROOM.TA.append(TargetID + "님이 나갔습니다.\n");
                         break;
                    }

                    String[] split = text.split("/");

                    for (int i = 0; i < split.length; i++) {
                         System.out.println(split[i]);
                    }
                    
                    if (split.length == 2 && split[0].equals("ID")) {
                         TargetID = split[1];
                         Client_P_INROOM.TA.append(TargetID + "님이 입장하였습니다.\n");

                         continue;
                    }

                    if (split.length == 4 && split[2].equals("TEXT")) {
                         TargetID = split[1];
                         Client_P_INROOM.TA.append(TargetID + "  >  " + split[3] + "\n");

                         continue;
                    }

                    
               }
               Client_P_INROOM.TargetList.remove(new PrintWriter(socket.getOutputStream()));
               socket.close();
          } catch (Exception e) {
               // TODO: handle exception
          }
     }

     ClientManagerThread(Socket S) {
          socket = S;
     }
}
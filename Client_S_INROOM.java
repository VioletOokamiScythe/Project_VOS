import java.awt.*;
import java.awt.event.*;
import java.io.BufferedInputStream;
import java.net.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.*;

public class Client_S_INROOM extends JFrame {


    // 패널 생성
    JPanel BasePanel = new JPanel(new BorderLayout());
    JPanel CenterPanel = new JPanel(new BorderLayout());
    JPanel WestPanel = new JPanel(new FlowLayout());
    JPanel EastPanel = new JPanel(new FlowLayout());
    JPanel SouthPanel = new JPanel(new FlowLayout());

    // 하단 패널 컴포넌트 생성
    JButton EXAM_EXIT = new JButton("시험 종료 및 나가기");

    Client_S_INROOM() {

       
    //마우스 감지

   

        // 컴포넌트 설정
        EXAM_EXIT.setPreferredSize(new Dimension(168, 28));

        // 컴포넌트 배치
        setContentPane(BasePanel);
        BasePanel.add(CenterPanel, BorderLayout.CENTER);
        BasePanel.add(SouthPanel, BorderLayout.SOUTH);

        CenterPanel.add(WestPanel, BorderLayout.WEST);
        CenterPanel.add(EastPanel, BorderLayout.EAST);

        SouthPanel.add(EXAM_EXIT);

        EXAM_EXIT.addActionListener(SIRA);
        getContentPane().addMouseListener(SIMK);

        // 기본설정
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("VOS - Client S INROOM");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setAlwaysOnTop(false);
        setUndecorated(true);
        setVisible(true);

         // 이미지 받아올 소켓 생성
         ServerSocket SS = null;
         Socket S = null;
 
         try {
            
             SS = new ServerSocket(5656);
             S = SS.accept();
             System.out.println("클라이언트가 연결되었습니다 " + S);
             BufferedInputStream BIS = new BufferedInputStream(S.getInputStream());
 
             while (true) {
                 CenterPanel.getGraphics().drawImage(ImageIO.read(ImageIO.createImageInputStream(BIS)), 0, 0,
                         CenterPanel.getWidth()/2, CenterPanel.getHeight(), CenterPanel);
             }
         } catch (Exception e) {
             // TODO: handle exception
         }
    }

    class S_InRoom_Action implements ActionListener{
       
        
        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            if (e.getSource() == EXAM_EXIT) {
                new Client_S_Main();
                dispose();
            }
        }
    }

    class S_InRoom_MK implements MouseListener, KeyListener{
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
            try {
                Robot robot=new Robot();
                robot.mouseMove(500, 600);
            } catch (Exception e2) {
                //TODO: handle exception
            }
            
        }

        @Override
        public void keyTyped(KeyEvent e) {
            // TODO Auto-generated method stub

        }

        @Override
        public void keyPressed(KeyEvent e) {
            // TODO Auto-generated method stub

        }

        @Override
        public void keyReleased(KeyEvent e) {
            // TODO Auto-generated method stub

        }

    }
    
    

    S_InRoom_Action SIRA = new S_InRoom_Action();
    S_InRoom_MK SIMK=new S_InRoom_MK();

    public static void main(String[] args) {
        Client_S_INROOM CSI = new Client_S_INROOM();
    }
}
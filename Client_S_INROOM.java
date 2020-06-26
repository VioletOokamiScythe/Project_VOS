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

        // 마우스 감지

        // 컴포넌트 배치
        setContentPane(BasePanel);
        BasePanel.add(CenterPanel, BorderLayout.CENTER);
        BasePanel.add(SouthPanel, BorderLayout.SOUTH);

        CenterPanel.add(WestPanel, BorderLayout.WEST);
        CenterPanel.add(EastPanel, BorderLayout.EAST);

        SouthPanel.add(EXAM_EXIT);

        EXAM_EXIT.addActionListener(SIRA);

        // 컴포넌트 설정
        EXAM_EXIT.setPreferredSize(new Dimension(168, 28));
        WestPanel.setPreferredSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize().width / 2,
                Toolkit.getDefaultToolkit().getScreenSize().height - 28));

        // 기본설정
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("VOS - Client S INROOM");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setAlwaysOnTop(false);
        setVisible(true);



        //이미지 전송 관련
        String ServerIP="VioletOokamiScythe.iptime.org";
        Socket S=null;

        try {
            S=new Socket(ServerIP,8484);
            BufferedInputStream BIS=new BufferedInputStream(S.getInputStream());
            Image_Receive IR= new Image_Receive(WestPanel,BIS);
            IR.start();
            
        } catch (Exception e) {
            //TODO: handle exception
        }

       
    }

    class S_InRoom_Action implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            if (e.getSource() == EXAM_EXIT) {
                new Client_S_Main();
                dispose();
            }
        }
    }

    S_InRoom_Action SIRA = new S_InRoom_Action();

    public static void main(String[] args) {
        Client_S_INROOM CSI = new Client_S_INROOM();
    }

    
}

class Image_Receive extends Thread{
    JPanel westPanel;
    BufferedInputStream BIS;

    Image_Receive(JPanel westPanel,BufferedInputStream BIS){
        this.westPanel=westPanel;
        this.BIS=BIS;
    }
    
    public void run() {
        try {
            while (true) {
                westPanel.getGraphics().drawImage(ImageIO.read(ImageIO.createImageInputStream(BIS)), 0, 0, westPanel);
                }
        } catch (Exception e) {
            //TODO: handle exception
        }
       
    }

}
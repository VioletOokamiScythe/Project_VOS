import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class Client_S_INROOM extends JFrame {
    //루트 패널 생성
    JPanel BasePanel=new JPanel(new BorderLayout());
    
    //중앙 패널 생성
    JPanel CenterPanel = new JPanel(new FlowLayout());

    //하단 패널 생성
    JPanel SouthPanel=new JPanel(new FlowLayout());

    //하단 패널 컴포넌트 생성
    JButton EXAM_EXIT=new JButton("시험 종료 및 나가기");

    Client_S_INROOM() {
        // 기본설정
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("VOS - Create S");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setAlwaysOnTop(true);
        setUndecorated(true);
        setVisible(true);
        
        //컴포넌트 설정
        EXAM_EXIT.setPreferredSize(new Dimension(168,28));

        //컴포넌트 배치
        setContentPane(BasePanel);
        BasePanel.add(CenterPanel,BorderLayout.CENTER);
        BasePanel.add(SouthPanel,BorderLayout.SOUTH);
        SouthPanel.add(EXAM_EXIT);
    }
    public static void main(String[] args) {
        Client_S_INROOM CSI=new Client_S_INROOM();
    }
}
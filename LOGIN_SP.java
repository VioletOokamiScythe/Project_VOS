import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class LOGIN_SP extends JFrame{

    // 루트 패널 작업
    JPanel BasePanel = new JPanel(new BorderLayout(9, 9));


    // 첫번째 화면 패널 작업
    JPanel firstNorthPanel=new JPanel(new BorderLayout());
    JPanel firstCenterPanel = new JPanel(new FlowLayout());
    JPanel firstSouthPanel = new JPanel(new FlowLayout());


    // 첫번째 화면 컴포넌트 작업
    JLabel titleJLabel=new JLabel("VOS");
    JLabel subtitleJLabel=new JLabel("Very Objective System");

    JRadioButton R1 = new JRadioButton();
    JRadioButton R2 = new JRadioButton();

    ButtonGroup G1 = new ButtonGroup();

    JLabel blankJLabel=new JLabel();

    JLabel fJLabel1 = new JLabel("응시자");
    JLabel fJLabel2 = new JLabel("감독관");

    JButton fJButton = new JButton("NEXT");


    // 두번째 화면 패널 작업
    JPanel secondCenterPanel = new JPanel(new FlowLayout());
    JPanel secondSouthPanel = new JPanel(new FlowLayout());


    // 두번째 화면 컴포넌트 작업
    JLabel sJLabel1 = new JLabel("ID");
    JLabel sJLabel2 = new JLabel("PW");

    JButton sJButton1 = new JButton("PREV");
    JButton sJButton2 = new JButton("LOGIN");

    LOGIN_SP() {

        // 기본설정
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("VOS - Create S");
        setSize(450, 280);
        setVisible(true);
        setContentPane(BasePanel);

        BasePanel.setLayout(new BorderLayout());


        //패널 추가
        BasePanel.add(firstNorthPanel,BorderLayout.NORTH);
        BasePanel.add(firstCenterPanel,BorderLayout.CENTER);
        BasePanel.add(firstSouthPanel,BorderLayout.SOUTH);


        //첫번째 패널 컴포넌트 추가
        firstNorthPanel.add(titleJLabel,BorderLayout.NORTH);
        firstNorthPanel.add(subtitleJLabel,BorderLayout.SOUTH);

        firstCenterPanel.add(R1);
        firstCenterPanel.add(fJLabel1);
        firstCenterPanel.add(blankJLabel);
        firstCenterPanel.add(R2);
        firstCenterPanel.add(fJLabel2);

        firstSouthPanel.add(fJButton);

        
        //첫번째 패널의 컴포넌트 설정
        titleJLabel.setPreferredSize(new Dimension(168,56));
        subtitleJLabel.setPreferredSize(new Dimension(168,45));

        fJLabel1.setPreferredSize(new Dimension(168, 36));
        fJLabel2.setPreferredSize(new Dimension(168, 36));
        blankJLabel.setPreferredSize(new Dimension(450,18));
        
        fJButton.setPreferredSize(new Dimension(168, 36));


        //그룹설정
        G1.add(R1);
        G1.add(R2);

    }

    public static void main(String[] args) {
        LOGIN_SP L=new LOGIN_SP();
    }
}
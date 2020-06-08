import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class Create_S extends JFrame {

    // 중앙 패널 및 컴포넌트 생성
    JPanel CenterPanel = new JPanel(new FlowLayout());

    JLabel l1 = new JLabel("Student ID");
    JLabel l2 = new JLabel("Student PW");
    JLabel l3 = new JLabel("NAME");
    JLabel l4 = new JLabel("Major");

    JTextField t1 = new JTextField();
    JTextField t2 = new JTextField();
    JTextField t3 = new JTextField();
    JTextField t4 = new JTextField();

    // 루트 패널 생성
    JPanel BasePanel = new JPanel(new BorderLayout(9,9));

    // 아래쪽 패널 및 컴포넌트 생성
    JPanel SouthPanel = new JPanel();

    JButton b1 = new JButton("Create");
    JButton b2 = new JButton("Cancel");

    Create_S() {

        // 기본설정
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("VOS - Create S");
        setSize(450, 280);
        setVisible(true);

        setContentPane(BasePanel);
       

        BasePanel.add(CenterPanel,BorderLayout.CENTER);
        BasePanel.add(SouthPanel,BorderLayout.SOUTH);

        // 컴포넌트 설정

        CenterPanel.setPreferredSize(new Dimension(BasePanel.getWidth(), BasePanel.getHeight() - 56));
        SouthPanel.setPreferredSize(new Dimension(BasePanel.getWidth(), 56));

        l1.setPreferredSize(new Dimension(168, 36));
        l2.setPreferredSize(new Dimension(168, 36));
        l3.setPreferredSize(new Dimension(168, 36));
        l4.setPreferredSize(new Dimension(168, 36));

        t1.setPreferredSize(new Dimension(168, 36));
        t2.setPreferredSize(new Dimension(168, 36));
        t3.setPreferredSize(new Dimension(168, 36));
        t4.setPreferredSize(new Dimension(168, 36));

        b1.setPreferredSize(new Dimension(168, 28));
        b2.setPreferredSize(new Dimension(168, 28));

        //컴포넌트 추가


        CenterPanel.add(l1);
        CenterPanel.add(t1);

        CenterPanel.add(l2);
        CenterPanel.add(t2);

        CenterPanel.add(l3);
        CenterPanel.add(t3);

        CenterPanel.add(l4);
        CenterPanel.add(t4);

        SouthPanel.add(b1);
        SouthPanel.add(b2);

    }

    public static void main(String[] args) {
        Create_S CS = new Create_S();
    }
}
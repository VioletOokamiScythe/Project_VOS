import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class Client_S_Login extends JFrame {
    // 중앙 패널 및 컴포넌트 생성
    JPanel CenterPanel = new JPanel(new FlowLayout());

    JLabel l1 = new JLabel("Student ID");
    JLabel l2 = new JLabel("PW");

    JTextField t1 = new JTextField();
    JTextField t2 = new JTextField();

    // 루트 패널 생성
    JPanel BasePanel = new JPanel(new BorderLayout(9, 9));

    // 아래쪽 패널 및 컴포넌트 생성
    JPanel SouthPanel = new JPanel();

    JButton b1 = new JButton("Login");
    JButton b2 = new JButton("Cancel");

    Client_S_Login() {
        // 기본설정
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("VOS - Create S");
        setSize(450, 280);
        setVisible(true);
        setContentPane(BasePanel);

        BasePanel.add(CenterPanel,BorderLayout.CENTER);
        BasePanel.add(SouthPanel,BorderLayout.SOUTH);
        CenterPanel.add(l1);
        CenterPanel.add(t1);
        CenterPanel.add(l2);
        CenterPanel.add(t2);

        SouthPanel.add(b1);
        SouthPanel.add(b2);

         // 컴포넌트 설정

         CenterPanel.setPreferredSize(new Dimension(BasePanel.getWidth(), BasePanel.getHeight() - 56));
         SouthPanel.setPreferredSize(new Dimension(BasePanel.getWidth(), 56));
 
         l1.setPreferredSize(new Dimension(168, 36));
         l2.setPreferredSize(new Dimension(168, 36));
         
         t1.setPreferredSize(new Dimension(168, 36));
         t2.setPreferredSize(new Dimension(168, 36));
        
         b1.setPreferredSize(new Dimension(168, 28));
         b2.setPreferredSize(new Dimension(168, 28));
    }

    public static void main(String[] args) {
        Client_S_Login CSL = new Client_S_Login();
    }
}
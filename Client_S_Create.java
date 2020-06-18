import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class Client_S_Create extends JFrame {

    // 버튼 동작
    S_Create_Action SCA = new S_Create_Action();

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
    JPanel BasePanel = new JPanel(new BorderLayout(9, 9));

    // 아래쪽 패널 및 컴포넌트 생성
    JPanel SouthPanel = new JPanel();

    JButton b1 = new JButton("Create");
    JButton b2 = new JButton("Cancel");

    Client_S_Create() {

        // 기본설정
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("VOS - Create S");
        setSize(450, 280);
        setVisible(true);

        setContentPane(BasePanel);

        BasePanel.add(CenterPanel, BorderLayout.CENTER);
        BasePanel.add(SouthPanel, BorderLayout.SOUTH);

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
        b1.addActionListener(SCA);
        b2.setPreferredSize(new Dimension(168, 28));
        b2.addActionListener(SCA);

        // 컴포넌트 추가

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
        Client_S_Create CSC = new Client_S_Create();
    }

    class S_Create_Action implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            String SID;
            String PW;
            String Name;
            String Major;
            String role;
            String finalString;
            String Identity;
            
            if (e.getSource() == b1) {
                SID = t1.getText();
                PW = t2.getText();
                Name = t3.getText();
                Major = t4.getText();
                Identity = "Student";
                
                if (!(SID.equals("")) && !(PW.equals("")) && !Name.equals("") && !Major.equals("")) {
                    Socket s=null;
                    OutputStream outStream;
                    DataOutputStream dataOutputStream;
                    try {
                        s= new Socket("211.250.161.63",5656);
                        outStream = s.getOutputStream();
                        dataOutputStream=new DataOutputStream(outStream);
                        role ="1";
                        finalString = Identity + role + "/" + SID + "/" + PW + "/" + Name + "/" + Major;
                        dataOutputStream.writeUTF(finalString);
                        new Dial(1);
                    } catch (Exception e0) {
                        //TODO: handle exception

                    }
                }
                else new Dial(0);
            }
            if (e.getSource() == b2)
                dispose();
        }
    }
}

import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class Client_S_Main extends JFrame {

    // 패널 작업
    JPanel basePanel = new JPanel(new BorderLayout(9, 9));
    JPanel westPanel = new JPanel(new FlowLayout());
    JPanel LEFTPanel = new JPanel(new FlowLayout());
    JPanel southPanel = new JPanel(new FlowLayout());

    // 컴포넌트 작업

    JLabel Title = new JLabel("VOS - Very Objective System");
    JLabel Mode = new JLabel("Mode = ");
    JLabel ModeLabel = new JLabel("Student");
    JLabel Name = new JLabel("NAME = ");
    JLabel nameLabel = new JLabel();
    JLabel SID = new JLabel("Student ID = ");
    JLabel IDLabel = new JLabel();
    JLabel Major = new JLabel("MAJOR = ");
    JLabel majorLabel = new JLabel();
    JLabel TestTime = new JLabel("NEXT EXAM TIME = ");
    JLabel TestTimeLabel = new JLabel();
    JLabel ExamCode = new JLabel("NEXT EXAM CODE = ");
    JLabel ExamCodeLabel = new JLabel();

    JButton StartRemoteControl = new JButton("원격 접속 실행");
    JButton SaveButton = new JButton("시험 정보 저장");
    JButton ModifyButton = new JButton("저장된 시험 정보 수정");
    JButton Config = new JButton("환경설정");

    Client_S_Main() {
        // 기본설정
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("VOS - Client S MAIN");
        setSize(1800, 900);
        setVisible(true);
        setContentPane(basePanel);

        // 컴포넌트 배치 및 설정
        westPanel.setPreferredSize(new Dimension(336, basePanel.getHeight()));

        Title.setPreferredSize(new Dimension(336, 56));
        Title.setFont(new Font("Consolas", Font.BOLD, 18));
        Title.setHorizontalAlignment(JTextField.CENTER);

        Mode.setPreferredSize(new Dimension(112, 28));
        Mode.setFont(new Font("Serif", Font.PLAIN, 18));

        ModeLabel.setPreferredSize(new Dimension(112, 28));
        ModeLabel.setFont(new Font("Serif", Font.PLAIN, 18));
        ModeLabel.setText("text");

        Name.setPreferredSize(new Dimension(112, 28));
        Name.setFont(new Font("Serif", Font.PLAIN, 18));

        nameLabel.setPreferredSize(new Dimension(112, 28));
        nameLabel.setFont(new Font("Serif", Font.PLAIN, 18));
        nameLabel.setText("text");

        SID.setPreferredSize(new Dimension(112, 28));
        SID.setFont(new Font("Serif", Font.PLAIN, 18));

        IDLabel.setPreferredSize(new Dimension(112, 28));
        IDLabel.setFont(new Font("Serif", Font.PLAIN, 18));
        IDLabel.setText("text");

        Major.setPreferredSize(new Dimension(112, 28));
        Major.setFont(new Font("Serif", Font.PLAIN, 18));

        majorLabel.setPreferredSize(new Dimension(112, 28));
        majorLabel.setFont(new Font("Serif", Font.PLAIN, 18));
        majorLabel.setText("text");

        TestTime.setPreferredSize(new Dimension(168, 28));
        TestTime.setFont(new Font("Serif", Font.PLAIN, 14));

        TestTimeLabel.setPreferredSize(new Dimension(112, 28));
        TestTimeLabel.setFont(new Font("Serif", Font.PLAIN, 14));
        TestTimeLabel.setText("text");

        ExamCode.setPreferredSize(new Dimension(168, 28));
        ExamCode.setFont(new Font("Serif", Font.PLAIN, 14));

        ExamCodeLabel.setPreferredSize(new Dimension(112, 28));
        ExamCodeLabel.setFont(new Font("Serif", Font.PLAIN, 14));
        ExamCodeLabel.setText("text");

        basePanel.add(westPanel, BorderLayout.WEST);
        basePanel.add(LEFTPanel, BorderLayout.CENTER);
        basePanel.add(southPanel, BorderLayout.SOUTH);

        westPanel.add(Title);
        westPanel.add(Mode);
        westPanel.add(ModeLabel);
        westPanel.add(Name);
        westPanel.add(nameLabel);
        westPanel.add(SID);
        westPanel.add(IDLabel);
        westPanel.add(Major);
        westPanel.add(majorLabel);
        westPanel.add(TestTime);
        westPanel.add(TestTimeLabel);
        westPanel.add(ExamCode);
        westPanel.add(ExamCodeLabel);

        southPanel.add(StartRemoteControl);
        southPanel.add(SaveButton);
        southPanel.add(ModifyButton);
        southPanel.add(Config);

        StartRemoteControl.addActionListener(SMA);
        SaveButton.addActionListener(SMA);
        ModifyButton.addActionListener(SMA);
        Config.addActionListener(SMA);

    }

    class S_Main_Action implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            if (e.getSource() == StartRemoteControl) {

            }
            if (e.getSource() == SaveButton) {
                new Client_S_Save();
            }
            if (e.getSource() == ModifyButton) {

            }
            if (e.getSource() == Config) {
                new Configuration();
            }
        }

    }

    S_Main_Action SMA = new S_Main_Action();

    public static void main(String[] args) {
        Client_S_Main CSM = new Client_S_Main();
        new Configuration();
    }

}

class Configuration extends JFrame {

    JPanel basePanel = new JPanel(new BorderLayout(9, 9));
    JPanel centerPanel = new JPanel(new FlowLayout());
    JPanel southPanel = new JPanel(new FlowLayout());

    JLabel Name = new JLabel("이전 이름");
    JTextField nameField = new JTextField();
    JLabel SID = new JLabel("이전 학번");
    JTextField iDField = new JTextField();
    JLabel Major = new JLabel("이전 학과");
    JTextField majorField = new JTextField();
    JLabel PassWord = new JLabel("이전 비밀번호");
    JPasswordField passwordField = new JPasswordField();
    JLabel NName = new JLabel("새 이름");
    JTextField NnameField = new JTextField();
    JLabel NSID = new JLabel("새 학번");
    JTextField NiDField = new JTextField();
    JLabel NMajor = new JLabel("새 학과");
    JTextField NmajorField = new JTextField();
    JLabel NPassWord = new JLabel("새 비밀번호");
    JPasswordField NpasswordField = new JPasswordField();

    JButton Modify = new JButton("수정");
    JButton Delete = new JButton("탈퇴");

    Configuration() {

        // 기본 설정
        setSize(450, 392);
        setVisible(true);
        setContentPane(basePanel);

        basePanel.add(centerPanel, BorderLayout.CENTER);
        basePanel.add(southPanel, BorderLayout.SOUTH);

        centerPanel.add(SID);
        centerPanel.add(iDField);
        centerPanel.add(PassWord);
        centerPanel.add(passwordField);
        centerPanel.add(Name);
        centerPanel.add(nameField);
        centerPanel.add(Major);
        centerPanel.add(majorField);
        centerPanel.add(NSID);
        centerPanel.add(NiDField);
        centerPanel.add(NPassWord);
        centerPanel.add(NpasswordField);
        centerPanel.add(NName);
        centerPanel.add(NnameField);
        centerPanel.add(NMajor);
        centerPanel.add(NmajorField);

        southPanel.add(Modify);
        southPanel.add(Delete);

        Delete.setBackground(Color.RED);

        Delete.addActionListener(CA);
        Modify.addActionListener(CA);

        SID.setPreferredSize(new Dimension(168, 28));
        iDField.setPreferredSize(new Dimension(168, 28));
        PassWord.setPreferredSize(new Dimension(168, 28));
        passwordField.setPreferredSize(new Dimension(168, 28));
        Name.setPreferredSize(new Dimension(168, 28));
        nameField.setPreferredSize(new Dimension(168, 28));
        Major.setPreferredSize(new Dimension(168, 28));
        majorField.setPreferredSize(new Dimension(168, 28));
        NSID.setPreferredSize(new Dimension(168, 28));
        NiDField.setPreferredSize(new Dimension(168, 28));
        NPassWord.setPreferredSize(new Dimension(168, 28));
        NpasswordField.setPreferredSize(new Dimension(168, 28));
        NName.setPreferredSize(new Dimension(168, 28));
        NnameField.setPreferredSize(new Dimension(168, 28));
        NMajor.setPreferredSize(new Dimension(168, 28));
        NmajorField.setPreferredSize(new Dimension(168, 28));

    }

    class Configuration_Action implements ActionListener {

        String ID;
        String PW;
        String Name;
        String Major;
        String finalString;
        String Identity = "Student";
        String NID;
        String NPW;
        String NName;
        String NMajor;

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            if (e.getSource() == Modify) {

                String mission = "Modify";
                ID = iDField.getText();
                PW = passwordField.getText();
                Name = nameField.getText();
                Major = majorField.getText();
                NID = NiDField.getText();
                NPW = NpasswordField.getText();
                NName = NnameField.getText();
                NMajor = NmajorField.getText();

                if (!(ID.equals("")) && !(PW.equals("")) && !(Name.equals("")) && !(Major.equals(""))
                        && !(NID.equals("")) && !(NPW.equals("")) && !(NName.equals("")) && !(NMajor.equals(""))) {
                    Socket s = null;
                    OutputStream outStream;
                    DataOutputStream dataOutputStream;
                    try {
                        s = new Socket("VioletOokamiScythe.iptime.org", 5656);
                        outStream = s.getOutputStream();
                        dataOutputStream = new DataOutputStream(outStream);
                        finalString = mission + "/" + ID + "/" + PW + "/" + Name + "/" + Major+ "/" + NID + "/" + NPW + "/" + NName + "/" + NMajor;
                        dataOutputStream.writeUTF(finalString);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }
            if (e.getSource() == Delete) {
                String mission = "LORC";
                String role = "2";
                ID = iDField.getText();

                if (!(ID.equals(""))) {
                    Socket s = null;
                    OutputStream outStream;
                    DataOutputStream dataOutputStream;
                    try {
                        s = new Socket("VioletOokamiScythe.iptime.org", 5656);
                        outStream = s.getOutputStream();
                        dataOutputStream = new DataOutputStream(outStream);
                        finalString = mission + "/" + Identity + "/" + role + "/" + ID;
                        dataOutputStream.writeUTF(finalString);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }

    }

    Configuration_Action CA = new Configuration_Action();
}

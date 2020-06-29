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
                new SModify();
            }
            if (e.getSource() == Config) {
                new SConfiguration();
            }
        }

    }

    S_Main_Action SMA = new S_Main_Action();

    public static void main(String[] args) {
        Client_S_Main CSM = new Client_S_Main();
    }

}

class SConfiguration extends JFrame {

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

    SConfiguration() {

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
        String NID;
        String NPW;
        String NName;
        String NMajor;

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            if (e.getSource() == Modify) {

                String mission = "SModify";
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
                        finalString = mission + "/" + ID + "/" + PW + "/" + Name + "/" + Major + "/" + NID + "/" + NPW
                                + "/" + NName + "/" + NMajor;
                        dataOutputStream.writeUTF(finalString);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }
            if (e.getSource() == Delete) {
                String mission = "SSecession";
                ID = iDField.getText();

                if (!(ID.equals(""))) {
                    Socket s = null;
                    OutputStream outStream;
                    DataOutputStream dataOutputStream;
                    try {
                        s = new Socket("VioletOokamiScythe.iptime.org", 5656);
                        outStream = s.getOutputStream();
                        dataOutputStream = new DataOutputStream(outStream);
                        finalString = mission + "/" + ID;
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

class Client_S_Save extends JFrame {

    // 월 일 시 분 문자열
    String Year = "2020";
    String[] Month = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" };
    String[] Date = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18",
            "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" };
    String[] HOUR = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17",
            "18", "19", "20", "21", "22", "23" };
    String[] MIN = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17",
            "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35",
            "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53",
            "54", "55", "56", "57", "58", "59" };
    String[] PLACE = { "436호", "407호", "409호", "410호" };

    // 패널 생성
    JPanel basePanel = new JPanel(new BorderLayout());
    JPanel northPanel = new JPanel(new FlowLayout());
    JPanel centerPanel = new JPanel(new FlowLayout());
    JPanel southPanel = new JPanel(new FlowLayout());

    // 컴포넌트 생성
    JLabel titleLabel = new JLabel("VOS - Very Objective System");
    JLabel ExamCode = new JLabel("EXAM CODE");
    JTextField ExamCodeField = new JTextField();
    JLabel SubjectName = new JLabel("SUBJECT NAME");
    JTextField SubjectNameField = new JTextField();
    JLabel ExamTime = new JLabel("EXAM TIME");
    JComboBox<String> ExamTimeMONTH = new JComboBox<String>();
    JLabel ExamTimeMONTHLabel = new JLabel("월");
    JComboBox<String> ExamTimeDATE = new JComboBox<String>();
    JLabel ExamTimeDATELabel = new JLabel("일");
    JComboBox<String> ExamTimeHOUR = new JComboBox<String>();
    JLabel ExamTimeHourLabel = new JLabel("시");
    JComboBox<String> ExamTimeMINUTE = new JComboBox<String>();
    JLabel ExamTimeMINUTELabel = new JLabel("분 시작");
    JLabel Place = new JLabel("장소");
    JComboBox<String> ExamRoom = new JComboBox<String>();
    JLabel ExamRoomLable = new JLabel("호");

    JButton SaveButton = new JButton("저장");

    Client_S_Save() {
        // 기본설정
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("VOS - Client_S_Save");
        setSize(450, 392);
        setVisible(true);
        setContentPane(basePanel);

        class Listener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                if (e.getSource() == SaveButton) {

                    try {
                        Socket s = null;
                        OutputStream outStream;
                        DataOutputStream dataOutputStream;
                        String finalString;
                        String Mission = "SSave";

                        try {
                            s = new Socket("violetookamiscythe.iptime.org", 5656);
                            outStream = s.getOutputStream();
                            dataOutputStream = new DataOutputStream(outStream);
                            finalString = Mission + "/" + ExamCodeField.getText() + "/" + SubjectNameField.getText()
                                    + "/" + Year + "-" + ExamTimeMONTH.getSelectedItem().toString() + "-"
                                    + ExamTimeDATE.getSelectedItem().toString() + " "
                                    + ExamTimeHOUR.getSelectedItem().toString() + ":"
                                    + ExamTimeMINUTE.getSelectedItem().toString() + ":" + "00" + "." + "0";
                            dataOutputStream.writeUTF(finalString);
                        } catch (Exception e0) {
                            // TODO: handle exception
                            e0.printStackTrace();
                        }
                    } catch (Exception e0) {
                        // TODO: handle exception
                    }
                }
            }
        }

        // 컴포넌트 설정
        basePanel.add(northPanel, BorderLayout.NORTH);
        basePanel.add(centerPanel, BorderLayout.CENTER);
        basePanel.add(southPanel, BorderLayout.SOUTH);

        northPanel.add(titleLabel);
        centerPanel.add(ExamCode);
        centerPanel.add(ExamCodeField);
        centerPanel.add(SubjectName);
        centerPanel.add(SubjectNameField);
        centerPanel.add(ExamTime);
        centerPanel.add(ExamTimeMONTH);
        centerPanel.add(ExamTimeMONTHLabel);
        centerPanel.add(ExamTimeDATE);
        centerPanel.add(ExamTimeDATELabel);
        centerPanel.add(ExamTimeHOUR);
        centerPanel.add(ExamTimeHourLabel);
        centerPanel.add(ExamTimeMINUTE);
        centerPanel.add(ExamTimeMINUTELabel);
        centerPanel.add(Place);
        centerPanel.add(ExamRoom);
        centerPanel.add(ExamRoomLable);

        southPanel.add(SaveButton);

        titleLabel.setPreferredSize(new Dimension(168, 28));
        ExamCode.setPreferredSize(new Dimension(168, 28));
        ExamCodeField.setPreferredSize(new Dimension(168, 28));
        SubjectName.setPreferredSize(new Dimension(168, 28));
        SubjectNameField.setPreferredSize(new Dimension(168, 28));
        ExamTime.setPreferredSize(new Dimension(450, 28));
        ExamTimeMONTH.setPreferredSize(new Dimension(168, 28));
        ExamTimeMONTHLabel.setPreferredSize(new Dimension(168, 28));
        ExamTimeDATE.setPreferredSize(new Dimension(168, 28));
        ExamTimeDATELabel.setPreferredSize(new Dimension(168, 28));
        ExamTimeHOUR.setPreferredSize(new Dimension(168, 28));
        ExamTimeHourLabel.setPreferredSize(new Dimension(168, 28));
        ExamTimeMINUTE.setPreferredSize(new Dimension(168, 28));
        ExamTimeMINUTELabel.setPreferredSize(new Dimension(168, 28));
        Place.setPreferredSize(new Dimension(84, 28));
        ExamRoom.setPreferredSize(new Dimension(112, 28));
        ExamRoomLable.setPreferredSize(new Dimension(56, 28));

        ExamTime.setHorizontalAlignment(JTextField.CENTER);

        for (int i = 0; i < Month.length; i++) {
            ExamTimeMONTH.addItem(Month[i]);
        }
        for (int i = 0; i < Date.length; i++) {
            ExamTimeDATE.addItem(Date[i]);
        }
        for (int i = 0; i < HOUR.length; i++) {
            ExamTimeHOUR.addItem(HOUR[i]);
        }
        for (int i = 0; i < MIN.length; i++) {
            ExamTimeMINUTE.addItem(MIN[i]);
        }
        for (int i = 0; i < PLACE.length; i++) {
            ExamRoom.addItem(PLACE[i]);
        }
    }

}

class SModify extends JFrame {

    // 월 일 시 분 문자열
    String Year = "2020";
    String[] Month = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" };
    String[] Date = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18",
            "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" };
    String[] HOUR = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17",
            "18", "19", "20", "21", "22", "23" };
    String[] MIN = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17",
            "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35",
            "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53",
            "54", "55", "56", "57", "58", "59" };
    String[] PLACE = { "436호", "407호", "409호", "410호" };

    // 패널 생성
    JPanel basePanel = new JPanel(new BorderLayout());
    JPanel northPanel = new JPanel(new FlowLayout());
    JPanel centerPanel = new JPanel(new FlowLayout());
    JPanel southPanel = new JPanel(new FlowLayout());

    // 컴포넌트 생성
    JLabel titleLabel = new JLabel("VOS - Very Objective System");
    JLabel ExamCode = new JLabel("EXAM CODE");
    JTextField ExamCodeField = new JTextField();
    JLabel SubjectName = new JLabel("SUBJECT NAME");
    JTextField SubjectNameField = new JTextField();
    JLabel ExamTime = new JLabel("EXAM TIME");
    JComboBox<String> ExamTimeMONTH = new JComboBox<String>();
    JLabel ExamTimeMONTHLabel = new JLabel("월");
    JComboBox<String> ExamTimeDATE = new JComboBox<String>();
    JLabel ExamTimeDATELabel = new JLabel("일");
    JComboBox<String> ExamTimeHOUR = new JComboBox<String>();
    JLabel ExamTimeHourLabel = new JLabel("시");
    JComboBox<String> ExamTimeMINUTE = new JComboBox<String>();
    JLabel ExamTimeMINUTELabel = new JLabel("분 시작");
    JLabel Place = new JLabel("장소");
    JComboBox<String> ExamRoom = new JComboBox<String>();
    JLabel ExamRoomLable = new JLabel("호");

    JButton SaveButton = new JButton("저장");
    JButton DeleteButton = new JButton("삭제");

    SModify() {
        // 기본설정
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("VOS - Client_S_Modify");
        setSize(450, 392);
        setVisible(true);
        setContentPane(basePanel);

        class Listener implements ActionListener {

            String TestCode;
            String finalString;
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                if (e.getSource() == SaveButton) {

                    try {
                        Socket s = null;
                        OutputStream outStream;
                        DataOutputStream dataOutputStream;
                        
                        String Mission = "STSave";

                        try {
                            s = new Socket("violetookamiscythe.iptime.org", 5656);
                            outStream = s.getOutputStream();
                            dataOutputStream = new DataOutputStream(outStream);
                            finalString = Mission + "/" + ExamCodeField.getText() + "/" + SubjectNameField.getText()
                                    + "/" + Year + "-" + ExamTimeMONTH.getSelectedItem().toString() + "-"
                                    + ExamTimeDATE.getSelectedItem().toString() + " "
                                    + ExamTimeHOUR.getSelectedItem().toString() + ":"
                                    + ExamTimeMINUTE.getSelectedItem().toString() + ":" + "00" + "." + "0";
                            dataOutputStream.writeUTF(finalString);
                        } catch (Exception e0) {
                            // TODO: handle exception
                            e0.printStackTrace();
                        }
                    } catch (Exception e0) {
                        // TODO: handle exception
                    }
                }
                if (e.getSource()==DeleteButton) {
                    String mission = "SDrop";
                    TestCode = ExamCodeField.getText();
                    String StudentID=new Dial(12).getCode();

                if (!(ExamCodeField.equals(""))&&!(ExamCodeField.equals(""))) {
                    Socket s = null;
                    OutputStream outStream;
                    DataOutputStream dataOutputStream;
                    try {
                        s = new Socket("VioletOokamiScythe.iptime.org", 5656);
                        outStream = s.getOutputStream();
                        dataOutputStream = new DataOutputStream(outStream);
                        finalString = mission + "/" + StudentID+ "/" + TestCode;
                        dataOutputStream.writeUTF(finalString);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
                }
            }
        }

        // 컴포넌트 설정
        basePanel.add(northPanel, BorderLayout.NORTH);
        basePanel.add(centerPanel, BorderLayout.CENTER);
        basePanel.add(southPanel, BorderLayout.SOUTH);

        northPanel.add(titleLabel);
        centerPanel.add(ExamCode);
        centerPanel.add(ExamCodeField);
        centerPanel.add(SubjectName);
        centerPanel.add(SubjectNameField);
        centerPanel.add(ExamTime);
        centerPanel.add(ExamTimeMONTH);
        centerPanel.add(ExamTimeMONTHLabel);
        centerPanel.add(ExamTimeDATE);
        centerPanel.add(ExamTimeDATELabel);
        centerPanel.add(ExamTimeHOUR);
        centerPanel.add(ExamTimeHourLabel);
        centerPanel.add(ExamTimeMINUTE);
        centerPanel.add(ExamTimeMINUTELabel);
        centerPanel.add(Place);
        centerPanel.add(ExamRoom);
        centerPanel.add(ExamRoomLable);

        southPanel.add(SaveButton);
        southPanel.add(DeleteButton);

        titleLabel.setPreferredSize(new Dimension(168, 28));
        ExamCode.setPreferredSize(new Dimension(168, 28));
        ExamCodeField.setPreferredSize(new Dimension(168, 28));
        SubjectName.setPreferredSize(new Dimension(168, 28));
        SubjectNameField.setPreferredSize(new Dimension(168, 28));
        ExamTime.setPreferredSize(new Dimension(450, 28));
        ExamTimeMONTH.setPreferredSize(new Dimension(168, 28));
        ExamTimeMONTHLabel.setPreferredSize(new Dimension(168, 28));
        ExamTimeDATE.setPreferredSize(new Dimension(168, 28));
        ExamTimeDATELabel.setPreferredSize(new Dimension(168, 28));
        ExamTimeHOUR.setPreferredSize(new Dimension(168, 28));
        ExamTimeHourLabel.setPreferredSize(new Dimension(168, 28));
        ExamTimeMINUTE.setPreferredSize(new Dimension(168, 28));
        ExamTimeMINUTELabel.setPreferredSize(new Dimension(168, 28));
        Place.setPreferredSize(new Dimension(84, 28));
        ExamRoom.setPreferredSize(new Dimension(112, 28));
        ExamRoomLable.setPreferredSize(new Dimension(56, 28));

        DeleteButton.setBackground(Color.RED);

        ExamTime.setHorizontalAlignment(JTextField.CENTER);

        for (int i = 0; i < Month.length; i++) {
            ExamTimeMONTH.addItem(Month[i]);
        }
        for (int i = 0; i < Date.length; i++) {
            ExamTimeDATE.addItem(Date[i]);
        }
        for (int i = 0; i < HOUR.length; i++) {
            ExamTimeHOUR.addItem(HOUR[i]);
        }
        for (int i = 0; i < MIN.length; i++) {
            ExamTimeMINUTE.addItem(MIN[i]);
        }
        for (int i = 0; i < PLACE.length; i++) {
            ExamRoom.addItem(PLACE[i]);
        }
    }
}
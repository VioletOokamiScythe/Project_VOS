import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class Client_S_Main extends JFrame {

    // 패널 작업
    JPanel basePanel = new JPanel(new BorderLayout());
    JPanel westPanel = new JPanel(new FlowLayout());
    JPanel centerPanel = new JPanel(new FlowLayout());
    JPanel southPanel = new JPanel(new FlowLayout());

    // 컴포넌트 작업

    JLabel Title = new JLabel("VOS - Very Objective System");
    JLabel Mode = new JLabel("Mode = Student");
    JLabel Name = new JLabel("NAME");
    JLabel nameLabel = new JLabel();
    JLabel SID = new JLabel("Student ID");
    JLabel IDLabel = new JLabel();
    JLabel Major = new JLabel("MAJOR");
    JLabel majorLabel = new JLabel();
    JLabel TestTime = new JLabel("TEST_Time");
    JLabel TestTimeLabel = new JLabel();
    JLabel ExamCode = new JLabel("EXAM CODE");
    JLabel ExamCodeLabel = new JLabel();

    JButton StartRemoteControl = new JButton("원격 접속 실행");
    JButton SaveButton = new JButton("로컬에 시험 정보 저장");
    JButton ModifyButton = new JButton("저장된 시험 정보 수정");

    Client_S_Main() {
        // 기본설정
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("VOS - Client S MAIN");
        setSize(1800, 900);
        setVisible(true);
        setContentPane(basePanel);

        //컴포넌트 설정
        westPanel.setPreferredSize(new Dimension(336,basePanel.getHeight()));

        basePanel.add(westPanel,BorderLayout.WEST);
        basePanel.add(centerPanel,BorderLayout.CENTER);
        basePanel.add(southPanel,BorderLayout.SOUTH);

        westPanel.add(Title);
        westPanel.add(Mode);
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


        StartRemoteControl.addActionListener(SMA);
        SaveButton.addActionListener(SMA);
        ModifyButton.addActionListener(SMA);

    }

    class S_Main_Action implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            if (e.getSource()==StartRemoteControl) {
                
            }
            if (e.getSource()==SaveButton) {
                new Client_S_Save();
            }
            if (e.getSource()==ModifyButton) {
                
            }
        }
        
    }

    S_Main_Action SMA=new S_Main_Action();

    public static void main(String[] args) {
        Client_S_Main CSM = new Client_S_Main();

    }

}

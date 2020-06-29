import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class Client_P_Main extends JFrame {
	Client_P_Main() {

		setTitle("VOS - Client P");
		JPanel P = new JPanel();
		Label l1 = new Label("VOS - Very Objective System");
		Label l2 = new Label("MODE = Professor");
		Label l3 = new Label("Name =");
		Label l4 = new Label("Professor ID = ");
		Label l5 = new Label("학과 =");
		Label l6 = new Label("시험 일자");
		Label l7 = new Label(" ");
		Label l8 = new Label("시험 코드 =");

		add(l1);
		add(l2);
		add(l3);
		add(l4);
		add(l5);
		add(l6);
		add(l7);
		add(l8);

		JButton j1 = new JButton("원격지 컴퓨터 배치 실행");
		JButton j2 = new JButton("저장된 시험정보 수정");
		JButton j3 = new JButton("환경설정");

		add(j1);
		add(j2);
		add(j3);
		l1.setBounds(20, 10, 200, 40);
		l2.setBounds(20, 50, 200, 20);
		l3.setBounds(20, 70, 200, 40);
		l4.setBounds(20, 100, 200, 40);
		l5.setBounds(20, 130, 200, 40);
		l6.setBounds(20, 160, 200, 40);
		l7.setBounds(20, 190, 200, 40);
		l8.setBounds(20, 220, 200, 40);

		j1.setBounds(650, 700, 200, 30);
		j2.setBounds(650, 740, 200, 30);
		j3.setBounds(650, 780, 200, 30);

		add(P);
		

		setSize(900, 900);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

		class P_Main_Action implements ActionListener {

			String ID;
        String PW;
        String Name;
        String Major;
        String finalString;
        String NID;
        String NPW;
        String NName;
	   String NMajor;

			public void actionPerformed(ActionEvent e) {
				if (e.getSource()==j1) {
					new Client_P_Save();
				}
				if (e.getSource()==j3) {
					new PConfiguration();
				}
			}
		}

		P_Main_Action PMA=new P_Main_Action();
		j1.addActionListener(PMA);
		j3.addActionListener(PMA);
	}

	public static void main(String[] args) {
		Client_P_Main CPM = new Client_P_Main();
	}
}



class PConfiguration extends JFrame {

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
 
	PConfiguration() {
 
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
 
			  String mission = "PModify";
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
			  String mission = "PSecession";
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
 
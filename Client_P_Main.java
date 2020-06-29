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

		JButton j1 = new JButton("시험 생성");
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
				if (e.getSource()==j2) {
					new PModify();
				}
				if (e.getSource()==j3) {
					new PConfiguration();
				}
			}
		}

		P_Main_Action PMA=new P_Main_Action();
		j1.addActionListener(PMA);
		j2.addActionListener(PMA);
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
	JLabel SID = new JLabel("이전 교번");
	JTextField iDField = new JTextField();
	JLabel Major = new JLabel("이전 학과");
	JTextField majorField = new JTextField();
	JLabel PassWord = new JLabel("이전 비밀번호");
	JPasswordField passwordField = new JPasswordField();
	JLabel NName = new JLabel("새 이름");
	JTextField NnameField = new JTextField();
	JLabel NSID = new JLabel("새 교번");
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
 

class Client_P_Save extends JFrame {
	int status = 1;

	JPanel P = new JPanel();
	JLabel l1 = new JLabel("Professor ID");
	JLabel l3 = new JLabel("NAME");
	JLabel l4 = new JLabel("Major");
	JLabel l5 = new JLabel("시험코드");

	JLabel R_HEX = new JLabel("R");
	JLabel G_HEX = new JLabel("G");
	JLabel B_HEX = new JLabel("B");

	JTextField t1 = new JTextField();
	JTextField t3 = new JTextField();
	JTextField t4 = new JTextField();
	public JTextField t5 = new JTextField();

	JTextField RValue = new JTextField();
	JTextField GValue = new JTextField();
	JTextField BValue = new JTextField();

	JSlider R = new JSlider(0, 255);
	JSlider G = new JSlider(0, 255);
	JSlider B = new JSlider(0, 255);

	JButton j1 = new JButton("Check");
	JButton j2 = new JButton("Next");
	JButton j3 = new JButton("Cancel");

	Client_P_Save() {

		add(R_HEX);
		add(G_HEX);
		add(B_HEX);

		add(l1);
		add(l3);
		add(l4);
		add(l5);

		add(RValue);
		RValue.setHorizontalAlignment(JTextField.CENTER);
		add(GValue);
		GValue.setHorizontalAlignment(JTextField.CENTER);
		add(BValue);
		BValue.setHorizontalAlignment(JTextField.CENTER);

		t1.setEnabled(false);
		t3.setEnabled(false);
		t4.setEnabled(false);
		t5.setEnabled(false);

		add(t1);
		add(t3);
		add(t4);
		add(t5);

		add(R);
		add(G);
		add(B);

		add(j1);
		add(j2);
		add(j3);
		l1.setBounds(40, 10, 100, 40);
		l3.setBounds(40, 50, 40, 40);
		l4.setBounds(40, 90, 40, 40);
		l5.setBounds(40, 130, 40, 40);
		t1.setBounds(140, 10, 200, 30);
		t3.setBounds(140, 50, 200, 30);
		t4.setBounds(140, 90, 200, 30);
		t5.setBounds(140, 130, 200, 30);

		R_HEX.setBounds(40, 168, 28, 28);
		RValue.setBounds(56, 168, 56, 28);
		R.setBounds(112, 168, 256, 28);
		G_HEX.setBounds(40, 196, 28, 28);
		GValue.setBounds(56, 196, 56, 28);
		G.setBounds(112, 196, 256, 28);
		B_HEX.setBounds(40, 224, 28, 28);
		BValue.setBounds(56, 224, 56, 28);
		B.setBounds(112, 224, 256, 28);

		class P_Save_Action implements ActionListener, ChangeListener, KeyListener {

			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				if (e.getSource() == R) {
					RValue.setText(String.format("%02X", R.getValue()));
					t5.setText(RValue.getText() + GValue.getText() + BValue.getText());
				}
				if (e.getSource() == G) {
					GValue.setText(String.format("%02X", G.getValue()));
					t5.setText(RValue.getText() + GValue.getText() + BValue.getText());
				}
				if (e.getSource() == B) {
					BValue.setText(String.format("%02X", B.getValue()));
					t5.setText(RValue.getText() + GValue.getText() + BValue.getText());
				}
			}

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (e.getSource() == j1) {
					Socket s = null;
					OutputStream outStream;
					DataOutputStream dataOutputStream;
					InputStream IS;
					DataInputStream DIS;
					String role = "0";
					String TC = t5.getText();
					String finalString;
					String Mission = "Check";
					int response;

					try {
						s = new Socket("VioletOokamiScythe.iptime.org", 5656);
						outStream = s.getOutputStream();
						dataOutputStream = new DataOutputStream(outStream);
						IS = s.getInputStream();
						DIS = new DataInputStream(IS);
						finalString = Mission + "/" + role + "/" + TC;
						dataOutputStream.writeUTF(finalString);
						while (true) {
							response = DIS.readInt();
							if (response == 0) {
								Dial dial = new Dial(9);
								status = dial.getSign();
								dispose();
								break;
							}
						}
					} catch (Exception e0) {
						// TODO: handle exception

					}
				}
				if (e.getSource() == j2) {
					new Client_P_Save2();
					if (status != 0) {
						new Dial(11);
					} else {

					}

				}

				if (e.getSource() == j3) {
					dispose();
				}
			}

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				if (e.getSource() == RValue) {
					t5.setText(RValue.getText() + GValue.getText() + BValue.getText());
				}
				if (e.getSource() == GValue) {
					t5.setText(RValue.getText() + GValue.getText() + BValue.getText());
				}
				if (e.getSource() == BValue) {
					t5.setText(RValue.getText() + GValue.getText() + BValue.getText());
				}
			}

		}
		P_Save_Action PSA = new P_Save_Action();

		R.addChangeListener(PSA);
		G.addChangeListener(PSA);
		B.addChangeListener(PSA);

		RValue.addKeyListener(PSA);
		GValue.addKeyListener(PSA);
		BValue.addKeyListener(PSA);

		j1.setBounds(50, 300, 80, 30);
		j2.setBounds(150, 300, 80, 30);
		j3.setBounds(250, 300, 80, 30);

		j1.addActionListener(PSA);
		j2.addActionListener(PSA);
		j3.addActionListener(PSA);

		add(P);
		setSize(400, 400);
		setTitle("VOS -Save P");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	class Client_P_Save2 extends JFrame {
		String Year = "2020";
		String[] Month = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" };
		String[] Date = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17",
				"18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" };
		String[] HOUR = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16",
				"17", "18", "19", "20", "21", "22", "23" };
		String[] MIN = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16",
				"17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32",
				"33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48",
				"49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59" };
		String[] place = { "436호", "437호", "438호", "439호" };

		Client_P_Save2() {

			setTitle("Client Save P");

			JPanel P = new JPanel();
			JLabel l1 = new JLabel("시간 설정");
			JLabel l2 = new JLabel("기간 설정");
			JLabel l3 = new JLabel("강의실 설정");

			JLabel l4 = new JLabel("월");
			JLabel l5 = new JLabel("일");
			JLabel l6 = new JLabel("시");
			JLabel l7 = new JLabel("분");

			add(l1);
			add(l2);
			add(l3);
			add(l4);
			add(l5);
			add(l6);
			add(l7);

			JButton j1 = new JButton("Check");
			JButton j2 = new JButton("Next");
			JButton j3 = new JButton("Cancel");
			add(j1);
			add(j2);
			add(j3);

			JComboBox monthCombo = new JComboBox(Month);
			add(monthCombo);
			JComboBox dayCombo = new JComboBox(Date);
			add(dayCombo);
			JComboBox timeCombo = new JComboBox(HOUR);
			add(timeCombo);
			JComboBox minuteCombo = new JComboBox(MIN);
			add(minuteCombo);
			JComboBox placeCombo = new JComboBox(place);
			add(placeCombo);

			l1.setBounds(60, 10, 100, 40);
			l2.setBounds(60, 200, 70, 40);
			l3.setBounds(60, 250, 70, 40);
			l4.setBounds(112, 50, 100, 40);
			l5.setBounds(224, 50, 70, 40);
			l6.setBounds(112, 150, 70, 40);
			l7.setBounds(224, 150, 70, 40);

			monthCombo.setBounds(60, 50, 40, 30);
			dayCombo.setBounds(168, 50, 40, 30);

			timeCombo.setBounds(60, 150, 40, 30);
			minuteCombo.setBounds(168, 150, 40, 30);
			placeCombo.setBounds(160, 250, 100, 40);
			j1.setBounds(50, 300, 80, 30);
			j2.setBounds(150, 300, 80, 30);
			j3.setBounds(250, 300, 80, 30);
			add(P);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setSize(400, 400);
			setVisible(true);

			class P_Save_Action2 implements ActionListener {
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub

					if (e.getSource() == j1) {
						Socket s = null;
						OutputStream outStream;
						DataOutputStream dataOutputStream;
						String finalString;
						String Mission="Create";

						try {
							s = new Socket("violetookamiscythe.iptime.org", 5656);
							outStream = s.getOutputStream();
							dataOutputStream = new DataOutputStream(outStream);
							finalString = Mission+"/"+t5.getText() + "/" + "211.250.161.63" + "/"
									+ placeCombo.getSelectedItem().toString() + "/" + Year + "-"
									+ monthCombo.getSelectedItem().toString() + "-"
									+ dayCombo.getSelectedItem().toString() + " "
									+ timeCombo.getSelectedItem().toString() + ":"
									+ minuteCombo.getSelectedItem().toString() + ":" + "00" + "." + "0";
							dataOutputStream.writeUTF(finalString);
						} catch (Exception e0) {
							// TODO: handle exception
							e0.printStackTrace();
						}
					}
				}
			}

			P_Save_Action2 PSA2=new P_Save_Action2();

			j1.addActionListener(PSA2);
		}
	}
}

class PModify extends JFrame {

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
 
	PModify() {
	    // 기본설정
	    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    setTitle("VOS - Client_P_TModify");
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
					
					String Mission = "PTSave";
 
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
				 String mission = "PDrop";
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

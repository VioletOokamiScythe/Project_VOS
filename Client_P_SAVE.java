import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

import java.text.*;
import java.util.Date;

//save 1
public class Client_P_Save extends JFrame {
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

	public static void main(String[] args) {
		new Client_P_Save();
	}
}

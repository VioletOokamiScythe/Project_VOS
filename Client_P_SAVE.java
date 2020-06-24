import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

import java.text.*;


//save 1
public class Client_P_Save extends JFrame{
	

	Client_P_Save() {
		JPanel P = new JPanel();
		JLabel l1 = new JLabel("Professor ID");
		JLabel l3 = new JLabel("NAME");
		JLabel l4 = new JLabel("Major");
		JLabel l5 = new JLabel("시험코드");



		JLabel R_HEX=new JLabel("R");
		add(R_HEX);
		JLabel G_HEX=new JLabel("G");
		add(G_HEX);
		JLabel B_HEX=new JLabel("B");
		add(B_HEX);



		add(l1);
		add(l3);
		add(l4);
		add(l5);
		JTextField t1 = new JTextField();
		JTextField t3 = new JTextField();
		JTextField t4 = new JTextField();
		JTextField t5 = new JTextField();
		


		JTextField RValue=new JTextField();
		JTextField GValue=new JTextField();
		JTextField BValue=new JTextField();
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



		JSlider R=new JSlider(0,255);
		JSlider G=new JSlider(0,255);
		JSlider B=new JSlider(0,255);
		add(R);
		add(G);
		add(B);




		JButton j1 = new JButton("Check");
		JButton j2 = new JButton("Next");
		JButton j3 = new JButton("Cancel");
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





			class P_Save_Action implements ActionListener, ChangeListener{
	
				@Override
				public void stateChanged(ChangeEvent e) {
					// TODO Auto-generated method stub
					if (e.getSource()==R){
						RValue.setText(String.format("%02X", R.getValue()));
						t5.setText(RValue.getText()+GValue.getText()+BValue.getText());
					}
					if (e.getSource()==G) {
						GValue.setText(String.format("%02X", G.getValue()));
						t5.setText(RValue.getText()+GValue.getText()+BValue.getText());
					}
					if (e.getSource()==B) {
						BValue.setText(String.format("%02X", B.getValue()));
						t5.setText(RValue.getText()+GValue.getText()+BValue.getText());
					}
					
					
					
					
				}
		
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					if (e.getSource()==j1) {
						
					}
					if (e.getSource()==j2) {
						new Client_P_Save2();
					}
					
					if (e.getSource()==j3){
						dispose();
					}
				}
		
			}
			P_Save_Action PSA=new P_Save_Action();
		



		R.addChangeListener(PSA);
		G.addChangeListener(PSA);
		B.addChangeListener(PSA);



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
	
	
	public static void main(String[] args) {
		Client_P_Save CP_SAVE = new Client_P_Save();

	}

}

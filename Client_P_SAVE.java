import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

//save 1
public class Client_P_SAVE extends JFrame{
	Client_P_SAVE() {
		JPanel P = new JPanel();
		Label l1 = new Label("Professor ID");
		Label l3 = new Label("NAME");
		Label l4 = new Label("Major");
		Label l5 = new Label("시험코드");

		add(l1);
		add(l3);
		add(l4);
		add(l5);
		TextField t1 = new TextField();
		TextField t3 = new TextField();
		TextField t4 = new TextField();
		TextField t5 = new TextField();

		t1.setEnabled(false);
		t3.setEnabled(false);
		t4.setEnabled(false);
		add(t1);
		add(t3);
		add(t4);
		add(t5);

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
		j1.setBounds(50, 300, 80, 30);
		j2.setBounds(150, 300, 80, 30);
		j3.setBounds(250, 300, 80, 30);
		add(P);
		setSize(400, 400);
		setTitle("VOS -Save P");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		Client_P_SAVE CP_SAVE = new Client_P_SAVE();

	}

}

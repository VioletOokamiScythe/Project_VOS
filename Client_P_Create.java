import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class Client_P_Create extends JFrame {

	P_Create_Action PCA = new P_Create_Action();
	TextField t1 = new TextField();
	TextField t2 = new TextField();
	TextField t3 = new TextField();
	TextField t4 = new TextField();
	JButton j1 = new JButton("Create");
	JButton j2 = new JButton("Cancel");
	WARNING Warning = new WARNING();

	/* CP GUI */
	Client_P_Create() {
		JPanel P = new JPanel();
		Label l1 = new Label("Professor ID");
		Label l2 = new Label("Professor PW");
		Label l3 = new Label("NAME");
		Label l4 = new Label("Major");

		add(l1);
		add(l2);
		add(l3);
		add(l4);

		add(t1);
		add(t2);
		add(t3);
		add(t4);

		t3.setEchoChar('*');
		add(j1);
		j1.addActionListener(PCA);
		add(j2);
		j2.addActionListener(PCA);
		l1.setBounds(40, 10, 40, 40);
		l2.setBounds(40, 50, 40, 40);
		l3.setBounds(40, 90, 40, 40);
		l4.setBounds(40, 130, 40, 40);
		t1.setBounds(120, 10, 200, 30);
		t2.setBounds(120, 50, 200, 30);
		t3.setBounds(120, 90, 200, 30);
		t4.setBounds(120, 130, 200, 30);
		j1.setBounds(100, 230, 80, 30);
		j2.setBounds(240, 230, 80, 30);
		add(P);
		setSize(400, 400);
		setTitle("VOS Client P");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
	}

	class P_Create_Action implements ActionListener {
		public void actionPerformed(ActionEvent T) {
			if (T.getSource() == j2) dispose();
			if (T.getSource() == j1) {
				// 하나라도 미입력시 메시지 출력
				if (t1.getText().length() == 0 || t2.getText().length() == 0 ||
						t3.getText().length() == 0 || t4.getText().length() == 0)
					Warning.input_warning();
			}
		}
	}
}

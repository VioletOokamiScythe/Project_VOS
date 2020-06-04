import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CP extends JFrame{
  /* CP GUI */
	CP(){
	JPanel P = new JPanel();
	Label l1 =new Label("Professor ID");
	Label l2 =new Label("Professor PW");
	Label l3 =new Label("NAME");
	Label l4 =new Label("Major");

	add(l1);
	add(l2);
	add(l3);
	add(l4);
	
	TextField t1 = new TextField();
	TextField t2 = new TextField();
	TextField t3 = new TextField();
	TextField t4 = new TextField();
	
	add(t1);
	add(t2);
	add(t3);
	add(t4);
	
	t3.setEchoChar('*');
	JButton j1 = new JButton("Create");
	JButton j2 = new JButton("Cancel");
	add(j1);
	add(j2);
	l1.setBounds(40, 10, 40, 40);
	l2.setBounds(40, 50, 40, 40);
	l3.setBounds(40, 90, 40, 40);
	l4.setBounds(40, 130, 40, 40);
	t1.setBounds(120,10,200,30);
	t2.setBounds(120,50,200,30);
	t3.setBounds(120,90,200,30);
	t4.setBounds(120,130,200,30);
	j1.setBounds(100, 230, 80, 30);
	j2.setBounds(240, 230, 80, 30);
	add(P);
	setSize(400,400);
	setTitle("VOS Client P");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setVisible(true);
	}
	public void actionPerformed(ActionEvent T) {
		
	}
	public static void main(String[] args) {
		CP CP=new CP();
	}

}

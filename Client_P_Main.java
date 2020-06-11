import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;


public class Client_P_Main extends JFrame{
    Client_P_Main(){
		
		setTitle("VOS - Client P");
		JPanel P = new JPanel();
		Label l1 =new Label("VOS - Very Objective System");
		Label l2 =new Label("MODE = Professor");
		Label l3 =new Label("Name =");
		Label l4 =new Label("Professor ID = ");
		Label l5 =new Label("학과 =");
		Label l6 =new Label("시험 일자");
		Label l7 =new Label(" ");
		Label l8 =new Label("시험 코드 =");
		
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
		
		add(j1);
		add(j2);
		l1.setBounds(20, 10, 200, 40);
		l2.setBounds(20, 50, 200, 20);
		l3.setBounds(20, 70, 200, 40);
		l4.setBounds(20,100,200,40);
		l5.setBounds(20,130,200,40);
		l6.setBounds(20,160,200,40);
		l7.setBounds(20,190,200,40);
		l8.setBounds(20,220,200,40);
		
		
		j1.setBounds(650, 700, 200, 30);
		j2.setBounds(650, 740, 200, 30);
		
		add(P);
		
		setSize(900,900);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		}
	
	public static void main(String[] args) {
	
		Client_P_Main CPM= new Client_P_Main();
	}
	class P_Main_Action implements ActionListener {
        public void actionPerformed(ActionEvent e) {
          
        }
    }
}

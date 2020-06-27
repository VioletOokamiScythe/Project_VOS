import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class Client_P_Save2 extends JFrame{
     String[] HOUR = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17",
               "18", "19", "20", "21", "22", "23" };
     String[] MIN = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17",
               "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34",
               "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51",
               "52", "53", "54", "55", "56", "57", "58", "59" };
	String[] term={"1일", "2일", "3일", "4일"};
    String[] place= {"436호","437호","438호","439호"};
	
	Client_P_Save2(){
		
		
		setTitle("Client Save P");
        
        
        JPanel P = new JPanel();
    	Label l1 =new Label("시간 설정");
    	Label l2 =new Label("기간 설정");
    	Label l3 =new Label("강의실 설정");
        
    	add(l1);
    	add(l2);
    	add(l3);
        
    	JButton j1 = new JButton("Check");
    	JButton j2 = new JButton("Next");
    	JButton j3 = new JButton("Cancel");
    	add(j1);
    	add(j2);
    	add(j3);
        
        JComboBox timeCombo= new JComboBox(HOUR);
        add(timeCombo);
        JComboBox minuteCombo= new JComboBox(MIN);
        add(minuteCombo);       
        JComboBox termCombo = new JComboBox(term);
        add(termCombo);        
        JComboBox placeCombo = new JComboBox(place);
        add(placeCombo);
        
        
        l1.setBounds(60, 10, 100, 40);
    	l2.setBounds(60, 50, 70, 40);
    	l3.setBounds(60, 120, 70, 40);
        timeCombo.setBounds(160,10,40,30);
        minuteCombo.setBounds(200,10,40,30);
        termCombo.setBounds(160,60,60,30);
        placeCombo.setBounds(160,120,100,40);
    	j1.setBounds(50, 300, 80, 30);
    	j2.setBounds(150, 300, 80, 30);
    	j3.setBounds(250,300,80,30);
        add(P);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400,400);
        setVisible(true);

	}
     public static void main(String[] args) {
		new Client_P_Save2();

	}
}

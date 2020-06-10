import java.awt.FlowLayout;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

public class Client_P_Login extends JFrame{

	P_Login_Action pla = new P_Login_Action();
	JLabel lbl,la1,la2,la3;
    JTextField id;
    JPasswordField passwd;
    JPanel idPanel,paPanel,loginPanel;
    JButton b1,b2,b3;
    JTextArea content;
	public Client_P_Login() {
		super( "VOS-Client P Login" );
		setLayout( new FlowLayout() );  //플로우 레이아웃 사용
		
		EtchedBorder eborder =  new EtchedBorder();
		
		lbl = new JLabel( "VOS - Very Objective System" );
		b1 = new JButton("Client P");
		
		lbl.setBorder(eborder);
		
		add( lbl );
		
		idPanel = new JPanel();
        paPanel = new JPanel();
      
        
        la3 = new JLabel("Professor ID");
        la2 = new JLabel("PW");
        
        id = new JTextField(10);
        passwd = new JPasswordField(5);
        idPanel.add(b1);
        idPanel.add(la3);
        idPanel.add(id);
        paPanel.add( la2 );
        paPanel.add( passwd );
        
        loginPanel = new JPanel();
       
        b2 = new JButton("Login");
	b2.addActionListener(pla);
        b3= new JButton("Create");
	b3.addActionListener(pla);
        loginPanel.add( b2 );
        loginPanel.add( b3 );
        add(idPanel);
        add(paPanel);
        add(loginPanel);
        
        
        setSize( 250, 400 );
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
		
	}
	
	public static void main(String[] args) {
		new Client_P_Login();

	}

	class P_Login_Action implements ActionListener {
        public void actionPerformed(ActionEvent e) {
	        if(e.getSource() == b3) new Client_P_Create();
        }
    }
	
}

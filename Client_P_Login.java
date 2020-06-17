import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.EtchedBorder;

public class Client_P_Login extends JFrame{

	P_Login_Action PLA = new P_Login_Action();
	JLabel lbl,la1,la2,la3;
    JTextField id;
    JPasswordField passwd;
    JPanel idPanel,paPanel,loginPanel,cpPanel;
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
		cpPanel = new JPanel();
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
	b2.addActionListener(PLA);
        b3= new JButton("Create");
	b3.addActionListener(PLA);
        loginPanel.add( b2 );
        loginPanel.add( b3 );
	add(cpPanel);
        add(idPanel);
        add(paPanel);
        add(loginPanel);
        
        
        setSize( 300, 400 );
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
		
	}
	
	public static void main(String[] args) {
		new Client_P_Login();

	}

	class P_Login_Action implements ActionListener {
		String PID;
		String PPW;
		String role;
		String finalString;

        public void actionPerformed(ActionEvent e) {
	        if(e.getSource() == b3) new Client_P_Create();
		if(e.getSource() == b2) {
			PID = id.getText();
			PPW = passwd.getText();
			
			if(!(PID.equals("")) && !(PPW.equals(""))) {
				Socket s = null;
				OutputStream outStream;
				DataOutputStream dataOutputStream;
				try {
					s = new Socket("211.250.161.63", 5656);
					outStream = s.getOutputStream();
					dataOutputStream = new DataOutputStream(outStream);
					role = "0";
					finalString = role + "/" + PID + "/" + PPW;
					dataOutputStream.writeUTF(finalString);
					new Dial(1);
				} catch (Exception e0) {
					
				}
			}
			else new Dial(0);
            }
        }
    }
	
}

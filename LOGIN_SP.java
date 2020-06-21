import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.io.*;
import java.net.*;

public class LOGIN_SP extends JFrame{

    // 루트 패널 작업
    JPanel BasePanel = new JPanel(new BorderLayout(9, 9));


    // 첫번째 화면 패널 작업
    JPanel firstNorthPanel=new JPanel(new BorderLayout());
    JPanel firstCenterPanel = new JPanel(new FlowLayout());
    JPanel firstSouthPanel = new JPanel(new FlowLayout());


    // 첫번째 화면 컴포넌트 작업
    JLabel titleJLabel=new JLabel("VOS");
    JLabel subtitleJLabel=new JLabel("Very Objective System");

    JRadioButton R1 = new JRadioButton();
    JRadioButton R2 = new JRadioButton();

    ButtonGroup G1 = new ButtonGroup();

    JLabel blankJLabel=new JLabel();

    JLabel fJLabel1 = new JLabel("응시자");
    JLabel fJLabel2 = new JLabel("감독관");

    JButton fJButton1 = new JButton("NEXT");
    JButton fJButton2 = new JButton("Create");



    // 두번째 화면 패널 작업
    JPanel secondNorthPanel=new JPanel(new FlowLayout());
    JPanel secondCenterPanel = new JPanel(new FlowLayout());
    JPanel secondSouthPanel = new JPanel(new FlowLayout());


    // 두번째 화면 컴포넌트 작업
    JLabel sJLabel1 = new JLabel("Student ID");
    JLabel sJLabel2 = new JLabel("Professor ID");
    JLabel sJLabel3 = new JLabel("PW");

    JButton sJButton1 = new JButton("PREV");
    JButton sJButton2 = new JButton("LOGIN");

    LOGIN_SP() {

        //내부 리스너 생성
        class Listener implements ActionListener{

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub

                if (e.getSource() == fJButton1 && R1.isSelected() == true) {
                    new Client_S_Login();
                    dispose();
                }
                if (e.getSource() == fJButton1 && R2.isSelected() == true) {
                    new Client_P_Login();
                    dispose();
                }

                if (e.getSource()==fJButton2&&R1.isSelected()==true){
                    new Client_S_Create();
                    dispose();
                }
                if (e.getSource()==fJButton2&&R2.isSelected()==true){
                    new Client_P_Create();
                    dispose();
                }
            }

        }

        Listener l=new Listener();

        // 기본설정
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("VOS - Create S");
        setSize(450, 280);
        setVisible(true);
        setContentPane(BasePanel);

        BasePanel.setLayout(new BorderLayout());


        //패널 추가
        BasePanel.add(firstNorthPanel,BorderLayout.NORTH);
        BasePanel.add(firstCenterPanel,BorderLayout.CENTER);
        BasePanel.add(firstSouthPanel,BorderLayout.SOUTH);


        //첫번째 패널 컴포넌트 추가
        firstNorthPanel.add(titleJLabel,BorderLayout.NORTH);
        firstNorthPanel.add(subtitleJLabel,BorderLayout.SOUTH);

        firstCenterPanel.add(R1);
        firstCenterPanel.add(fJLabel1);
        firstCenterPanel.add(blankJLabel);
        firstCenterPanel.add(R2);
        firstCenterPanel.add(fJLabel2);

        firstSouthPanel.add(fJButton1);
        firstSouthPanel.add(fJButton2);


        fJButton1.addActionListener(l);
        fJButton2.addActionListener(l);
        
        //첫번째 패널의 컴포넌트 설정
        titleJLabel.setPreferredSize(new Dimension(168,56));
        subtitleJLabel.setPreferredSize(new Dimension(168,45));

        fJLabel1.setPreferredSize(new Dimension(168, 36));
        fJLabel2.setPreferredSize(new Dimension(168, 36));
        blankJLabel.setPreferredSize(new Dimension(450,18));
        
        fJButton1.setPreferredSize(new Dimension(168, 36));
        fJButton2.setPreferredSize(new Dimension(168, 36));


        //그룹설정
        G1.add(R1);
        G1.add(R2);

    }



    public static void main(String[] args) {
       new LOGIN_SP();
    }
}


class Client_S_Login extends JFrame {
    // 중앙 패널 및 컴포넌트 생성
    JPanel CenterPanel = new JPanel(new FlowLayout());

    JLabel l1 = new JLabel("Student ID");
    JLabel l2 = new JLabel("PW");

    JTextField t1 = new JTextField();
    JTextField t2 = new JTextField();

    // 루트 패널 생성
    JPanel BasePanel = new JPanel(new BorderLayout(9, 9));

    // 아래쪽 패널 및 컴포넌트 생성
    JPanel SouthPanel = new JPanel();

    JButton b1 = new JButton("Login");
    JButton b2 = new JButton("Cancel");

    Client_S_Login() {
        // 기본설정
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("VOS - Create S");
        setSize(450, 280);
        setVisible(true);
        setContentPane(BasePanel);

        BasePanel.add(CenterPanel, BorderLayout.CENTER);
        BasePanel.add(SouthPanel, BorderLayout.SOUTH);
        CenterPanel.add(l1);
        CenterPanel.add(t1);
        CenterPanel.add(l2);
        CenterPanel.add(t2);

        SouthPanel.add(b1);
        SouthPanel.add(b2);

        b1.addActionListener(SLA);
        b2.addActionListener(SLA);

        // 컴포넌트 설정

        CenterPanel.setPreferredSize(new Dimension(BasePanel.getWidth(), BasePanel.getHeight() - 56));
        SouthPanel.setPreferredSize(new Dimension(BasePanel.getWidth(), 56));

        l1.setPreferredSize(new Dimension(168, 36));
        l2.setPreferredSize(new Dimension(168, 36));

        t1.setPreferredSize(new Dimension(168, 36));
        t2.setPreferredSize(new Dimension(168, 36));

        b1.setPreferredSize(new Dimension(168, 28));
        b2.setPreferredSize(new Dimension(168, 28));
    }

    class S_Login_Action implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            String SID;
            String PW;
            String role;
            String finalString;
            String Identity;

            // TODO Auto-generated method stub
            if (e.getSource() == b1) {
                SID = t1.getText();
                PW = t2.getText();
                Identity = "Student";

                if (!(SID.equals("")) && !(PW.equals(""))) {
                    Socket s = null;
                    OutputStream outStream;
                    DataOutputStream dataOutputStream;
                    try {
                        s = new Socket("211.250.161.63", 5656);
                        outStream = s.getOutputStream();
                        dataOutputStream = new DataOutputStream(outStream);
                        role = "0";
                        finalString = Identity + "/" + role + "/" + SID + "/" + PW;
                        dataOutputStream.writeUTF(finalString);
                        new Dial(1);
                    } catch (Exception e0) {
                        // TODO: handle exception

                    }
                } else
                    new Dial(0);
            }
            if (e.getSource() == b2) {
                dispose();
                new LOGIN_SP();
            }

        }

    }

    S_Login_Action SLA = new S_Login_Action();
}


class Client_S_Create extends JFrame {

    // 버튼 동작
    S_Create_Action SCA = new S_Create_Action();

    // 중앙 패널 및 컴포넌트 생성
    JPanel CenterPanel = new JPanel(new FlowLayout());

    JLabel l1 = new JLabel("Student ID");
    JLabel l2 = new JLabel("Student PW");
    JLabel l3 = new JLabel("NAME");
    JLabel l4 = new JLabel("Major");

    JTextField t1 = new JTextField();
    JTextField t2 = new JTextField();
    JTextField t3 = new JTextField();
    JTextField t4 = new JTextField();

    // 루트 패널 생성
    JPanel BasePanel = new JPanel(new BorderLayout(9, 9));

    // 아래쪽 패널 및 컴포넌트 생성
    JPanel SouthPanel = new JPanel();

    JButton b1 = new JButton("Create");
    JButton b2 = new JButton("Cancel");

    Client_S_Create() {

        // 기본설정
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("VOS - Create S");
        setSize(450, 280);
        setVisible(true);

        setContentPane(BasePanel);

        BasePanel.add(CenterPanel, BorderLayout.CENTER);
        BasePanel.add(SouthPanel, BorderLayout.SOUTH);

        // 컴포넌트 설정

        CenterPanel.setPreferredSize(new Dimension(BasePanel.getWidth(), BasePanel.getHeight() - 56));
        SouthPanel.setPreferredSize(new Dimension(BasePanel.getWidth(), 56));

        l1.setPreferredSize(new Dimension(168, 36));
        l2.setPreferredSize(new Dimension(168, 36));
        l3.setPreferredSize(new Dimension(168, 36));
        l4.setPreferredSize(new Dimension(168, 36));

        t1.setPreferredSize(new Dimension(168, 36));
        t2.setPreferredSize(new Dimension(168, 36));
        t3.setPreferredSize(new Dimension(168, 36));
        t4.setPreferredSize(new Dimension(168, 36));

        b1.setPreferredSize(new Dimension(168, 28));
        b1.addActionListener(SCA);
        b2.setPreferredSize(new Dimension(168, 28));
        b2.addActionListener(SCA);

        // 컴포넌트 추가

        CenterPanel.add(l1);
        CenterPanel.add(t1);

        CenterPanel.add(l2);
        CenterPanel.add(t2);

        CenterPanel.add(l3);
        CenterPanel.add(t3);

        CenterPanel.add(l4);
        CenterPanel.add(t4);

        SouthPanel.add(b1);
        SouthPanel.add(b2);

    }


    class S_Create_Action implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            String SID;
            String PW;
            String Name;
            String Major;
            String role;
            String finalString;
            String Identity;
            
            if (e.getSource() == b1) {
                SID = t1.getText();
                PW = t2.getText();
                Name = t3.getText();
                Major = t4.getText();
                Identity = "Student";
                
                if (!(SID.equals("")) && !(PW.equals("")) && !Name.equals("") && !Major.equals("")) {
                    Socket s=null;
                    OutputStream outStream;
                    DataOutputStream dataOutputStream;
                    try {
                        s= new Socket("211.250.161.63",5656);
                        outStream = s.getOutputStream();
                        dataOutputStream=new DataOutputStream(outStream);
                        role ="1";
                        finalString = Identity + "/" + role + "/" + SID + "/" + PW + "/" + Name + "/" + Major;
                        dataOutputStream.writeUTF(finalString);
                        new Dial(1);
                        dispose();
                    } catch (Exception e0) {
                        //TODO: handle exception

                    }
                }
                else new Dial(0);
            }
            if (e.getSource() == b2)
                dispose();
        }
    }
}


class Client_P_Login extends JFrame{

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
	

	class P_Login_Action implements ActionListener {
		String PID;
		String PPW;
		String role;
		String finalString;
		String Identity;

        public void actionPerformed(ActionEvent e) {
	        if(e.getSource() == b3) new Client_P_Create();
		if(e.getSource() == b2) {
			PID = id.getText();
			PPW = passwd.getText();
			Identity = "Professor";
			
			if(!(PID.equals("")) && !(PPW.equals(""))) {
				Socket s = null;
				OutputStream outStream;
				DataOutputStream dataOutputStream;
				try {
					s = new Socket("211.250.161.63", 5656);
					outStream = s.getOutputStream();
					dataOutputStream = new DataOutputStream(outStream);
					role = "0";
					finalString = Identity + "/" + role + "/" + PID + "/" + PPW;
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

class Client_P_Create extends JFrame {

	P_Create_Action PCA = new P_Create_Action();
	TextField t1 = new TextField();
	JPasswordField t2 = new JPasswordField();
	TextField t3 = new TextField();
	TextField t4 = new TextField();
	JButton j1 = new JButton("Create");
	JButton j2 = new JButton("Cancel");

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
		String PID;
		String PPW;
		String PName;
		String PMaj;
		String role;
		String Identity;
		String finalString;
		
		public void actionPerformed(ActionEvent T) {
			if (T.getSource() == j2) {
                dispose();
            }
			if (T.getSource() == j1) {
				PID = t1.getText();
				PPW = t2.getText();
				PName = t3.getText();
				PMaj = t4.getText();
				Identity = "Professor";
				
				if (!(PID.equals("")) && !(PPW.equals("")) && 
						!(PName.equals("")) && !(PMaj.equals(""))) {
					Socket s = null;
					OutputStream outStream;
					DataOutputStream dataOutputStream;
					try {
						s = new Socket("211.250.161.63", 5656);
						outStream = s.getOutputStream();
						dataOutputStream = new DataOutputStream(outStream);
						role = "1";
						finalString = Identity + "/" + role + "/" + PID + "/" + PPW + "/" + PName + "/" + PMaj;
						dataOutputStream.writeUTF(finalString);
						new Dial(1);
					} catch (Exception e) {
						
					}
				}
				else new Dial(0);
			}
		}
	}
}

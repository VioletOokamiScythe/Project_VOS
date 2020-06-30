import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.*;

public class Client_S_INROOM extends JFrame {

    static Dial dial = new Dial(12);
    public String ID = dial.getCode();

    static Socket s = null;
    PrintWriter PW;

    // 컴포넌트 생성
    JButton EXAM_EXIT = new JButton("시험 종료 및 나가기");
    JButton Asend = new JButton("입력");
    JButton Tsend = new JButton("입력");

    JLabel label = new JLabel("여기에 주관식 답안 입력");

    JTextArea AA = new JTextArea();
    public static JTextArea TA = new JTextArea();
    JTextArea SA = new JTextArea();

    // 패널 생성
    JPanel BasePanel = new JPanel(new BorderLayout(9, 9));
    JPanel CenterPanel = new JPanel(new BorderLayout());
    JPanel WestPanel = new JPanel(new FlowLayout());
    JPanel EastPanel = new JPanel(new FlowLayout());
    JPanel SouthPanel = new JPanel(new FlowLayout());
    JPanel subSouthPanel = new JPanel(new BorderLayout(9, 9));
    JPanel TextPanel = new JPanel(new BorderLayout());
    JPanel SubPanel = new JPanel(new BorderLayout(9, 9));
    JScrollPane SubScrollPanel = new JScrollPane(AA);
    JScrollPane scrollPane1 = new JScrollPane(TA);
    JScrollPane scrollPane2 = new JScrollPane(SA);

    public static void main(String[] args) {
        Client_S_INROOM CSI = new Client_S_INROOM();
        temp_Receiver tr= new temp_Receiver();

    }

    Client_S_INROOM() {

        try {
            Socket s = new Socket("violetookamiscythe.iptime.org", 5656);
            PW = new PrintWriter((s.getOutputStream()));

            PW.println("ID/" + this.ID);
            PW.flush();

            PlainTextReceiveThread PTRT = new PlainTextReceiveThread(s);
            PTRT.start();
        } catch (Exception e) {
            // TODO: handle exception
        }

        // 마우스 감지

        // 컴포넌트 배치
        setContentPane(BasePanel);
        BasePanel.add(CenterPanel, BorderLayout.CENTER);
        BasePanel.add(SouthPanel, BorderLayout.SOUTH);
        BasePanel.add(TextPanel, BorderLayout.EAST);

        CenterPanel.add(WestPanel, BorderLayout.WEST);
        CenterPanel.add(EastPanel, BorderLayout.EAST);
        CenterPanel.add(subSouthPanel, BorderLayout.SOUTH);

        subSouthPanel.add(SubScrollPanel, BorderLayout.WEST);
        subSouthPanel.add(Asend, BorderLayout.EAST);
        subSouthPanel.add(label, BorderLayout.NORTH);

        SouthPanel.add(EXAM_EXIT);

        TextPanel.add(scrollPane1, BorderLayout.NORTH);
        TextPanel.add(SubPanel, BorderLayout.SOUTH);

        SubPanel.add(scrollPane2, BorderLayout.WEST);
        SubPanel.add(Tsend, BorderLayout.EAST);

        EXAM_EXIT.addActionListener(SIRA);
        Tsend.addActionListener(SIRA);
        Asend.addActionListener(SIRA);
        AA.addKeyListener(SIRA);
        SA.addKeyListener(SIRA);

        WestPanel.add(temp_Receiver.Panel);

        // 컴포넌트 설정
        EXAM_EXIT.setPreferredSize(new Dimension(168, 28));
        WestPanel.setPreferredSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize().width / 2,
                Toolkit.getDefaultToolkit().getScreenSize().height - 28));
        EastPanel.setPreferredSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize().width / 2,
                Toolkit.getDefaultToolkit().getScreenSize().height - 28));
        SubScrollPanel.setPreferredSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize().width - 588, 112));
        TextPanel.setPreferredSize(new Dimension(448, Toolkit.getDefaultToolkit().getScreenSize().height - 28));
        scrollPane1.setPreferredSize(new Dimension(448, Toolkit.getDefaultToolkit().getScreenSize().height - 224));
        scrollPane2.setPreferredSize(new Dimension(336, 112));
        Asend.setPreferredSize(new Dimension(112, 112));
        Tsend.setPreferredSize(new Dimension(112, 112));
        AA.setLineWrap(true);
        TA.setLineWrap(true);
        SA.setLineWrap(true);
        TA.setEditable(false);

        // 기본설정
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("VOS - Client S INROOM");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setAlwaysOnTop(false);
        setVisible(true);

        // 이미지 전송 관련
        String ServerIP = "VioletOokamiScythe.iptime.org";
        Socket S = null;

        try {
            S = new Socket(ServerIP, 16800);
            BufferedInputStream BIS = new BufferedInputStream(S.getInputStream());
            Image_Receive IR = new Image_Receive(WestPanel, BIS);
            IR.start();

        } catch (Exception e) {
            // TODO: handle exception
        }

    }

    class S_InRoom_Action extends Thread implements ActionListener, KeyListener {

        String finalString;
        String Answer;
        String Mission;

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            if (e.getSource() == EXAM_EXIT) {
                new Client_S_Main();
                dispose();
            }
            if (e.getSource() == Asend) {

                Mission = "SARR"; // Send Answer & Refresh Request
                try {

                    s = new Socket("violetookamiscythe.iptime.org", 5656);

                    finalString = "ID/" + ID + "/" + Mission + "/" + AA.getText();
                    PW.println(finalString);
                    PW.flush();
                    AA.setText(null);

                } catch (Exception e0) {
                    // TODO: handle exception
                    e0.printStackTrace();
                }
            }

            if (e.getSource() == Tsend) {

                Mission = "TEXT";
                try {

                    s = new Socket("violetookamiscythe.iptime.org", 5656);
                    finalString = "ID/" + ID + "/" + Mission + "/" + SA.getText();
                    PW.println(finalString);
                    PW.flush();
                    SA.setText(null);

                } catch (Exception e0) {
                    // TODO: handle exception
                    e0.printStackTrace();
                }
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
            if (e.getKeyChar() == 10) {
                try {
                    if (AA.isFocusOwner()) {
                        Mission = "SARR"; // Send Answer & Refresh Request
                        finalString = "ID/" + ID + "/" + Mission + "/" + AA.getText();
                        AA.setText(null);
                    }

                    if (SA.isFocusOwner()) {
                        Mission = "TEXT";
                        finalString = "ID/" + ID + "/" + Mission + "/" + SA.getText();
                        SA.setText(null);

                    }
                    s = new Socket("violetookamiscythe.iptime.org", 5656);
                    PW.println(finalString);
                    PW.flush();

                } catch (Exception e0) {
                    // TODO: handle exception
                    e0.printStackTrace();
                }
            }
        }
    }

    S_InRoom_Action SIRA = new S_InRoom_Action();

}

// 동작하지 않음
class Image_Receive extends Thread {
    JPanel westPanel;
    BufferedInputStream BIS;

    Image_Receive(JPanel westPanel, BufferedInputStream BIS) {
        this.westPanel = westPanel;
        this.BIS = BIS;
    }

    public void run() {
        try {
            Socket s = new Socket("violetookamiscythe.iptime.org", 16800);
            while (true) {
                westPanel.getGraphics().drawImage(ImageIO.read(ImageIO.createImageInputStream(BIS)), 0, 0, westPanel);
            }
        } catch (Exception e) {
            // TODO: handle exception
        }

    }

}

// 동작하지 않음
class PlainTextReceiveThread extends Thread {

    Socket socket;

    PlainTextReceiveThread(Socket s) {
        this.socket = s;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        super.run();
        try {
            BufferedReader BR = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String Message;
            String[] split;

            while (true) {
                Message = BR.readLine();
                split = Message.split(">");
                Client_S_INROOM.TA.append(Message);
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}

class temp_Receiver extends JFrame {

    BufferedInputStream BIS;

    static JPanel Panel = new JPanel();

   temp_Receiver() {
        
    setContentPane(Panel);
    setSize(1600,900);
    setVisible(true);
    try {

        Socket s=new Socket("violetookamiscythe.iptime.org",16800);
         while (true) {
              Panel.getGraphics().drawImage(ImageIO.read(ImageIO.createImageInputStream(BIS)), 0, 0, Panel);
           }
    } catch (Exception e) {
         //TODO: handle exception
    }
   
   }

}
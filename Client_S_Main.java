import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class Client_S_Main extends JFrame{

    JFrame S = new JFrame();

    Client_S_Main()
    {
        // 기본설정
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("VOS - Client S MAIN");
        setSize(1800, 900);
        setVisible(true);

        //왼쪽 패널 작업
        JPanel westPanel = new JPanel(new FlowLayout());
    }

    public static void main(String[] args) {
        Client_S_Main CSM = new Client_S_Main();
        
    }
}

//예상 개발 GUI를 모델로 사용함

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class Client_T extends JFrame {
    // MyListener ml = new MyListener();

    JFrame CTFrame = new JFrame();
    JButton btnCam = new JButton("카메라 공간");// 패널로 변경
    JButton btnSign = new JButton("신호 공간");// 패널로 변경
    JButton btnAdd = new JButton("기능 추가 공간");// 패널로 변경

    Client_T() {
        CTFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        CTFrame.setTitle("VOS - Client T");
        CTFrame.setSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize().width/2,Toolkit.getDefaultToolkit().getScreenSize().height-28));
        CTFrame.setLocation(Toolkit.getDefaultToolkit().getScreenSize().width/2, 0);
        JPanel addField = new JPanel();
        CTFrame.getContentPane().add(btnCam, BorderLayout.CENTER);
        CTFrame.getContentPane().add(addField, BorderLayout.SOUTH);
        CTFrame.getContentPane().add(btnSign, BorderLayout.EAST);
        addField.add(btnAdd);
        CTFrame.setVisible(true);
    }

    public static void main(String[] args) {
        Client_T CT = new Client_T();
    }

    /*
     * class MyListener implements ActionListener { public void
     * actionPerformed(ActionEvent e) {
     * 
     * } }
     */
}

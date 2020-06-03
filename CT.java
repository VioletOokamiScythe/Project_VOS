//예상 개발 GUI를 모델로 사용함

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class CT extends JFrame {
    //MyListener ml = new MyListener();

    JFrame CTFrame = new JFrame();
    JButton btnCam = new JButton("카메라 공간");
    JButton btnSign = new JButton("신호 공간");
    JButton btnAdd = new JButton("기능 추가 공간");

    CT() {
        CTFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        CTFrame.setTitle("VOS - Client T");
        CTFrame.setSize(500, 300);
        JPanel addField = new JPanel();
        CTFrame.getContentPane().add(btnCam, BorderLayout.CENTER);
        CTFrame.getContentPane().add(addField, BorderLayout.SOUTH);
        CTFrame.getContentPane().add(btnSign, BorderLayout.EAST);
        addField.add(btnAdd);
        CTFrame.setVisible(true);
    }

    public static void main(String[] args) {
        CT exe = new CT();
    }

    /*class MyListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

        }
    }*/
}
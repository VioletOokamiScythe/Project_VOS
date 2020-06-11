import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;


public class Client_S_SAVE extends JFrame{

     //패널 생성
     JPanel basePanel=new JPanel(new BorderLayout());
     JPanel northPanel=new JPanel(new FlowLayout());
     JPanel centerPanel=new JPanel(new FlowLayout());
     JPanel southPanel=new JPanel(new FlowLayout());

     //컴포넌트 생성
     JLabel titleLabel=new JLabel("VOS - Very Objective System");
     JLabel ExamCode=new JLabel("EXAM CODE");
     JTextField ExamCodeField=new JTextField();
     JLabel SubjectName=new JLabel("SUBJECT NAME");
     JTextField SubjectNameField=new JTextField();
     JLabel ExamTime=new JLabel("EXAM TIME");
     JComboBox ExamTimeHOUR=new JComboBox<String>();
     JLabel ExamTimeHourLabel=new JLabel("시");
     JComboBox ExamTimeMINUTE=new JComboBox<String>();
     JLabel ExamTimeMINUTELabel=new JLabel("분 시작");

     Client_S_SAVE(){
          // 기본설정
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("VOS - Client_S_SAVE");
        setSize(450,280);
        setVisible(true);
        setContentPane(basePanel);

        //컴포넌트 설정
        basePanel.add(northPanel,BorderLayout.NORTH);
        basePanel.add(centerPanel,BorderLayout.CENTER);
        basePanel.add(southPanel,BorderLayout.SOUTH);

        northPanel.add(titleLabel);
        centerPanel.add(ExamCode);
        centerPanel.add(ExamCodeField);
        centerPanel.add(SubjectName);
        centerPanel.add(SubjectNameField);
        centerPanel.add(ExamTime);
        centerPanel.add(ExamTimeHOUR);
        centerPanel.add(ExamTimeHourLabel);
        centerPanel.add(ExamTimeMINUTE);
        centerPanel.add(ExamTimeMINUTELabel);

        titleLabel.setPreferredSize(new Dimension(168, 28));
        ExamCode.setPreferredSize(new Dimension(168, 28));
        ExamCodeField.setPreferredSize(new Dimension(168, 28));
        SubjectName.setPreferredSize(new Dimension(168, 28));
        SubjectNameField.setPreferredSize(new Dimension(168, 28));
        ExamTime.setPreferredSize(new Dimension(112, 28));
        ExamTimeHOUR.setPreferredSize(new Dimension(65, 28));
        ExamTimeHourLabel.setPreferredSize(new Dimension(28, 28));
        ExamTimeMINUTE.setPreferredSize(new Dimension(65, 28));
        ExamTimeMINUTELabel.setPreferredSize(new Dimension(56, 28));
     }
     public static void main(String[] args) {
          Client_S_SAVE CSS=new Client_S_SAVE();
     }
}
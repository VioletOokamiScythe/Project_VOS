import java.io.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class Client_S_Save extends JFrame {

     // 시 분 문자열
     String[] HOUR = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17",
               "18", "19", "20", "21", "22", "23" };
     String[] MIN = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17",
               "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34",
               "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51",
               "52", "53", "54", "55", "56", "57", "58", "59" };

     // 패널 생성
     JPanel basePanel = new JPanel(new BorderLayout());
     JPanel northPanel = new JPanel(new FlowLayout());
     JPanel centerPanel = new JPanel(new FlowLayout());
     JPanel southPanel = new JPanel(new FlowLayout());

     // 컴포넌트 생성
     JLabel titleLabel = new JLabel("VOS - Very Objective System");
     JLabel ExamCode = new JLabel("EXAM CODE");
     JTextField ExamCodeField = new JTextField();
     JLabel SubjectName = new JLabel("SUBJECT NAME");
     JTextField SubjectNameField = new JTextField();
     JLabel ExamTime = new JLabel("EXAM TIME");
     JComboBox<String> ExamTimeHOUR = new JComboBox<String>();
     JLabel ExamTimeHourLabel = new JLabel("시");
     JComboBox<String> ExamTimeMINUTE = new JComboBox<String>();
     JLabel ExamTimeMINUTELabel = new JLabel("분 시작");
     JLabel Place =new JLabel("장소");
     JComboBox<String> ExamRoom=new JComboBox<String>();
     JLabel ExamRoomLable = new JLabel("호");

     JButton SaveButton = new JButton("저장");

     Client_S_Save() {
          // 기본설정
          setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
          setTitle("VOS - Client_S_Save");
          setSize(450, 280);
          setVisible(true);
          setContentPane(basePanel);

          class Listener implements ActionListener {
               @Override
               public void actionPerformed(ActionEvent e) {
                    // TODO Auto-generated method stub
                    if (e.getSource() == SaveButton) {
                         
                         try {
                              
                         } catch (Exception e0) {
                              // TODO: handle exception
                         }
                    }
               }
          }

          // 컴포넌트 설정
          basePanel.add(northPanel, BorderLayout.NORTH);
          basePanel.add(centerPanel, BorderLayout.CENTER);
          basePanel.add(southPanel, BorderLayout.SOUTH);

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
          centerPanel.add(Place);
          centerPanel.add(ExamRoom);
          centerPanel.add(ExamRoomLable);

          southPanel.add(SaveButton);

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
          Place.setPreferredSize(new Dimension(84, 28));
          ExamRoom.setPreferredSize(new Dimension(112, 28));
          ExamRoomLable.setPreferredSize(new Dimension(56, 28));
     
     

          for (int i = 0; i < HOUR.length; i++) {
               ExamTimeHOUR.addItem(HOUR[i]);
          }
          for (int i = 0; i < MIN.length; i++) {
               ExamTimeMINUTE.addItem(MIN[i]);
          }
          
     }

     public static void main(String[] args) {
          Client_S_Save CSS = new Client_S_Save();
     }
}
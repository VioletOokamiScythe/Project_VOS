import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class Dial extends JFrame {

     String Code;
     int Sign;

     Dial(int i) {
          switch (i) {
               case 0:
                    JOptionPane.showMessageDialog(null, "비어있는 필드가 있습니다", "오류", JOptionPane.ERROR_MESSAGE);
                    break;
               case 1:
                    JOptionPane.showMessageDialog(null, "정상 처리되었습니다.", "안내", JOptionPane.INFORMATION_MESSAGE);
                    Sign=1;
                    break;
               case 2:
                    int c = JOptionPane.showConfirmDialog(null, "정말로 이 시험을 삭제합니까?\n실행하면 다시 되돌릴 수 없습니다.", "경고",
                              JOptionPane.YES_NO_OPTION);
                    if (c == 0)
                         JOptionPane.showInputDialog(null, "자동 삭제 방지를 위해 시험 코드를 입력하세요.", "안내",
                                   JOptionPane.QUESTION_MESSAGE);
                    break;
               case 3:
                    JOptionPane.showMessageDialog(null, "회원정보가 맞지 않습니다", "오류", JOptionPane.ERROR_MESSAGE);
                    break;
               case 4:
                    JOptionPane.showMessageDialog(null, "현재 호스트입니다\n서버가 시작되었습니다\n응시자 접속을 백그라운드에서 기다립니다.", "안내",
                              JOptionPane.INFORMATION_MESSAGE);
                    break;
               case 5:
                    Code = JOptionPane.showInputDialog(null, "시험 코드를 입력하세요.", "안내", JOptionPane.QUESTION_MESSAGE);
                    break;
               case 6: // 임시
                    Code = JOptionPane.showInputDialog(null, "ip를 입력하세요.", "안내", JOptionPane.QUESTION_MESSAGE);
                    break;
               case 7:
                    JOptionPane.showMessageDialog(null, "이미 선점된 색상 코드입니다.", "오류", JOptionPane.ERROR_MESSAGE);
                    break;
               case 8:
                    JOptionPane.showMessageDialog(null, "이미 선점된 시간 및 장소입니다.", "오류", JOptionPane.ERROR_MESSAGE);
                    Sign=0;
                    break;

               default:
                    break;
          }
     }

     public static void main(String[] args) {

     }

     public String getCode() {
          return Code;
     }

     public int getSign(){
          return Sign;
     }
}
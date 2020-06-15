import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class Dial extends JFrame {
     Dial(int i) {
          switch (i) {
               case 0:
                    JOptionPane.showMessageDialog(null, "비어있는 필드가 있습니다", "오류", JOptionPane.ERROR_MESSAGE);
                    break;
               case 1:
                    JOptionPane.showMessageDialog(null, "정상 처리되었습니다.");
                    break;
               case 2:
                    break;
               case 3:
                    break;
               case 4:
                    break;
               case 5:
                    break;
               case 6:
                    break;

               default:
                    break;
          }
     }
}
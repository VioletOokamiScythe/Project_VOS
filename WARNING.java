import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;


public class WARNING extends JFrame{
    public void input_warning() { //모든 정보 미입력시 나오는 메시지
        JOptionPane.showMessageDialog(null, "모든 정보를 입력해야합니다.", "알림", JOptionPane.WARNING_MESSAGE);
    }
}

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
public class Remote_Controller {
     Robot robot;


     public void Refresh_Screen(int x, int y){
          robot.createScreenCapture(new Rectangle( x,  y));
     }

     public void Move_Mouse(int x, int y){
          robot.mouseMove(x, y);
     }

     public void Click_Mouse(){
         robot.mousePress(InputEvent.BUTTON1_MASK);
         robot.mouseRelease(InputEvent.BUTTON1_MASK);
     }

     public void Wheel_UP(){

     }

     public void Wheel_Down(){

     }


}
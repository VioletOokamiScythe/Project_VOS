import java.io.*;
import java.net.*;

public class Client_Image {

     public static void main(String[] args) {
          Socket S=null;

          try {
               S=new Socket("VioletOokamiScythe.iptime.org",5656);
          } catch (Exception e) {
               //TODO: handle exception
               e.printStackTrace();
          }
     }
}
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;


public class FileSend {
	public static final int DEFAULT_BUFFER_SIZE = 10000;
    public static void main(String[] args) {
        String serverIP = "211.150.161.63";             
        int port = Integer.parseInt("8484");   
        String FileName = "text.txt";              
         
        File file = new File(FileName);
        if (!file.exists()) {
            System.out.println("File not Exist.");
            System.exit(0);
        }
         
        long fileSize = file.length();
        long totalReadBytes = 0;
        byte[] buffer = new byte[DEFAULT_BUFFER_SIZE];
        int readBytes;
        double startTime = 0;
         
        try {
            FileInputStream fis = new FileInputStream(file);
            Socket socket = new Socket(serverIP, port);
            if(!socket.isConnected()){
              
                System.exit(0);
            }
             
            startTime = System.currentTimeMillis();
            OutputStream os = socket.getOutputStream();
            while ((readBytes = fis.read(buffer)) > 0) {
                os.write(buffer, 0, readBytes);
                totalReadBytes += readBytes;
                System.out.println("In progress: " + totalReadBytes + "/"
                        + fileSize + " Byte(s) ("
                        + (totalReadBytes * 100 / fileSize) + " %)");
            }
             
            System.out.println("전송 완료");
            fis.close();
            os.close();
            socket.close();
        } catch (UnknownHostException e) {        
            e.printStackTrace();
        } catch (IOException e) {        
            e.printStackTrace();
        }
    }

}

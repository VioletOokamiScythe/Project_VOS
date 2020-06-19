import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class FileReceive {
	 public static final int DEFAULT_BUFFER_SIZE = 10000;
	    public static void main(String[] args) {
	        int port =  Integer.parseInt("8484");  
	        String filename = args[1];              
	         
	        try {
	            ServerSocket server = new ServerSocket(port);
	            Socket socket = server.accept();  
	            InetSocketAddress ISA = (InetSocketAddress) socket.getRemoteSocketAddress();
	             
	            System.out.println("A client("+ ISA .getAddress().getHostAddress()+
	                    " is connected. (Port: " + ISA .getPort() + ")");
	             
	            FileOutputStream fos = new FileOutputStream(filename);
	            InputStream is = socket.getInputStream();
	             
	            double startTime = System.currentTimeMillis(); 
	            byte[] buffer = new byte[DEFAULT_BUFFER_SIZE];
	            int readBytes;
	            while ((readBytes = is.read(buffer)) != -1) {
	                fos.write(buffer, 0, readBytes);
	 
	            }      
	            double Timeend = System.currentTimeMillis();
	            double diffTime = (Timeend - startTime)/ 1000;;
	 
	            System.out.println("time: " + diffTime+ " second(s)");
	             
	            is.close();
	            fos.close();
	            socket.close();
	            server.close();
	        } catch (IOException e) {
	           
	            e.printStackTrace();
	        }
	    }
}

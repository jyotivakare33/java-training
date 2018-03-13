import java.net.*;    
import java.io.*;
public class ContentsServer   
{
  public static void main(String args[]) throws Exception
  {                         
    ServerSocket sersock = new ServerSocket(1234);
    while(true)
    {
		System.out.println("Server ready for connection");
		Socket sock = sersock.accept();                                
		BufferedReader contentRead = new BufferedReader(new FileReader("program.html"));			                                        
		String str,newStr="";
		PrintWriter pwrite = new PrintWriter(sock.getOutputStream());
		
		while((str = contentRead.readLine()) !=  null)
		{
			newStr+=str;
			System.out.println(str);
		}
		pwrite.println("HTTP/1.1 200 OK");
		pwrite.println("Content-Type: text/html");
		pwrite.println("\r\n");
		pwrite.println(newStr);
		pwrite.flush();
		pwrite.close();
		contentRead.close();
		sock.close();
	}
  }
}

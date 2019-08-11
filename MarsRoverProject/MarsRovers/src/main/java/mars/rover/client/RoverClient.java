package mars.rover.client;

/**
 *
 * @author Vedzah
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class RoverClient {
    
    public static void main(String args[]) throws IOException
	    {
	    String input = ""; 
	    Socket s = new Socket("localhost",8080);
	    
	    PrintWriter output = new PrintWriter(s.getOutputStream(), true);
	    BufferedReader inputReader = new BufferedReader(new InputStreamReader(s.getInputStream()));
	    BufferedReader outputReader =  new BufferedReader(new InputStreamReader(s.getInputStream()));
	    BufferedReader  bufferedReader =  new BufferedReader(new InputStreamReader(System.in));
	    
	    while (!"END".equals(input)){
	    
	        System.out.println("text 'END' to exit:");
	        System.out.println("OR");
	        System.out.println("Enter text to send to server to establ connection:");
	        
	        input = bufferedReader.readLine();

	        output.write(String.format("%s\n", input));
	        output.flush();

	        System.out.println("echo from Server: " + outputReader.readLine());
	        System.out.println();
	        System.out.println();
	    }
	                 
	    }
    
}

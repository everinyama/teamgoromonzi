package mars.rover.server;

/**
 *
 * @author Vedzah
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

import mars.rover.interfaces.Messages;

public abstract class Rover implements Messages  {
    
    /**
     * ///
     */
    @Override
    public void establishConnection() {
       try{
           ServerSocket serverSocket =new ServerSocket(8080);
           
           Socket socket = null;
           System.out.println(String.format("Rover server started successifully"
                   + ", waiting for client to send init data"));
           
           try{
               
               socket=serverSocket.accept();
               PrintWriter output = new PrintWriter(socket.getOutputStream(),
                       true);
               BufferedReader input = new BufferedReader(new InputStreamReader
        (socket.getInputStream()));
               
               while(true) {
                   
                   String UserInput = input.readLine();
                   System.out.println("Input from client:" + UserInput);
                   if("send".equals(UserInput))
                {
                    recieveTelemetryData();
                }
                   output.println(UserInput.toUpperCase());
                   
                   
                   System.out.println();
                   System.out.println();
               }
               
               
           }finally{
               
               if(socket !=null)
                   socket.close();
               serverSocket.close();
               
           }
           
       }   catch (IOException ex) {
            Logger.getLogger(Rover.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    /**
     * ///
     */
    @Override
    public void recieveTelemetryData() {
        
        try {
            String input = "";
            Socket s = new Socket("localhost",8080);
            
            PrintWriter output = new PrintWriter(s.getOutputStream(), true);
            BufferedReader inputReader = new BufferedReader(new
         InputStreamReader(s.getInputStream()));
            BufferedReader outputReader =  new BufferedReader(new 
         InputStreamReader(s.getInputStream()));
            BufferedReader  bufferedReader =  new BufferedReader(new
         InputStreamReader(System.in));
            
            while (!"END".equals(input)){
                
                System.out.println("text 'END' to exit:");
                System.out.println("OR");
                System.out.println("Enter telemetry data eg, 1223.5,344534;5km/hr;rough surface with small stones");
                input = bufferedReader.readLine();
                System.out.println("\n");
                
                System.out.println("Enter finish when you have finished entering data");
                input = bufferedReader.readLine();
                
                System.out.println("\n");
                
                System.out.println("Rover is now moving on the Mars terrain....");
                
                System.out.println("Enter 'B' to send crush adverse message:");
                System.out.println("OR");
                System.out.println("Enter 'T' to signal rover has reached "
                        + "home base successfully:");
                
                input = bufferedReader.readLine();
                
                
                if("B".equals(input))
                {
                    sendCrushMessage();
                } else if("T".equals(input)) {
                
                    sendSuccessMessage();
                }
                
                output.write(String.format("%s\n", input));
                output.flush();
                
                System.out.println("echo from Server: " + outputReader.readLine());
                
                System.out.println();
                System.out.println();
            }
        } catch (IOException ex) {
            Logger.getLogger(Rover.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    /**
     * ///
     */
    @Override
    public void sendCrushMessage() {
        
        System.out.println("Rover has crashed against a boulder or the map edge");
        
    }
    
    /**
     * ///
     */
    @Override
    public void sendSuccessMessage() {
        
        System.out.println("Rover has successfully reached home base");
        
    }
    
    
    public static void main(String args[]) throws IOException 
    {
        Rover rover = new Rover(){};
        rover.establishConnection();
    }   
}

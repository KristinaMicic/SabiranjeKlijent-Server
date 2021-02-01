package sabiranje2broja;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Kristina
 */
public class Server implements Runnable {
         
    @Override
    public void run() {
    
    //public void run(Thread thread) throws IOException{
    try{
        Scanner userInput = new Scanner(System.in);
        String port;
        
        port = userInput.next();
        System.out.println("Ponovite broj porta");
        
        ServerSocket server = new ServerSocket (Integer.parseInt(port));
        while(true){
            Socket socket = server.accept();
            System.out.println("Konekcija uspesna.");
        
            InputStream is = socket.getInputStream();
            OutputStream os = socket.getOutputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
        
            System.out.println("Sabirci su:");
            String sabirci  = br.readLine();
            System.out.println(sabirci);
        
            int sabirak1 = Integer.parseInt(sabirci.split(",")[0]);
            int sabirak2 = Integer.parseInt(sabirci.split(",")[1]);
        
            String rezultat = String.valueOf(sabirak1 + sabirak2);
        
            os.write((rezultat+"\r\n").getBytes());
            userInput.close();
       }
    } 
    catch(IOException e){
        e.printStackTrace();
        }
}

}  

  
        
 
 

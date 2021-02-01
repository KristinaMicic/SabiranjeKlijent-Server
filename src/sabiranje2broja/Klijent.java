package sabiranje2broja;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Klijent implements Runnable {
@Override
    public void run() {
        
   // public void run(String[] args) throws IOException{
        
        while(true){
            Scanner userInput = new Scanner(System.in);
            System.out.println("Upisite broj porta: ");
            String port;
            port = userInput.nextLine();
        
            try {
                System.out.println("Konektovan server na port " + port);
            
                Socket socket = new Socket("localhost", Integer.parseInt(port));
                
                System.out.println("");
                
                InputStream is = socket.getInputStream();
                OutputStream os = socket.getOutputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(is));
                
                String sabirak1 = userInput.nextLine()+"\r\n";
                System.out.println("Sabirak 1:" + sabirak1);
                
                String sabirak2 = userInput.nextLine()+"\r\n";
                System.out.println("Sabirak 2:" + sabirak2);
                
                String sabirci = (sabirak1.trim() + "," + sabirak2.trim())+"\r\n";
                os.write(sabirci.getBytes());
                
                System.out.println("Rezultat je:\r\n");
                System.out.println(br.readLine());

                socket.close();
                userInput.close();
            
            } 
            catch (IOException e) {
                e.printStackTrace();
        }
        
        }
    }
}    
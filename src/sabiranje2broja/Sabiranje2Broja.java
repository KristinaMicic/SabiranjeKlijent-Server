package sabiranje2broja;

/**
 *
 * @author Kristina
 */
public class Sabiranje2Broja extends Thread{
    
    public static void main (String[] args){
        
        Server thread = new Server();
        Thread s = new Thread(thread);
        s.start();
        
        Klijent thr = new Klijent();
        Thread k = new Thread(thr);
        k.start();
        

     
        
    
    
}}

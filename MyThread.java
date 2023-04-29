import java.util.Random;

public class MyThread extends Thread {
    
    public int flashed;
    
        public void run(){
            
            Random random = new Random();
            for(int counter=1; counter<=10; counter++){
                flashed = random.nextInt(4) + 1;
                //System.out.println(flashed);
                try{
                    Thread.sleep(1000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                    System.out.println("flashed");
                }
                }
            
        }

}

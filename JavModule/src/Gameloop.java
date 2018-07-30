import java.util.ArrayList;

public class Gameloop implements Runnable{

    private boolean running=true;

    @Override
    public void run(){

        while(running){

            try {

                Thread.sleep(40);
            } catch (Exception ex) {
            }
        }
    }

}

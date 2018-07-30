import java.util.ArrayList;

public class Gameloop implements InputListener{

    private boolean running=true;
    public ArrayList<InputManager.Event> events;

    public void run(){

        while(running){

            try {

                Thread.sleep(40);
            } catch (Exception ex) {
            }
        }
    }
    @Override
    public void onPlayerMove(InputManager.Event event){
        events.add(event);
    }
}

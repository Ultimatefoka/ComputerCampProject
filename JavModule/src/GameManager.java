import java.util.ArrayList;

public class GameManager implements InputListener{
    private static GameManager Manager=null;
    public static GameManager getInstance() {
        if (Manager==null) {
            return Manager=new GameManager();
        }
        else {
            return Manager;
        }
    }
    public ArrayList<InputManager.Event> events;
    @Override
    public void onPlayerMove(InputManager.Event event){
        events.add(event);
    }
    public void update(){

    }
}

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

public class GameManager implements InputListener{
    private BufferedImage grass=ImageIO.read(GameManager.class.getResourceAsStream("/Images/stone.png" ));
    private BufferedImage stone=ImageIO.read(GameManager.class.getResourceAsStream("/Images/grass.png" ));
    private BufferedImage wall=ImageIO.read(GameManager.class.getResourceAsStream("/Images/wall.png" ));
    private BufferedImage black=ImageIO.read(GameManager.class.getResourceAsStream("/Images/black.png" ));
    private static GameManager Manager=null;
    public GameManager() throws IOException {
    }

    public static GameManager getInstance() throws IOException {
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
    public BufferedImage getBI(String graphic){
        if(graphic.equals("wall")){
            return wall;
        }else if(graphic.equals("stone")){
            return stone;
        }else if(graphic.equals("grass")){
            return grass;
        }else{
            return black;
        }
    }

    /*public Map getMap(String name){
        for(Map map : maps) {
            if (name.equals(map.getName())){
                return map;
            }
        }
        return null;
    }*/

    public ArrayList<Door> doorsInMap(String name){
        ArrayList<Door> doors=null;
        for(Door door:Data.getGameAssetsInstance().getDoors()){
            if(name.equals(door.getMap())){
                doors.add(door);
            }
        }
        return doors;
    }


}

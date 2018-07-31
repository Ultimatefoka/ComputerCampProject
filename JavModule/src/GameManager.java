import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

public class GameManager implements InputListener{

    private BufferedImage grass=ImageIO.read(GameManager.class.getResourceAsStream("/Images/stone.png" ));
    private BufferedImage stone=ImageIO.read(GameManager.class.getResourceAsStream("/Images/grass.png" ));
    private BufferedImage wall=ImageIO.read(GameManager.class.getResourceAsStream("/Images/wall.png" ));
    private BufferedImage player=ImageIO.read(GameManager.class.getResourceAsStream("/Images/player.png" ));
    private BufferedImage black=ImageIO.read(GameManager.class.getResourceAsStream("/Images/black.png" ));
    private static GameManager Manager=null;
    private ArrayList<Tile[][]>  maps;

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
        for(Map map : Data.getGameAssetsInstance().maps) {
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

    public void createMap() {

        for ( Map map: Data.getGameAssetsInstance().getMaps() ) {

            maps.add(new Tile[32][32]);

        }

        for ( int j = 0; j < maps.size(); j++ ) {

            for (int i = 0; i < 32; i++) {

                for (int n = 0; n < 32; n++) {

                    //if(Data.getGameAssetsInstance().getMaps().get(j).getTiles()[i][n].getName);

                }
            }
        }

    }
}

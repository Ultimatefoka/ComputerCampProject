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
    private Tile[][] currentMap;

    public ArrayList<InputManager.Event> events;

    public GameManager() throws IOException {
        events = new ArrayList<InputManager.Event>();
    }

    public static GameManager getInstance() throws IOException {
        if (Manager==null) {
            return Manager=new GameManager();
        }
        else {
            return Manager;
        }
    }
    @Override
    public void onPlayerMove(InputManager.Event event){
        events.add(event);
    }

    public Tile[][] getCurrentMap() {
        return currentMap;
    }


    public void update(){
        for (int i = 0; i < events.size(); i++) {
            InputManager.Event event = events.remove(i);
            switch (event) {
                case MOVE_DOWN:
                    Data.getGameAssetsInstance().getPlayer().MoveDown();
                    break;
                case MOVE_UP:
                    Data.getGameAssetsInstance().getPlayer().MoveUp();
                    break;
                case MOVE_LEFT:
                    Data.getGameAssetsInstance().getPlayer().MoveLeft();
                    break;
                case MOVE_RIGHT:
                    Data.getGameAssetsInstance().getPlayer().MoveRight();
                    break;
                default:
                    break;
            }
        }
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

    public ArrayList<Door> doorsInMap(String name){
        ArrayList<Door> doors=null;
        for(Door door:Data.getGameAssetsInstance().getDoors()){
            if(name.equals(door.getMap())){
                doors.add(door);
            }
        }
        return doors;
    }

    public void createMap(String name) {

        currentMap = new Tile[32][32];

        for ( int j = 0; j < Data.getGameAssetsInstance().getMaps().size(); j++ ) {

            if (Data.getGameAssetsInstance().getMaps().get(j).getName() == name) {

                for (int i = 0; i < 32; i++) {

                    for (int n = 0; n < 32; n++) {

                        for(int m = 0; m < Data.getGameAssetsInstance().getTiles().size(); m++) {

                            if (Data.getGameAssetsInstance().getMaps().get(j).getTiles()[i][n] == Data.getGameAssetsInstance().getTiles().get(m).getName()) {

                                currentMap[i][n] = Data.getGameAssetsInstance().getTiles().get(m);
                            }
                        }
                    }
                }
            }
        }

    }
}

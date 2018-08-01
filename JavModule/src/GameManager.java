import GameObjects.Door;
import GameObjects.Player;
import GameObjects.Tile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;


public class GameManager implements InputListener{

    private BufferedImage boden_grass=ImageIO.read(GameManager.class.getResourceAsStream("/Images/boden_grass.png" ));
    private BufferedImage boden_erde=ImageIO.read(GameManager.class.getResourceAsStream("/Images/boden_erde.png" ));
    private BufferedImage boden_erde_grasskanteru=ImageIO.read(GameManager.class.getResourceAsStream("/Images/boden_erde_grasskanteru.png" ));
    private BufferedImage boden_erde_grasseckeru=ImageIO.read(GameManager.class.getResourceAsStream("/Images/boden_erde_grasseckeru.png" ));
    private BufferedImage boden_erde_grasskanteu=ImageIO.read(GameManager.class.getResourceAsStream("/Images/boden_erde_grasskanteu.png" ));
    private BufferedImage boden_grauekachel=ImageIO.read(GameManager.class.getResourceAsStream("/Images/boden_grauekachel.png" ));
    private BufferedImage wand_graueziegel=ImageIO.read(GameManager.class.getResourceAsStream("/Images/wand_graueziegel.png" ));
    private BufferedImage wand_stein=ImageIO.read(GameManager.class.getResourceAsStream("/Images/wand_stein.png" ));
    private BufferedImage player=ImageIO.read(GameManager.class.getResourceAsStream("/Images/player.png" ));
    private BufferedImage black=ImageIO.read(GameManager.class.getResourceAsStream("/Images/black.png" ));
    private BufferedImage door_door=ImageIO.read(GameManager.class.getResourceAsStream("/Images/door_door.png" ));
    private BufferedImage door_leiter=ImageIO.read(GameManager.class.getResourceAsStream("/Images/door_leiter.png" ));
    private BufferedImage door_stein=ImageIO.read(GameManager.class.getResourceAsStream("/Images/door_stein.png" ));
    private BufferedImage door_dungeon1=ImageIO.read(GameManager.class.getResourceAsStream("/Images/door_dungeon1.png" ));
    private static GameManager Manager=null;
    private Tile[][] currentMap;

    public ArrayList<InputManager.Event> events;

    public GameManager() throws IOException {
        events = new ArrayList<InputManager.Event>();
    }
    public void initInputManager(Frame frame) {
        InputManager.getInstance().setFrame(frame);
        InputManager.getInstance().setInputListener(this);
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
            Player currentPlayer = new Player("player",Data.getGameAssetsInstance().getPlayer().getMapName(), Data.getGameAssetsInstance().getPlayer().getX(), Data.getGameAssetsInstance().getPlayer().getY());
            switch (event) {
                case MOVE_DOWN:
                    currentPlayer.MoveDown();
                    checkPlayerCollision(event, currentPlayer);
                    break;
                case MOVE_UP:
                    currentPlayer.MoveUp();
                    checkPlayerCollision(event, currentPlayer);
                    break;
                case MOVE_LEFT:
                    currentPlayer.MoveLeft();
                    checkPlayerCollision(event, currentPlayer);
                    break;
                case MOVE_RIGHT:
                    currentPlayer.MoveRight();
                    checkPlayerCollision(event, currentPlayer);
                    break;
                default:
                    break;
            }
        }
    }

    private void checkPlayerCollision(InputManager.Event event, Player currentPlayer) {

        if(!CollisionManager.getCollisionManagerInstance().collidesWithObstacle(currentPlayer, currentMap)) {

            switch(event) {

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
            }
        }
    }

    public BufferedImage getBI(String graphic){
        switch (graphic) {
            case "wand_graueziegel":
                return wand_graueziegel;
            case "wand_stein":
                return wand_stein;
            case "boden_grauekachel":
                return boden_grauekachel;
            case "boden_grass":
                return boden_grass;
            case "boden_erde_grasskanteru":
                return boden_erde_grasskanteru;
            case "boden_erde_grasskanteu":
                return boden_erde_grasskanteu;
            case "boden_erde_grasseckeru":
                return boden_erde_grasseckeru;
            case "boden_erde":
                return boden_erde;
            case "player":
                return player;
            case "door_door":
                return door_door;
            case "door_leiter":
                return door_leiter;
            case "door_stein":
                return door_stein;
            case "door_dungeon1":
                return door_dungeon1;
            default:
                return black;
        }
    }

    public ArrayList<Door> doorsInMap(String name){
        ArrayList<Door> doors= new ArrayList<>();
        for(Door door:Data.getGameAssetsInstance().getDoors()){
            if(name.equals(door.getMap())){
                doors.add(door);
            }
        }
        return doors;
    }

    public void createMap(String name) {

        for ( int j = 0; j < Data.getGameAssetsInstance().getMaps().size(); j++ ) {

            if (Data.getGameAssetsInstance().getMaps().get(j).getName().equals(name) ) {

                int sizeX = Data.getGameAssetsInstance().getMaps().get(j).getSizeX();
                int sizeY = Data.getGameAssetsInstance().getMaps().get(j).getSizeY();

                currentMap = new Tile[sizeY][sizeX];

                for (int i = 0; i < sizeY; i++) {

                    for (int n = 0; n < sizeX; n++) {

                        for(int m = 0; m < Data.getGameAssetsInstance().getTiles().size(); m++) {

                            if (Data.getGameAssetsInstance().getMaps().get(j).getTiles()[i][n].equals(Data.getGameAssetsInstance().getTiles().get(m).getName() ) ) {

                                currentMap[i][n] = Data.getGameAssetsInstance().getTiles().get(m);

                            }
                        }
                    }
                }
            }
        }
    }
}

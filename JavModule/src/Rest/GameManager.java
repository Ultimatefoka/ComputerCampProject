package Rest;

import GameObjects.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;


public class GameManager implements InputListener{


    private static GameManager Manager = null;
    private Tile[][] currentMap;
    private int tileSize=64;

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

    public int getTileSize() {
        return tileSize;
    }

    @Override
    public void onPlayerMove(InputManager.Event event){
        events.add(event);
    }

    @Override
    public void onPlayerAttack() {
        events.add(InputManager.Event.ATTACK);
    }

    public Tile[][] getCurrentMap() {
        return currentMap;
    }


    public void update() throws IOException {
        for (int i = 0; i < events.size(); i++) {
            InputManager.Event event = events.remove(i);
            Player currentPlayer = new Player(

                    Data.getGameAssetsInstance().getPlayer().getSprites(),Data.getGameAssetsInstance().getPlayer().getMapName(),
                    Data.getGameAssetsInstance().getPlayer().getX(), Data.getGameAssetsInstance().getPlayer().getY()
            );

            switch (event) {
                case MOVE_DOWN:
                    currentPlayer.moveDown();
                    checkPlayerCollision(event, currentPlayer);
                    break;
                case MOVE_UP:
                    currentPlayer.moveUp();
                    checkPlayerCollision(event, currentPlayer);
                    break;
                case MOVE_LEFT:
                    currentPlayer.moveLeft();
                    checkPlayerCollision(event, currentPlayer);
                    break;
                case MOVE_RIGHT:
                    currentPlayer.moveRight();
                    checkPlayerCollision(event, currentPlayer);
                    break;
                case ATTACK:
                    checkPlayerAttack();
                    break;
                default:
                    break;
            }
        }
        for(HostileNPC npc:hNPCsInMap(Data.getGameAssetsInstance().getPlayer().getMapName())) {
            if(npc.getState()==NPC.State.ALIVE) {
                npc.move();
            }
        }
        /*for(NeutralNPC npc:nNPCsInMap(Data.getGameAssetsInstance().getPlayer().getMapName())) {
            if(npc.getState()==NPC.State.ALIVE) {
                npc.walkPathing();
            }
        }*/
    }

    private void checkPlayerAttack() {

        if(HitManager.getHitManagerInstance().hitsHostileNPC()) {

            for(int i = 0;i < HitManager.getHitManagerInstance().getHostileNPCsHit().size(); i++) {

                Data.getGameAssetsInstance().getHostileNPCs().get(HitManager.getHitManagerInstance().getHostileNPCsHit().get(i)).setHealth(Data.getGameAssetsInstance().getHostileNPCs().get(HitManager.getHitManagerInstance().getHostileNPCsHit().get(i)).getHealth() - Data.getGameAssetsInstance().getPlayer().getDamage());
                System.out.println(Data.getGameAssetsInstance().getHostileNPCs().get(HitManager.getHitManagerInstance().getHostileNPCsHit().get(i)).getHealth());
            }

            //Data.getGameAssetsInstance().getHostileNPCs().get(HitManager.getHitManagerInstance().getHostileNPCHit()).setHealth(Data.getGameAssetsInstance().getHostileNPCs().get(HitManager.getHitManagerInstance().getHostileNPCHit()).getHealth() - Data.getGameAssetsInstance().getPlayer().getDamage());
            //System.out.println(Data.getGameAssetsInstance().getHostileNPCs().get(HitManager.getHitManagerInstance().getHostileNPCHit()).getHealth());
        }
    }

        private void checkPlayerCollision(InputManager.Event event, Player currentPlayer) throws IOException {

        if(CollisionManager.getCollisionManagerInstance().collidesWithDoor(currentPlayer)) {
            String targetMap =Data.getGameAssetsInstance().getDoors().get(CollisionManager.getCollisionManagerInstance().getCollidedDoor()).getTargetMap();
            Data.getGameAssetsInstance().getPlayer().setMapName(targetMap);
            Data.getGameAssetsInstance().getPlayer().setX(Data.getGameAssetsInstance().getDoors().get(CollisionManager.getCollisionManagerInstance().getCollidedDoor()).getTargetX());
            Data.getGameAssetsInstance().getPlayer().setY(Data.getGameAssetsInstance().getDoors().get(CollisionManager.getCollisionManagerInstance().getCollidedDoor()).getTargetY());
            /*for(HostileNPC npc:hNPCsInMap(targetMap)){
                npc.setX(npc.getStartX());
                npc.setY(npc.getStartY());
            }
            for(NeutralNPC npc:nNPCsInMap(targetMap)){
                npc.setX(npc.getStartX());
                npc.setY(npc.getStartY());
            }*/

            switch (event) {

                case MOVE_LEFT:
                    Data.getGameAssetsInstance().getPlayer().setFacing(Player.Facing.LEFT);
                    break;

                case MOVE_DOWN:
                    Data.getGameAssetsInstance().getPlayer().setFacing(Player.Facing.DOWN);
                    break;

                case MOVE_UP:
                    Data.getGameAssetsInstance().getPlayer().setFacing(Player.Facing.UP);
                    break;

                case MOVE_RIGHT:
                    Data.getGameAssetsInstance().getPlayer().setFacing(Player.Facing.RIGHT);
                    break;

                default:
                    break;
            }

            return;
        }

        if(!CollisionManager.getCollisionManagerInstance().collidesWithObstacle(currentPlayer, currentMap)) {

            switch(event) {

                case MOVE_DOWN:
                    Data.getGameAssetsInstance().getPlayer().moveDown();
                    break;

                case MOVE_UP:
                    Data.getGameAssetsInstance().getPlayer().moveUp();
                    break;

                case MOVE_LEFT:
                    Data.getGameAssetsInstance().getPlayer().moveLeft();
                    break;

                case MOVE_RIGHT:
                    Data.getGameAssetsInstance().getPlayer().moveRight();
                    break;
            }
        } else {

            switch(event) {

                case MOVE_DOWN:
                    Data.getGameAssetsInstance().getPlayer().setFacing(Player.Facing.DOWN);
                    break;

                case MOVE_UP:
                    Data.getGameAssetsInstance().getPlayer().setFacing(Player.Facing.UP);
                    break;

                case MOVE_LEFT:
                    Data.getGameAssetsInstance().getPlayer().setFacing(Player.Facing.LEFT);
                    break;

                case MOVE_RIGHT:
                    Data.getGameAssetsInstance().getPlayer().setFacing(Player.Facing.RIGHT);
                    break;
            }
        }
    }

    public ArrayList<Door> doorsInMap(String name) {
        ArrayList<Door> doors = new ArrayList<>();
        for (Door door : Data.getGameAssetsInstance().getDoors()) {
            if (name.equals(door.getMap())) {
                doors.add(door);
            }
        }
        return doors;
    }

    public ArrayList<HostileNPC> hNPCsInMap(String name){
        ArrayList<HostileNPC> npcs = new ArrayList<>();
        for (HostileNPC npc : Data.getGameAssetsInstance().getHostileNPCs()) {
            if (name.equals(npc.getMap())) {
                npcs.add(npc);
            }
        }
        return npcs;
    }
    public ArrayList<NeutralNPC> nNPCsInMap(String name){
        ArrayList<NeutralNPC> npcs = new ArrayList<>();
        for (NeutralNPC npc : Data.getGameAssetsInstance().getNeutralNPCs()) {
            if (name.equals(npc.getMap())) {
                npcs.add(npc);
            }
        }
        return npcs;
    }

    public void createMap(String name) {

        for (int j = 0; j < Data.getGameAssetsInstance().getMaps().size(); j++) {

            if (Data.getGameAssetsInstance().getMaps().get(j).getName().equals(name)) {

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

package GameObjects;

import GameObjects.NPC;
import Rest.Data;

import java.util.Date;


public class HostileNPC extends NPC {

    private int health;

    public HostileNPC (String graphic, String name, int x, int y, String map, int health, int speed) {

        super(graphic, name, x, y, map,speed);
        this.health = health;

    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void move(){
        int playerX=Data.getGameAssetsInstance().getPlayer().getX();
        int playerY=Data.getGameAssetsInstance().getPlayer().getY();
        if(playerX-20>getX()){
            MoveRight();
        }else  if(playerX+20<getX()){
            MoveLeft();
        }else if(playerY-20>getY()){
            MoveUp();
        }else if(playerY+20<getY()){
            MoveDown();
        }
    }
}

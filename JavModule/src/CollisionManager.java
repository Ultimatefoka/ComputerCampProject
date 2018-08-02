import GameObjects.Player;
import GameObjects.Tile;

import java.io.IOException;

public class CollisionManager {

    private static CollisionManager collisionManagerInstance;
    private int collidedDoor;

    public static CollisionManager getCollisionManagerInstance() {

        if(collisionManagerInstance == null) {

            collisionManagerInstance = new CollisionManager();
        }

        return collisionManagerInstance;
    }

    public boolean collidesWithObstacle(Player player, Tile[][] map) throws IOException {

        if(map[(int)(player.getY()/GameManager.getInstance().getTileSize())][(int)(player.getX()/GameManager.getInstance().getTileSize())].isTraversable()) {
            return false;
        }

        return true;
    }

    public boolean collidesWithDoor(Player player) {

        for(int i = 0; i < Data.getGameAssetsInstance().getDoors().size(); i++) {

            if(player.getMapName().equals(Data.getGameAssetsInstance().getDoors().get(i).getMap()) && player.getX() == Data.getGameAssetsInstance().getDoors().get(i).getX() && player.getY() == Data.getGameAssetsInstance().getDoors().get(i).getY()) {

                collidedDoor = i;
                return true;
            }
        }

        return false;
    }

    public int getCollidedDoor() {
        return collidedDoor;
    }

    public void setCollidedDoor(int collidedDoor) {
        this.collidedDoor = collidedDoor;
    }
}

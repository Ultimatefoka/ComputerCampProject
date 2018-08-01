import GameObjects.Player;
import GameObjects.Tile;

public class CollisionManager {

    private static CollisionManager collisionManagerInstance;

    public static CollisionManager getCollisionManagerInstance() {

        if(collisionManagerInstance == null) {

            collisionManagerInstance = new CollisionManager();
        }

        return collisionManagerInstance;
    }

    public boolean collidesWithObstacle(Player player, Tile[][] map) {

        if(map[player.getY()][player.getX()].isTraversable()) {

            return false;
        }

        return true;
    }
}

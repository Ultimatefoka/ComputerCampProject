package GameObjects;
import java.util.concurrent.TimeUnit;

public class NeutralNPC extends NPC {

    private int distanceX;
    private int distanceY;

    public NeutralNPC(String graphic, String name, int x, int y, String map, int distanceX, int distanceY) {

        super(graphic, name, x, y, map);
        this.distanceX = distanceX;
        this.distanceY = distanceY;

    }

    public void createPatrol() {

        this.addWaypoint(distanceX, distanceY);
        this.addWaypoint(-distanceX, -distanceY);

    }

    public void walkPathing() {

        while (!this.getTargets().isEmpty()) {

            if (this.getX() != this.getX() + this.getTargets().get(0).getX()) {

                this.setX(this.getX() + 1);

            }
            if (this.getY() != this.getY() + this.getTargets().get(0).getX()) {

                this.setY(this.getY() + 1);
            }

        }

        if (this.getTargets().isEmpty()) {

            createPatrol();
            walkPathing();
            
        }

    }

}

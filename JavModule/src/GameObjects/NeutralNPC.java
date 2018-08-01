package GameObjects;
import java.util.concurrent.TimeUnit;

public class NeutralNPC extends NPC {

    private boolean busy = false;
    private int distanceX;
    private int distanceY;

    public NeutralNPC(String graphic, String name, int x, int y, String map, int distanceX, int distanceY) {

        super(graphic, name, x, y, map);
        this.distanceX = distanceX;
        this.distanceY = distanceY;

    }

    public void createPathing() {

        this.addWaypoint(distanceX, distanceY);
        this.addWaypoint(-distanceX, -distanceY);

    }

    public void move() {



    }

    public void setBusy(boolean busy) {
        this.busy = busy;
    }

    public boolean getBusy() {
        return busy;
    }
}

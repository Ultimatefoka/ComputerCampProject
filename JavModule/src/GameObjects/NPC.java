package GameObjects;
import java.util.ArrayList;

public abstract class NPC {

    private String graphic;
    private String name;
    private int x;
    private int y;
    private String map;
    private ArrayList<Waypoint> targets;

    public NPC (String graphic, String name, int x, int y, String map) {

        this.graphic = graphic;
        this.name = name;
        this.x = x;
        this.y = y;
        this.map = map;

    }


    public void addWaypoint(int x, int y) {
        targets.add(new Waypoint(x,y));
    }

    public void removeWaypoint(int index) {
        targets.remove(index);
    }

    public ArrayList<Waypoint> getTargets() {
        return targets;
    }

    public void setGraphic(String graphic) {
        this.graphic = graphic;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setMap(String map) {
        this.map = map;
    }

    public String getName() {
        return name;
    }

    public String getGraphic() {
        return graphic;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void MoveUp(){
        y+=1;
    }

    public void MoveRight(){
        x+=1;
    }

    public void MoveLeft(){
        x-=1;
    }

    public void MoveDown(){
        y-=1;
    }

}

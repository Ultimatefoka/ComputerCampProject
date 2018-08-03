package GameObjects;
import java.util.ArrayList;

public abstract class NPC {

    private String graphic;
    private String name;
    private int startX;
    private int startY;
    private int x;
    private int y;
    private String map;
    private ArrayList<Vector> targets;
    private int speed;
    private State state;

    public enum State {

        DEAD, ALIVE;
    }

    public NPC (String graphic, String name, int x, int y, String map,int speed) {

        this.graphic = graphic;
        this.name = name;
        startX=x;
        startY=y;
        this.x = x;
        this.y = y;
        this.map = map;
        this.speed=speed;

    }


    public void addVector(int x, int y) {
        targets.add(new Vector(x,y));
    }

    public void removeVector(int index) {
        targets.remove(index);
    }

    public ArrayList<Vector> getTargets() {
        return targets;
    }

    public void setGraphic(String graphic) {
        this.graphic = graphic;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMap() {
        return map;
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
        y+=speed;
    }

    public void MoveRight(){
        x+=speed;
    }

    public void MoveLeft(){
        x-=speed;
    }

    public void MoveDown(){
        y-=speed;
    }

    public int getStartX() {
        return startX;
    }

    public int getStartY() {
        return startY;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}

package GameObjects;

import GameObjects.Item;

public class Door extends Item {

    private int targetX;
    private int targetY;
    private String targetMap;
    private String map;

    public Door(String graphic, String name, int x, int y, int targetX, int targetY, String targetMap, String map) {

        super(graphic, name, x, y);
        this.targetX = targetX;
        this.targetY = targetY;
        this.map = map;

    }

    public void setTargetX(int targetX) {
        this.targetX = targetX;
    }

    public void setTargetY(int targetY) {
        this.targetY = targetY;
    }

    public void setTargetMap(String targetMap) {
        this.targetMap = targetMap;
    }

    public void setMap(String map) {
        this.map = map;
    }

    public int getTargetX() {
        return targetX;
    }

    public int getTargetY() {
        return targetY;
    }

    public String getTargetMap() {
        return targetMap;
    }

    public String getMap() {
        return map;
    }
}

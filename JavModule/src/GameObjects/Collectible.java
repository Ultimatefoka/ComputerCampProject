package GameObjects;

public class Collectible {

    private String name;
    private int x;
    private int y;
    private String item;
    private String map;

    public Collectible(String name, int x, int y, String item, String map) {

        this.name = name;
        this.x = x;
        this.y = y;
        this.item = item;
        this.map = map;

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

    public void setItem(String item) {
        this.item = item;
    }

    public void setMap(String map) {
        this.map = map;
    }

    public String getName() {
        return name;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getItem() {
        return item;
    }

    public String getMap() {
        return map;
    }
}

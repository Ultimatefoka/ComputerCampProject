package GameObjects;

public class Map {

    private String name;
    private String[][] tiles;
    private int sizeX;
    private int sizeY;

    public Map(String name, String[][] tiles, int sizeX, int sizeY) {

        this.name = name;
        this.tiles = tiles;
        this.sizeX = sizeX;
        this.sizeY = sizeY;

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTiles(String[][] tiles) {
        this.tiles = tiles;
    }

    public void setSizeX(int sizeX) {
        this.sizeX = sizeX;
    }

    public void setSizeY(int sizeY) {
        this.sizeY = sizeY;
    }

    public String getName() {
        return name;
    }

    public String[][] getTiles() {
        return tiles;
    }

    public int getSizeX() {
        return sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }

}

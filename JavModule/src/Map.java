public class Map {

    private String name;
    private String[][] tiles;

    public Map (String name, String[][] tiles) {

        this.name = name;
        this.tiles = tiles;

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTiles(String[][] tiles) {
        this.tiles = tiles;
    }

    public String getName() {
        return name;
    }

    public String[][] getTiles() {
        return tiles;
    }
}

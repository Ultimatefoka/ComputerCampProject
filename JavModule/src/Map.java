public class Map {

    private String name;
    private Tile[][] tiles;

    public Map (String name, Tile[][] tiles) {

        this.name = name;
        this.tiles = tiles;

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTiles(Tile[][] tiles) {
        this.tiles = tiles;
    }

    public String getName() {
        return name;
    }

    public Tile[][] getTiles() {
        return tiles;
    }
}

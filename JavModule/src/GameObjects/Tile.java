package GameObjects;

public class Tile {

    private String graphic;
    private String name;
    private boolean traversable;

    public Tile(String graphic, String name, boolean traversable) {

        this.graphic = graphic;
        this.name = name;
        this.traversable = traversable;

    }

    public void setGraphik(String graphic) {
        this.graphic = graphic;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTraversable(boolean traversable) {
        this.traversable = traversable;
    }

    public String getGraphic() {
        return graphic;
    }

    public String getName() {
        return name;
    }

    public boolean isTraversable() {
        return traversable;
    }
}

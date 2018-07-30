public class Tile {

    private String graphic;
    private String name;
    private boolean traversable;

    public Tile(String graphic, String name, boolean traversable) {

        this.graphic = graphic;
        this.name = name;
        this.traversable = traversable;
        
    }

    public void setGrafik(String graphic) {
        this.graphic = graphic;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBegehbar(boolean traversable) {
        this.traversable = traversable;
    }

    public String getGrafik() {
        return graphic;
    }

    public String getName() {
        return name;
    }

    public boolean isBegehbar() {
        return traversable;
    }
}

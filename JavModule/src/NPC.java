public class NPC {

    private String graphic;
    private String name;
    private int x;
    private int y;
    private String map;
    private String behaviour;

    public NPC ( String graphic, String name, int x, int y, String map, String behaviour) {

        this.graphic = graphic;
        this.name = name;
        this.x = x;
        this.y = y;
        this.map = map;
        this.behaviour = behaviour;

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

    public void setBehaviour(String behaviour) {
        this.behaviour = behaviour;
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

    public String getBehaviour() {
        return behaviour;
    }
}

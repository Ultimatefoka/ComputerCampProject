public abstract class Item {

    private String graphic;
    private String name;
    private int x;
    private int y;

    public Item () {}

    public Item ( String graphic, String name, int x, int y){

        this.graphic = graphic;
        this.name = name;
        this.x = x;
        this.y = y;

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

}

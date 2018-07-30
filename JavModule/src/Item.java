public abstract class Item {

    protected String graphic;
    protected String name;
    protected int x;
    protected int y;

    public Item ( String graphic, String name, int x, int y, String event ){

        this.graphic = graphic;
        this.name = name;
        this.x = x;
        this.y = y;

    }

    public void setGrafik(String graphic) {
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

    public String getGrafik() {
        return graphic;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}

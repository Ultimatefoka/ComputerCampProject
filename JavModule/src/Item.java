public class Item {

    private String graphic;
    private String name;
    private int x;
    private int y;
    private String event;

    public Item ( String graphic, String name, int x, int y, String event ){

        this.graphic = graphic;
        this.name = name;
        this.x = x;
        this.y = y;
        this.event = event;

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

    public void setEvent(String event) {
        this.event = event;
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

    public String getEvent() {
        return event;
    }
}

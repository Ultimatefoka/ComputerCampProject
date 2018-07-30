public class Item {

    private String grafik;
    private String name;
    private int x;
    private int y;
    private String event;

    public Item ( String grafik, String name, int x, int y, String event ){

        this.grafik = grafik;
        this.name = name;
        this.x = x;
        this.y = y;
        this.event = event;

    }

    public void setGrafik(String grafik) {
        this.grafik = grafik;
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
        return grafik;
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

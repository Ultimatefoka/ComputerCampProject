public class Player {

    private String graphic;
    private int x;
    private int y;

    public Player(String graphic, int x, int y) {

        this.graphic = graphic;
        this.x = x;
        this.y = y;

    }

    public void setGraphic(String graphic) {
        this.graphic = graphic;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
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

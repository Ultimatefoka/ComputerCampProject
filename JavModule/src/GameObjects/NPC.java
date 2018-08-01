package GameObjects;

public abstract class NPC {

    private String graphic;
    private String name;
    private int x;
    private int y;
    private String map;

    public NPC (String graphic, String name, int x, int y, String map) {

        this.graphic = graphic;
        this.name = name;
        this.x = x;
        this.y = y;
        this.map = map;

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

    public void MoveUp(){
        y+=1;
    }

    public void MoveRight(){
        x+=1;
    }

    public void MoveLeft(){
        x-=1;
    }

    public void MoveDown(){
        y-=1;
    }

}

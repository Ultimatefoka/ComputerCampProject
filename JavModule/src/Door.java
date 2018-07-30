public class Door extends Item {

    private int goesToX;
    private int goesToY;
    private String map;

    public Door (int goesToX, int goesToY, String map) {

        this.goesToX = goesToX;
        this.goesToY = goesToY;
        this.map = map;

    }

}

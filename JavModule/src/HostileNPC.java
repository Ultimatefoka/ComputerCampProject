public class HostileNPC extends NPC {

    private int health;

    public HostileNPC (String graphic, String name, int x, int y, String map, int health) {

        super(graphic, name, x, y, map);
        this.health = health;

    }
    

}

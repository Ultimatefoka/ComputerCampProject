import java.util.ArrayList;

public class GameAssets {

    private ArrayList<Tile> tiles;
    private ArrayList<Door> doors;
    private ArrayList<Collectible> collectibles;
    private ArrayList<NPC> NPCs;
    private Player player;
    private ArrayList<Map> maps;


    public ArrayList<Door> getDoors() {
        return doors;
    }

    public ArrayList<NPC> getNPCs() {
        return NPCs;
    }

    public ArrayList<Tile> getTiles() {
        return tiles;
    }

    public ArrayList<Collectible> getCollectibles() {
        return collectibles;
    }

    public ArrayList<Map> getMaps() {
        return maps;
    }

    public void setDoors(ArrayList<Door> doors) {
        this.doors = doors;
    }

    public void setNPCs(ArrayList<NPC> NPCs) {
        this.NPCs = NPCs;
    }

    public void setTiles(ArrayList<Tile> tiles) {
        this.tiles = tiles;
    }

    public void setCollectibles(ArrayList<Collectible> collectibles) {
        this.collectibles = collectibles;
    }

    public void setMaps(ArrayList<Map> maps) {
        this.maps = maps;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Map getMap(String name){
        for(Map map:maps) {
            if (name.equals(map.getName())){
                return map;
            }
        }
        return null;
    }

    public ArrayList<Door> doorsInMap(String name){
        ArrayList<Door> doors=null;
        for(Door door:this.doors){
            if(name.equals(door.getMap())){
                doors.add(door);
            }
        }
        return doors;
    }
}

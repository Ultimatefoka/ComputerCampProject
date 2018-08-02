import GameObjects.*;

import java.util.ArrayList;

public class GameAssets {

    private ArrayList<Tile> tiles;
    private ArrayList<Door> doors;
    private ArrayList<Collectible> collectibles;
    private ArrayList<HostileNPC> hostileNPCs;
    private ArrayList<NeutralNPC> neutralNPCs;
    private Player player;
    private ArrayList<Map> maps;


    public ArrayList<Door> getDoors() {
        return doors;
    }

    public ArrayList<HostileNPC> getHostileNPCs() {
        return hostileNPCs;
    }

    public ArrayList<NeutralNPC> getNeutralNPCs() {
        return neutralNPCs;
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

    public void setHostileNPCs(ArrayList<HostileNPC> hostileNPCs) {
        this.hostileNPCs = hostileNPCs;
    }

    public void setNeutralNPCs(ArrayList<NeutralNPC> neutralNPCs) {
        this.neutralNPCs = neutralNPCs;
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
}

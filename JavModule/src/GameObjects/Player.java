package GameObjects;

import java.util.ArrayList;

public class Player {

    private ArrayList<String> sprites;
    private String mapName;
    private int x;
    private int y;
    private Facing facing;
    private int damage;
    private int damageRadius;
    private int degrees;

    public enum Facing {

        UP(0), RIGHT(1), LEFT(2), DOWN(3);

        private int n;

        Facing(int n) {

            this.n = n;
        }
    }

    public Player(ArrayList<String> sprites,String mapName, int x, int y) {

        this.sprites = sprites;
        this.mapName = mapName;
        this.x = x;
        this.y = y;
        facing = Facing.DOWN;

    }

    public ArrayList<String> getSprites() {
        return sprites;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setSprites(ArrayList<String> sprites) {
        this.sprites = sprites;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getMapName() {
        return mapName;
    }

    public void setMapName(String mapName) {
        this.mapName = mapName;
    }

    public void moveUp(){
        facing = Facing.UP;
        y-=3;
    }
    public void moveRight(){
        facing = Facing.RIGHT;
        x+=3;
    }
    public void moveLeft(){
        facing = Facing.LEFT;
        x-=3;
    }
    public void moveDown(){
        facing = Facing.DOWN;
        y+=3;
    }

    public void attack() {


    }

    public Facing getFacing() {
        return facing;
    }

    public void setFacing(Facing facing) {
        this.facing = facing;
    }

    public String getGraphic() {

        return sprites.get(facing.n);
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getDamageRadius() {
        return damageRadius;
    }

    public int getDegrees() {
        return degrees;
    }

    public void setDamageRadius(int damageRadius) {
        this.damageRadius = damageRadius;
    }

    public void setDegrees(int degrees) {
        this.degrees = degrees;
    }
}

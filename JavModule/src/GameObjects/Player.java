package GameObjects;

import java.util.ArrayList;

public class Player {

    private ArrayList<String> sprites;
    private String mapName;
    private Vector position;
    private Facing facing;
    private int damage;
    private int damageRadius;
    private int degrees;
    private Vector velocity;
    private double friction; //Would be set by each object, (0 < f < 1)
    private double acceleration; //Would be set by each object

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
        facing = Facing.DOWN;
        position = new Vector((double)x, (double)y);
        velocity = new Vector(0,0);
        acceleration = 0.2;
        friction = 0.5;

    }

    public void moveUp() {

        facing = Facing.UP;
        this.velocity = velocity.add(new Vector(0,3).scale(acceleration).substract(velocity.scale(friction)));
        this.position = position.add(velocity);

    }

    public void moveDown() {

        facing = Facing.DOWN;
        this.velocity = velocity.add(new Vector(0,-3).scale(acceleration).substract(velocity.scale(friction)));
        this.position = position.add(velocity);

    }

    public void moveRight() {

        facing = Facing.UP;
        this.velocity = velocity.add(new Vector(3,0).scale(acceleration).substract(velocity.scale(friction)));
        this.position = position.add(velocity);

    }

    public void moveLeft() {

        facing = Facing.UP;
        this.velocity = velocity.add(new Vector(-3,0).scale(acceleration).substract(velocity.scale(friction)));
        this.position = position.add(velocity);

    }

    public void setSprites(ArrayList<String> sprites) {
        this.sprites = sprites;
    }

    public ArrayList<String> getSprites() {
        return sprites;
    }

    public void setMapName(String mapName) {
        this.mapName = mapName;
    }

    public String getMapName() {
        return mapName;
    }

    public void setX(int x) {
        position.setX((double)x);
    }

    public void setY(int y) {
        position.setY((double)y);
    }

    public void setFacing(Facing facing) {
        this.facing = facing;
    }

    public void setAcceleration(double acceleration) {
        this.acceleration = acceleration;
    }

    public void setFriction(double friction) {
        this.friction = friction;
    }

    public int getX() {
        return (int)Math.round(position.getX());
    }

    public int getY() {
        return (int)Math.round(position.getY());
    }

    public Vector getVelocity() { return this.velocity; }

    public double getFriction() {
        return friction;
    }

    public double getAcceleration() {
        return acceleration;
    }

    public Facing getFacing() {
        return facing;
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

    public String getGraphic() {

        return sprites.get(facing.n);

    }
}

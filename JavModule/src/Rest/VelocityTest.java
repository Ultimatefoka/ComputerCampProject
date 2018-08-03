package Rest;

import java.util.ArrayList;

public class VelocityTest {

    private ArrayList<String> sprites;
    private String mapName;
    private Vector position;
    private Vector velocity;
    private static float friction; //Would be set by each object, (0 < f < 1)
    private static float acceleration; //Would be set by each object
    private Facing facing;
    private int damage;

    public enum Facing {

        UP(0), RIGHT(1), LEFT(2), DOWN(3);

        private int n;

        Facing(int n) {

            this.n = n;
        }
    }

    public VelocityTest(ArrayList<String> sprites,String mapName, int x, int y) {

        this.sprites = sprites;
        this.mapName = mapName;
        position.setX(x);
        position.setY(y);
        facing = Facing.DOWN;
        acceleration = 0.2f;
        friction = 0.5f;

    }

    public void moveUP() {

        facing = Facing.UP;
        position.add(velocity);
        velocity.add(new Vector(0f,1f).scale(acceleration).substract(velocity.scale(friction)));

    }

    public void moveDOWN() {

        facing = Facing.DOWN;
        position.add(velocity);
        velocity.add(new Vector(0f,-1f).scale(acceleration).substract(velocity.scale(friction)));

    }

    public void moveRIGHT() {

        facing = Facing.UP;
        position.add(velocity);
        velocity.add(new Vector(1f,0f).scale(acceleration).substract(velocity.scale(friction)));

    }

    public void moveLEFT() {

        facing = Facing.UP;
        position.add(velocity);
        velocity.add(new Vector(0f,1f).scale(acceleration).substract(velocity.scale(friction)));

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
        position.setX(x);
    }

    public void setY(int y) {
        position.setY(y);
    }

    public void setFacing(Facing facing) {
        this.facing = facing;
    }

    public static void setAcceleration(float acceleration) {
        VelocityTest.acceleration = acceleration;
    }

    public static void setFriction(float friction) {
        VelocityTest.friction = friction;
    }

    public int getX() {
        return Math.round(this.position.getX());
    }

    public int getY() {
        return Math.round(this.position.getY());
    }

    public Vector getVelocity() { return this.velocity; }

    public static float getFriction() {
        return friction;
    }

    public static float getAcceleration() {
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
}

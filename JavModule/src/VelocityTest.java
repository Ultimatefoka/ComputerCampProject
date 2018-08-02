import GameObjects.Player;

public class VelocityTest {

    private String graphic;
    private String name;
    private Vector position;
    private Vector velocity;
    private static float friction = 0.5f; //Would be set by each object, (0 < f < 1)
    private static float acceleration = 0.2f ; //Would be set by each object
    private Facing facing = Facing.DOWN;

    public enum Facing {

        UP(0), RIGHT(1), LEFT(2), DOWN(3);

        private int n;

        Facing(int n) {

            this.n = n;
        }
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

    public void setGraphic(String graphic) {
        this.graphic = graphic;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getGraphic() {return graphic; }

    public String getName() {
        return name;
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
}

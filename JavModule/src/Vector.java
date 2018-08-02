public class Vector {

    private float x;
    private float y;

    public Vector(float x, float y) {

        this.x = x;
        this.y = y;

    }

    public Vector add(Vector vector) {
        return new Vector(this.getX() + vector.getX(), this.getY() + vector.getY());
    }

    public Vector substract(Vector vector) {
        return new Vector(this.getX() - vector.getX(), this.getY() - vector.getY());
    }

    public Vector scale(float s) {
        return new Vector(this.getX() * s, this.getY() * s);
    }

    public float crossProduct(Vector vector) {
        return (this.getX() * vector.getY() - vector.getX() - this.getY());
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.x = x;
    }

    public float getX() {
        return this.x;
    }

    public float getY() {
        return y;
    }

}

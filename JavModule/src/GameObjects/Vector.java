package GameObjects;

public class Vector {

    private double x;
    private double y;

    public Vector(double x, double y) {

        this.x = x;
        this.y = y;

    }

    public Vector add(Vector vector) {
        return new Vector(this.getX() + vector.getX(), this.getY() + vector.getY());
    }

    public Vector substract(Vector vector) {
        return new Vector(this.getX() - vector.getX(), this.getY() - vector.getY());
    }

    public Vector scale(double s) {
        return new Vector(this.getX() * s, this.getY() * s);
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

}

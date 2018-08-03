package GameObjects;

import java.util.ArrayList;

public class Test {

    private static int n = 1;
    private static Player test = new Player(new ArrayList<>(), "s", 1,1);
    private static Vector alpha = new Vector(1, 10);
    private static Vector beta = new Vector(0,0);

    public static void main (String[] args) {

        for (int i = 0; i < 50; i++) {

            test.moveUp();
            System.out.println("x : " + test.getX() + " and y : " + test.getY());
            //System.out.println("xVelocity : " + test.getVelocity().getX() + " and yVelocity : " + test.getVelocity().getY());

        }

    }
}

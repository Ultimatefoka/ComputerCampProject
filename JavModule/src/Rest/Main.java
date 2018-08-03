package Rest;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Gameloop run = new Gameloop();
        new Thread(run).start();
    }
}

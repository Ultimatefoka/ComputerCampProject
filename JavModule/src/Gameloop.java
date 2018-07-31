import Rendering.GameFrame;

import java.io.IOException;
import java.util.ArrayList;

public class Gameloop implements Runnable {

    private boolean running = true;
    private GameFrame gameframe;

    public Gameloop() {
        gameframe = new GameFrame("CoolesSpiel", 64 * 12, (64 * 8) + 20);
    }

    @Override
    public void run() {
        gameframe.setVisible(true);
        while (running) {
            try {
                GameManager.getInstance().createMap(Data.getGameAssetsInstance().getPlayer().getMapName());
                GameManager.getInstance().update();
                render(Data.getGameAssetsInstance().getPlayer().getMapName());
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {

                Thread.sleep(40);
            } catch (Exception ex) {
            }
            running=false;
        }
    }

    public void render(String map) throws IOException {
        gameframe.clearMapImages();
        gameframe.clearImages();
        for (int x = 0; x < 16; x++) {
            for (int y = 0; y < 9; y++) {
                int playerX = Data.getGameAssetsInstance().getPlayer().getX();
                int playerY = Data.getGameAssetsInstance().getPlayer().getY();
                int tileX = Data.getGameAssetsInstance().getPlayer().getX() - 8 + x;
                int tileY = Data.getGameAssetsInstance().getPlayer().getY() - 8 + y;
                if (tileX < 0 || tileY < 0 || tileX > 8 || tileY > 2) {
                    System.out.println(y);
                    gameframe.addImage(GameManager.getInstance().getBI("black"), x * 32, y * 32);
                } else {
                    System.out.println(y);
                    System.out.println(GameManager.getInstance().getCurrentMap()[tileY][tileX].getGraphic());
                    gameframe.addMapImage(GameManager.getInstance().getBI(GameManager.getInstance().getCurrentMap()[tileY][tileX].getGraphic()), x * 32, y * 32);
                }
            }
        }
        ArrayList<Door> doors = GameManager.getInstance().doorsInMap(map);
        for (Door door : doors) {
            gameframe.addImage(GameManager.getInstance().getBI(door.getGraphic()), door.getX() * 32, door.getY() * 32);
            System.out.println(door.getX());
        }
        gameframe.addImage(GameManager.getInstance().getBI(Data.getGameAssetsInstance().getPlayer().getGraphic()), 8 * 32, 4 * 32);
        gameframe.repaint();
    }

}

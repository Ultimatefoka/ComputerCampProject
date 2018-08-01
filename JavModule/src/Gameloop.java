import Rendering.GameFrame;

import java.io.IOException;
import java.util.ArrayList;

public class Gameloop implements Runnable {

    private boolean running = true;
    private GameFrame gameframe;

    public Gameloop() throws IOException {
        gameframe = new GameFrame("CoolesSpiel", 64 * 12, (64 * 8) + 20);
        GameManager.getInstance().initInputManager(gameframe);
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
        }
    }

    public void render(String map) throws IOException {
        gameframe.clearMapImages();
        gameframe.clearImages();
        ArrayList<Door> doors = GameManager.getInstance().doorsInMap(map);
        for (int mapX = 0; mapX < 16; mapX++) {
            for (int mapY = 0; mapY < 9; mapY++) {
                int playerX = Data.getGameAssetsInstance().getPlayer().getX();
                int playerY = Data.getGameAssetsInstance().getPlayer().getY();
                int tileX = playerX-8+mapX;
                int tileY = playerY-4+mapY;
                if (tileX < 0 || tileY < 0 || tileX > 8 || tileY > 2) {
                    gameframe.addImage(GameManager.getInstance().getBI("black"), mapX * 32, mapY * 32);
                } else {
                    gameframe.addMapImage(GameManager.getInstance().getBI(GameManager.getInstance().getCurrentMap()[tileY][tileX].getGraphic()), mapX * 32, mapY * 32);
                    for (Door door : doors) {
                        if(door.getX()==tileX&&door.getY()==tileY) {
                            gameframe.addImage(GameManager.getInstance().getBI(door.getGraphic()), tileX * 32, tileY * 32);
                        }
                    }
                }
            }
        }
        gameframe.addImage(GameManager.getInstance().getBI(Data.getGameAssetsInstance().getPlayer().getGraphic()), 8 * 32, 4 * 32);
        gameframe.repaint();
    }

}

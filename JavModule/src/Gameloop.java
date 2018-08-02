import GameObjects.Door;
import Rendering.GameFrame;

import java.io.IOException;
import java.util.ArrayList;

public class Gameloop implements Runnable {

    private boolean running = true;
    private GameFrame gameframe;
    private int tileSize=32;

    public Gameloop() throws IOException {
        gameframe = new GameFrame("CoolesSpiel", tileSize * 16, (tileSize * 9) + 35);
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
        for (int locPosOnFramX = 0; locPosOnFramX < 16; locPosOnFramX++) {
            for (int locPosOnFramY = 0; locPosOnFramY < 9; locPosOnFramY++) {
                int gPlayerX = Data.getGameAssetsInstance().getPlayer().getX();
                int gPlayerY = Data.getGameAssetsInstance().getPlayer().getY();
                int gTileInMapX = gPlayerX-8+locPosOnFramX;
                int gTileInMapY = gPlayerY-4+locPosOnFramY;
                int sizeX = GameManager.getInstance().getCurrentMap()[1].length-1;
                int sizeY = GameManager.getInstance().getCurrentMap().length-1;
                if (gTileInMapX < 0 || gTileInMapY < 0 || gTileInMapX > sizeX || gTileInMapY > sizeY) {
                    gameframe.addImage(GameManager.getInstance().getBI("black"), locPosOnFramX * tileSize, locPosOnFramY * tileSize);
                } else {
                    gameframe.addMapImage(GameManager.getInstance().getBI(GameManager.getInstance().getCurrentMap()[gTileInMapY][gTileInMapX].getGraphic()), locPosOnFramX * tileSize, locPosOnFramY * tileSize);
                    for (Door door : doors) {
                        if(door.getX()==gTileInMapX && door.getY()==gTileInMapY) {
                            gameframe.addImage(GameManager.getInstance().getBI(door.getGraphic()), locPosOnFramX * tileSize, locPosOnFramY * tileSize);
                        }
                    }
                }
            }
        }
        gameframe.addImage(GameManager.getInstance().getBI(Data.getGameAssetsInstance().getPlayer().getGraphic()), 8 * tileSize, 4 * tileSize);
        gameframe.repaint();
    }
}

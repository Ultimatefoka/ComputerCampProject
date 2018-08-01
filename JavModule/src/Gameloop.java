import GameObjects.Door;
import Rendering.GameFrame;

import java.io.IOException;
import java.util.ArrayList;

public class Gameloop implements Runnable {

    private boolean running = true;
    private GameFrame gameframe;

    public Gameloop() throws IOException {
        gameframe = new GameFrame("CoolesSpiel", 32 * 16, (32 * 9) + 35);
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
                if (gTileInMapX < 0 || gTileInMapY < 0 || gTileInMapX > 8 || gTileInMapY > 9) {
                    gameframe.addImage(GameManager.getInstance().getBI("black"), locPosOnFramX * 32, locPosOnFramY * 32);
                } else {
                    gameframe.addMapImage(GameManager.getInstance().getBI(GameManager.getInstance().getCurrentMap()[gTileInMapY][gTileInMapX].getGraphic()), locPosOnFramX * 32, locPosOnFramY * 32);
                    for (Door door : doors) {
                        if(door.getX()==gTileInMapX && door.getY()==gTileInMapY) {
                            gameframe.addImage(GameManager.getInstance().getBI(door.getGraphic()), locPosOnFramX * 32, locPosOnFramY * 32);
                        }
                    }
                }
            }
        }
        gameframe.addImage(GameManager.getInstance().getBI(Data.getGameAssetsInstance().getPlayer().getGraphic()), 8 * 32, 4 * 32);
        gameframe.repaint();
    }

}

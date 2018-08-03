package Rest;

import GameObjects.Door;
import GameObjects.HostileNPC;
import GameObjects.NeutralNPC;
import Rendering.GameFrame;

import java.io.IOException;
import java.util.ArrayList;

public class Gameloop implements Runnable {

    private boolean running = true;
    private GameFrame gameframe;

    public Gameloop() throws IOException {
        gameframe = new GameFrame("CoolesSpiel", GameManager.getInstance().getTileSize() * 17, (GameManager.getInstance().getTileSize() * 10) + 35);
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

    /* old version
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
                    gameframe.addImage(GameManager.getInstance().getBI("black"), locPosOnFramX * GameManager.getInstance().getTileSize(), locPosOnFramY * GameManager.getInstance().getTileSize());
                } else {
                    gameframe.addMapImage(GameManager.getInstance().getBI(GameManager.getInstance().getCurrentMap()[gTileInMapY][gTileInMapX].getGraphic()), locPosOnFramX * GameManager.getInstance().getTileSize(), locPosOnFramY * GameManager.getInstance().getTileSize());
                    for (Door door : doors) {
                        if(door.getX()==gTileInMapX && door.getY()==gTileInMapY) {
                            gameframe.addImage(GameManager.getInstance().getBI(door.getGraphic()), locPosOnFramX * GameManager.getInstance().getTileSize(), locPosOnFramY * GameManager.getInstance().getTileSize());
                        }
                    }
                }
            }
        }
        gameframe.addImage(GameManager.getInstance().getBI(Data.getGameAssetsInstance().getPlayer().getGraphic()), 8 * GameManager.getInstance().getTileSize(), 4 * GameManager.getInstance().getTileSize());
        gameframe.repaint();
    }*/

    public void render(String map) throws IOException {
        gameframe.clearMapImages();
        gameframe.clearImages();
        int tileSize = GameManager.getInstance().getTileSize();
        int sizeX = GameManager.getInstance().getCurrentMap()[1].length - 1;
        int sizeY = GameManager.getInstance().getCurrentMap().length - 1;
        ArrayList<Door> doors = GameManager.getInstance().doorsInMap(map);
        ArrayList<HostileNPC> hnpcs = GameManager.getInstance().hNPCsInMap(map);
        ArrayList<NeutralNPC> nnpcs = GameManager.getInstance().nNPCsInMap(map);
        int playerX = Data.getGameAssetsInstance().getPlayer().getX();
        int playerY = Data.getGameAssetsInstance().getPlayer().getY();
        int startValueX = -(playerX % GameManager.getInstance().getTileSize());
        int startValueY = -(playerY % GameManager.getInstance().getTileSize());
        int locTileInMapX;
        int locTileInMapY;
        int locPxX0=8*tileSize-playerX;
        int locPxY0=4*tileSize-playerY;
        for (int locPxPosOnFrameX = startValueX; locPxPosOnFrameX < 17 * tileSize; locPxPosOnFrameX += tileSize) {
            for (int locPxPosOnFrameY = startValueY; locPxPosOnFrameY < 10 * tileSize; locPxPosOnFrameY += tileSize) {
                locTileInMapX = (int) (playerX / tileSize) - 7 + (int) (((locPxPosOnFrameX + tileSize) / tileSize) - 1);
                if (startValueX == 0) {
                    locTileInMapX -= 1;
                }
                locTileInMapY = (int) (playerY / tileSize) - 3 + (int) (((locPxPosOnFrameY + tileSize) / tileSize) - 1);
                if (startValueY == 0) {
                    locTileInMapY -= 1;
                }
                if(locTileInMapX==0&&locTileInMapY==0){
                    locPxX0=locPxPosOnFrameX;
                    locPxY0=locPxPosOnFrameY;
                }
                int locPxInMapX = playerX - 7 * tileSize + locPxPosOnFrameX;
                int locPxInMapY = playerY - 3 * tileSize + locPxPosOnFrameY;
                //render Map
                if (locTileInMapX < 0 || locTileInMapY < 0 || locTileInMapX > sizeX || locTileInMapY > sizeY) {
                    gameframe.addImage(GameManager.getInstance().getBI("black"), locPxPosOnFrameX, locPxPosOnFrameY);
                } else {
                    gameframe.addMapImage(GameManager.getInstance().getBI(GameManager.getInstance().getCurrentMap()[locTileInMapY][locTileInMapX].getGraphic()), locPxPosOnFrameX, locPxPosOnFrameY);
                    //render Doors
                    for (Door door : doors) {
                        if (door.getX() == locTileInMapX && door.getY() == locTileInMapY) {
                            gameframe.addImage(GameManager.getInstance().getBI(door.getGraphic()), locPxPosOnFrameX, locPxPosOnFrameY);
                        }
                    }
                }
            }
        }
        //render NPCs
        for (HostileNPC npc : hnpcs) {
            gameframe.addImage(GameManager.getInstance().getBI(npc.getGraphic()), locPxX0+npc.getX(), locPxY0+npc.getY());
        }
        for (NeutralNPC npc : nnpcs) {
            gameframe.addImage(GameManager.getInstance().getBI(npc.getGraphic()), locPxX0+npc.getX(), locPxY0+npc.getY());
        }
        //render Player
        gameframe.addImage(GameManager.getInstance().getBI(Data.getGameAssetsInstance().getPlayer().getGraphic()), 8 *tileSize, 4 * tileSize);
        gameframe.repaint();
    }
}

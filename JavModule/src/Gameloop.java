import Rendering.GameFrame;

import java.io.IOException;
import java.util.ArrayList;

public class Gameloop implements Runnable{

    private boolean running=true;
    private GameFrame gameframe;
    public Gameloop() {
        gameframe = new GameFrame("CoolesSpiel", 64 * 12, (64 * 8) + 20);
    }
    @Override
    public void run(){
        gameframe.setVisible(true);
        while(running){
            try {
                GameManager.getInstance().update();
                render("map1");
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
        for(int x=GameManager.getInstance().getGameAssets().getPlayer().getY()-8;x<GameManager.getInstance().getGameAssets().getPlayer().getX()+8;x++){
            for(int y=GameManager.getInstance().getGameAssets().getPlayer().getY()-8;y<GameManager.getInstance().getGameAssets().getPlayer().getY()+8;y++){
                if(x<0||y<0){
                    gameframe.addImage(GameManager.getInstance().getBI("black"),x,y);
                }else{
                   gameframe.addMapImage(GameManager.getInstance().getBI(GameManager.getInstance().getGameAssets().getMap(map).getTiles()[x][y].getGrafik()),x,y);
                }
            }
        }
        ArrayList<Door> doors=GameManager.getInstance().getGameAssets().doorsInMap(map);
        for(Door door:doors){
            gameframe.addImage(GameManager.getInstance().getBI(door.getGraphic()),door.getX(),door.getY());
        }

        gameframe.addImage(GameManager.getInstance().getBI(GameManager.getInstance().getGameAssets().getPlayer().getGraphic()),GameManager.getInstance().getGameAssets().getPlayer().getX(),GameManager.getInstance().getGameAssets().getPlayer().getY());
        gameframe.clearImages();
        gameframe.repaint();
    }

}

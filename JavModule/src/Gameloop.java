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
        for(int x=0;x<16;x++){
            for(int y=0;y<9;y++){
                if(Data.getGameAssetsInstance().getPlayer().getX()-8-x<0||Data.getGameAssetsInstance().getPlayer().getY()-8-y<0){
                    gameframe.addImage(GameManager.getInstance().getBI("black"),x*32,y*32);
                }else{
                   gameframe.addMapImage(GameManager.getInstance().getBI(GameManager.getInstance().getCurrentMap()[Data.getGameAssetsInstance().getPlayer().getX()-8-x][Data.getGameAssetsInstance().getPlayer().getY()-8-y].getGraphic()),x*32,y*32);
                }
            }
        }
        ArrayList<Door> doors=GameManager.getInstance().doorsInMap(map);
        for(Door door:doors){
            gameframe.addImage(GameManager.getInstance().getBI(door.getGraphic()),door.getX()*32,door.getY()*32);
        }

        gameframe.addImage(GameManager.getInstance().getBI(Data.getGameAssetsInstance().getPlayer().getGraphic()),8*32,4*32);
        gameframe.clearImages();
        gameframe.repaint();
    }

}

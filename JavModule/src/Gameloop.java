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
            } catch (IOException e) {
                e.printStackTrace();
            }
            render("map1");
            try {

                Thread.sleep(40);
            } catch (Exception ex) {
            }
        }
    }
    public void render(String map){
        gameframe.clearMapImages();
        for(int x=GameAssets.getInstance().getPlayer().getY()-8;x<GameAssets.getInstance().getPlayer().getX()+8;x++){
            for(int y=GameAssets.getInstance().getPlayer().getY()-8;y<GameAssets.getInstance().getPlayer().getY()+8;y++){
                if(x<0||y<0){
                    //gameframe.clearMapImages(GameManager.getInstance().getBI("black"),x,y);
                }else{
                   // gameframe.addMapImages(GameAssets.getInstance().getMap(map).getTiles()[x][y].getGrafik(),x,y);
                }
            }
        }
        ArrayList<Door> doors=GameAssets.getInstance().doorsInMap(map);
        for(Door door:doors){
            //gameframe.addImage(door.getGraphic(),door.getX(),door.getY());
        }

        //gameframe.addImage(GameAssets.getInstance().getPlayer().getGraphic(),GameAssets.getInstance().getPlayer().getX(),GameAssets.getInstance().getPlayer().getY());
        gameframe.clearImages();
        gameframe.repaint();
    }

}

import Rendering.GameFrame;

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
            GameManager.getInstance().update();
            render();
            try {

                Thread.sleep(40);
            } catch (Exception ex) {
            }
        }
    }
    public void render(){
        gameframe.clearMapImages();
        for(int x=GameAssets.getInstance().getPlayer().getY()-8;x<GameAssets.getInstance().getPlayer().getX()+8;x++){
            for(int y=GameAssets.getInstance().getPlayer().getY()-8;y<GameAssets.getInstance().getPlayer().getY()+8;y++){
                if(x<0||y<0){

                }else{
                   // gameframe.addImage(GameAssets.getInstance().getMap("map1").getTiles()[x][y].getGrafik(),x,y);
                }
            }
        }
        gameframe.clearImages();
        gameframe.repaint();
    }

}

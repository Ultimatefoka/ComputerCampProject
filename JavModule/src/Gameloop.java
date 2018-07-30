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
        gameframe.clearImages();
        gameframe.repaint();
    }

}

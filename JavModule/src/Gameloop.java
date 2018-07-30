public class Gameloop {
    private boolean running=true;
    public void run(){
        while(running){

            try {
                Thread.sleep(40);
            } catch (Exception ex) {

            }
        }
    }
}

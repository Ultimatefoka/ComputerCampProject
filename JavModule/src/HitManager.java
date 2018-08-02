import GameObjects.Player;

public class HitManager {

    private static HitManager hitManagerInstance;
    private int hostileNPCHit;

    public static HitManager getHitManagerInstance() {

        if(hitManagerInstance == null) {

            hitManagerInstance = new HitManager();
        }

        return hitManagerInstance;
    }

    public boolean hitsHostileNPC() {

        for(int i = 0; i < Data.getGameAssetsInstance().getHostileNPCs().size(); i++) {

            switch(Data.getGameAssetsInstance().getPlayer().getFacing()) {

                case DOWN:
                    if(Data.getGameAssetsInstance().getPlayer().getY()+1 == Data.getGameAssetsInstance().getHostileNPCs().get(i).getY() && Data.getGameAssetsInstance().getPlayer().getX() == Data.getGameAssetsInstance().getHostileNPCs().get(i).getX()) {
                        hostileNPCHit = i;
                        return true;
                    }

                case UP:
                    if(Data.getGameAssetsInstance().getPlayer().getY()-1 == Data.getGameAssetsInstance().getHostileNPCs().get(i).getY() && Data.getGameAssetsInstance().getPlayer().getX() == Data.getGameAssetsInstance().getHostileNPCs().get(i).getX()) {
                        hostileNPCHit = i;
                        return true;
                    }

                case LEFT:
                    if(Data.getGameAssetsInstance().getPlayer().getY() == Data.getGameAssetsInstance().getHostileNPCs().get(i).getY() && Data.getGameAssetsInstance().getPlayer().getX()-1 == Data.getGameAssetsInstance().getHostileNPCs().get(i).getX()) {
                        hostileNPCHit = i;
                        return true;
                    }

                case RIGHT:
                    if(Data.getGameAssetsInstance().getPlayer().getY() == Data.getGameAssetsInstance().getHostileNPCs().get(i).getY() && Data.getGameAssetsInstance().getPlayer().getX()+1 == Data.getGameAssetsInstance().getHostileNPCs().get(i).getX()) {
                        hostileNPCHit = i;
                        return true;
                    }
            }
        }

        /*for(int i = 0; i < Data.getGameAssetsInstance().getHostileNPCs().size(); i++) {

            switch(Data.getGameAssetsInstance().getPlayer().getFacing()) {

                case DOWN:
                    int posY = Data.getGameAssetsInstance().getPlayer().getY();
                    int posX = Data.getGameAssetsInstance().getPlayer().getX();
                    int r = 80;

            }
        }*/
        return false;
    }

    public int getHostileNPCHit() {
        return hostileNPCHit;
    }

    public void setHostileNPCHit(int hostileNPCHit) {
        this.hostileNPCHit = hostileNPCHit;
    }
}

package Rest;

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

            double radius = Math.sqrt((Math.abs(Data.getGameAssetsInstance().getHostileNPCs().get(i).getY() - Data.getGameAssetsInstance().getPlayer().getY())) + (Math.abs(Data.getGameAssetsInstance().getHostileNPCs().get(i).getY() - Data.getGameAssetsInstance().getPlayer().getY())));
            double width = Math.abs((Data.getGameAssetsInstance().getHostileNPCs().get(i).getX() - Data.getGameAssetsInstance().getPlayer().getX())) * 2;

            switch(Data.getGameAssetsInstance().getPlayer().getFacing()) {

                case DOWN:
                    if(Data.getGameAssetsInstance().getHostileNPCs().get(i).getY() - Data.getGameAssetsInstance().getPlayer().getY() > 0 && radius <= Data.getGameAssetsInstance().getPlayer().getDamageRadius() && width <= Data.getGameAssetsInstance().getPlayer().getDamageWidth()) {

                        hostileNPCHit = i;
                        return true;
                    }
                case RIGHT:
                    if(Data.getGameAssetsInstance().getHostileNPCs().get(i).getX() - Data.getGameAssetsInstance().getPlayer().getX() > 0 && radius <= Data.getGameAssetsInstance().getPlayer().getDamageRadius() && width <= Data.getGameAssetsInstance().getPlayer().getDamageWidth()) {

                        hostileNPCHit = i;
                        return true;
                    }
                case LEFT:
                    if(Data.getGameAssetsInstance().getHostileNPCs().get(i).getX() - Data.getGameAssetsInstance().getPlayer().getX() < 0 && radius <= Data.getGameAssetsInstance().getPlayer().getDamageRadius() && width <= Data.getGameAssetsInstance().getPlayer().getDamageWidth()) {

                        hostileNPCHit = i;
                        return true;
                    }
                case UP:
                    if(Data.getGameAssetsInstance().getHostileNPCs().get(i).getY() - Data.getGameAssetsInstance().getPlayer().getY() < 0 && radius <= Data.getGameAssetsInstance().getPlayer().getDamageRadius() && width <= Data.getGameAssetsInstance().getPlayer().getDamageWidth()) {

                        hostileNPCHit = i;
                        return true;
                    }
                default:
                    break;
            }
        }
        return false;
    }

    public int getHostileNPCHit() {
        return hostileNPCHit;
    }

    public void setHostileNPCHit(int hostileNPCHit) {
        this.hostileNPCHit = hostileNPCHit;
    }
}

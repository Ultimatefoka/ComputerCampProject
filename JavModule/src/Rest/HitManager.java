package Rest;

import java.util.ArrayList;

public class HitManager {

    private static HitManager hitManagerInstance;
    private ArrayList<Integer> hostileNPCsHit;

    public static HitManager getHitManagerInstance() {

        if(hitManagerInstance == null) {

            hitManagerInstance = new HitManager();
        }

        return hitManagerInstance;
    }

    public boolean hitsHostileNPC() {

        hostileNPCsHit = new ArrayList<>();

        for(int i = 0; i < Data.getGameAssetsInstance().getHostileNPCs().size(); i++) {

            double radius = Math.sqrt(((Math.abs(Data.getGameAssetsInstance().getHostileNPCs().get(i).getY() - Data.getGameAssetsInstance().getPlayer().getY())) + (Math.abs(Data.getGameAssetsInstance().getHostileNPCs().get(i).getX() - Data.getGameAssetsInstance().getPlayer().getX()))));
            double tan = Math.atan(Math.abs(Data.getGameAssetsInstance().getPlayer().getX() - Data.getGameAssetsInstance().getHostileNPCs().get(i).getX()) / Math.abs(Data.getGameAssetsInstance().getPlayer().getX() - Data.getGameAssetsInstance().getHostileNPCs().get(i).getX()));

            switch(Data.getGameAssetsInstance().getPlayer().getFacing()) {

                case DOWN:
                    if(Data.getGameAssetsInstance().getHostileNPCs().get(i).getY() - Data.getGameAssetsInstance().getPlayer().getY() > 0 && radius <= Data.getGameAssetsInstance().getPlayer().getDamageRadius() && Data.getGameAssetsInstance().getPlayer().getMapName().equals(Data.getGameAssetsInstance().getHostileNPCs().get(i).getMap()) && Data.getGameAssetsInstance().getPlayer().getDegrees() > tan) {

                        hostileNPCsHit.add(i);
                    break;
            }
                case RIGHT:
                    if(Data.getGameAssetsInstance().getHostileNPCs().get(i).getX() - Data.getGameAssetsInstance().getPlayer().getX() > 0 && radius <= Data.getGameAssetsInstance().getPlayer().getDamageRadius() && Data.getGameAssetsInstance().getPlayer().getMapName().equals(Data.getGameAssetsInstance().getHostileNPCs().get(i).getMap()) && Data.getGameAssetsInstance().getPlayer().getDegrees() > tan) {

                        hostileNPCsHit.add(i);
                    }
                    break;
                case LEFT:
                    if(Data.getGameAssetsInstance().getHostileNPCs().get(i).getX() - Data.getGameAssetsInstance().getPlayer().getX() < 0 && radius <= Data.getGameAssetsInstance().getPlayer().getDamageRadius() && Data.getGameAssetsInstance().getPlayer().getMapName().equals(Data.getGameAssetsInstance().getHostileNPCs().get(i).getMap()) && Data.getGameAssetsInstance().getPlayer().getDegrees() > tan) {

                        hostileNPCsHit.add(i);
                    }
                    break;
                case UP:
                    if(Data.getGameAssetsInstance().getHostileNPCs().get(i).getY() - Data.getGameAssetsInstance().getPlayer().getY() < 0 && radius <= Data.getGameAssetsInstance().getPlayer().getDamageRadius() && Data.getGameAssetsInstance().getPlayer().getMapName().equals(Data.getGameAssetsInstance().getHostileNPCs().get(i).getMap()) && Data.getGameAssetsInstance().getPlayer().getDegrees() > tan) {

                        hostileNPCsHit.add(i);
                    }
                    break;
                default:
                    break;
            }
        }

        if(hostileNPCsHit.size() > 0) {
            return true;
        }

        return false;
    }

    public ArrayList<Integer> getHostileNPCsHit() {
        return hostileNPCsHit;
    }

    public void setHostileNPCsHit(ArrayList<Integer> hostileNPCsHit) {
        this.hostileNPCsHit = hostileNPCsHit;
    }
}

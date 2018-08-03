package Images;


import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Images {
    private BufferedImage boden_grass = ImageIO.read(Images.class.getResourceAsStream("/Images/boden_grass.png"));
    private BufferedImage boden_erde = ImageIO.read(Images.class.getResourceAsStream("/Images/boden_erde.png"));
    private BufferedImage boden_erde_grasskanteru = ImageIO.read(Images.class.getResourceAsStream("/Images/boden_erde_grasskanteru.png"));
    private BufferedImage boden_erde_grasseckeru = ImageIO.read(Images.class.getResourceAsStream("/Images/boden_erde_grasseckeru.png"));
    private BufferedImage boden_erde_grasseckelu = ImageIO.read(Images.class.getResourceAsStream("/Images/boden_erde_grasseckelu.png"));
    private BufferedImage boden_erde_grasseckero = ImageIO.read(Images.class.getResourceAsStream("/Images/boden_erde_grasseckero.png"));
    private BufferedImage boden_erde_grasseckelo = ImageIO.read(Images.class.getResourceAsStream("/Images/boden_erde_grasseckelo.png"));
    private BufferedImage boden_erde_grasskanteu = ImageIO.read(Images.class.getResourceAsStream("/Images/boden_erde_grasskanteu.png"));
    private BufferedImage boden_erde_grasskantel = ImageIO.read(Images.class.getResourceAsStream("/Images/boden_erde_grasskantel.png"));
    private BufferedImage boden_erde_grasskantelu = ImageIO.read(Images.class.getResourceAsStream("/Images/boden_erde_grasskantelu.png"));
    private BufferedImage boden_erde_grasskantelo = ImageIO.read(Images.class.getResourceAsStream("/Images/boden_erde_grasskantelo.png"));
    private BufferedImage boden_erde_grasskanteo = ImageIO.read(Images.class.getResourceAsStream("/Images/boden_erde_grasskanteo.png"));
    private BufferedImage boden_erde_grasskanter = ImageIO.read(Images.class.getResourceAsStream("/Images/boden_erde_grasskanter.png"));
    private BufferedImage boden_erde_grasskantero = ImageIO.read(Images.class.getResourceAsStream("/Images/boden_erde_grasskantero.png"));
    private BufferedImage boden_grauekachel = ImageIO.read(Images.class.getResourceAsStream("/Images/boden_grauekachel.png"));
    private BufferedImage boden_grauekachel2 = ImageIO.read(Images.class.getResourceAsStream("/Images/boden_grauekachel2.png"));
    private BufferedImage boden_grauekachel3 = ImageIO.read(Images.class.getResourceAsStream("/Images/boden_grauekachel3.png"));
    private BufferedImage boden_grauekachel4 = ImageIO.read(Images.class.getResourceAsStream("/Images/boden_grauekachel4.png"));
    private BufferedImage boden_grauekachel5 = ImageIO.read(Images.class.getResourceAsStream("/Images/boden_grauekachel5.png"));
    private BufferedImage boden_grauekachel_grasseckelo = ImageIO.read(Images.class.getResourceAsStream("/Images/boden_grauekachel_grasseckelo.png"));
    private BufferedImage boden_grauekachel_grasseckelu = ImageIO.read(Images.class.getResourceAsStream("/Images/boden_grauekachel_grasseckelu.png"));
    private BufferedImage boden_grauekachel_grasseckero = ImageIO.read(Images.class.getResourceAsStream("/Images/boden_grauekachel_grasseckero.png"));
    private BufferedImage boden_grauekachel_grasseckeru = ImageIO.read(Images.class.getResourceAsStream("/Images/boden_grauekachel_grasseckeru.png"));
    private BufferedImage boden_grauekachel_grasskantel = ImageIO.read(Images.class.getResourceAsStream("/Images/boden_grauekachel_grasskantel.png"));
    private BufferedImage boden_grauekachel_grasskantelo = ImageIO.read(Images.class.getResourceAsStream("/Images/boden_grauekachel_grasskantelo.png"));
    private BufferedImage boden_grauekachel_grasskantelu = ImageIO.read(Images.class.getResourceAsStream("/Images/boden_grauekachel_grasskantelu.png"));
    private BufferedImage boden_grauekachel_grasskanteo = ImageIO.read(Images.class.getResourceAsStream("/Images/boden_grauekachel_grasskanteo.png"));
    private BufferedImage boden_grauekachel_grasskanter = ImageIO.read(Images.class.getResourceAsStream("/Images/boden_grauekachel_grasskanter.png"));
    private BufferedImage boden_grauekachel_grasskantero = ImageIO.read(Images.class.getResourceAsStream("/Images/boden_grauekachel_grasskantero.png"));
    private BufferedImage boden_grauekachel_grasskanteru = ImageIO.read(Images.class.getResourceAsStream("/Images/boden_grauekachel_grasskanteru.png"));
    private BufferedImage boden_grauekachel_grasskanteu = ImageIO.read(Images.class.getResourceAsStream("/Images/boden_grauekachel_grasskanteu.png"));
    private BufferedImage wand_graueziegel = ImageIO.read(Images.class.getResourceAsStream("/Images/wand_graueziegel.png"));
    private BufferedImage wand_stein = ImageIO.read(Images.class.getResourceAsStream("/Images/wand_stein.png"));
    private BufferedImage player_vorne = ImageIO.read(Images.class.getResourceAsStream("/Images/player_vorne.png"));
    private BufferedImage player_vorne_schlagen = ImageIO.read(Images.class.getResourceAsStream("/Images/player_vorne_schlagen.png"));
    private BufferedImage player_hinten = ImageIO.read(Images.class.getResourceAsStream("/Images/player_hinten.png"));
    private BufferedImage player_links = ImageIO.read(Images.class.getResourceAsStream("/Images/player_links.png"));
    private BufferedImage player_rechts = ImageIO.read(Images.class.getResourceAsStream("/Images/player_rechts.png"));
    private BufferedImage black = ImageIO.read(Images.class.getResourceAsStream("/Images/black.png"));
    private BufferedImage door_door = ImageIO.read(Images.class.getResourceAsStream("/Images/door_door.png"));
    private BufferedImage door_leiter = ImageIO.read(Images.class.getResourceAsStream("/Images/door_leiter.png"));
    private BufferedImage door_stein = ImageIO.read(Images.class.getResourceAsStream("/Images/door_stein.png"));
    private BufferedImage door_dungeon1 = ImageIO.read(Images.class.getResourceAsStream("/Images/door_dungeon1.png"));
    private BufferedImage hostile_NPC = ImageIO.read(Images.class.getResourceAsStream("/Images/hostile_NPC.png"));
    private BufferedImage neutral_NPC = ImageIO.read(Images.class.getResourceAsStream("/Images/neutral_NPC.png"));
    private static Images images;

    public Images() throws IOException {
    }
    public static Images getInstance() throws IOException {
        if(images==null){
            return images = new Images();
        }else{
            return images;
        }
    }
    public BufferedImage getBI(String graphic){
        switch (graphic) {
            case "wand_graueziegel":
                return wand_graueziegel;
            case "wand_stein":
                return wand_stein;
            case "boden_grauekachel":
                return boden_grauekachel;
            case "boden_grauekachel2":
                return boden_grauekachel2;
            case "boden_grauekachel3":
                return boden_grauekachel3;
            case "boden_grauekachel4":
                return boden_grauekachel4;
            case "boden_grauekachel5":
                return boden_grauekachel5;
            case "boden_grauekachel_grasseckelo":
                return boden_grauekachel_grasseckelo;
            case "boden_grauekachel_grasseckero":
                return boden_grauekachel_grasseckero;
            case "boden_grauekachel_grasseckelu":
                return boden_grauekachel_grasseckelu;
            case "boden_grauekachel_grasseckeru":
                return boden_grauekachel_grasseckeru;
            case "boden_grauekachel_grasskantelo":
                return boden_grauekachel_grasskantelo;
            case "boden_grauekachel_grasskantelu":
                return boden_grauekachel_grasskantelu;
            case "boden_grauekachel_grasskantero":
                return boden_grauekachel_grasskantero;
            case "boden_grauekachel_grasskanteru":
                return boden_grauekachel_grasskanteru;
            case "boden_grauekachel_grasskantel":
                return boden_grauekachel_grasskantel;
            case "boden_grauekachel_grasskanter":
                return boden_grauekachel_grasskanter;
            case "boden_grauekachel_grasskanteo":
                return boden_grauekachel_grasskanteo;
            case "boden_grauekachel_grasskanteu":
                return boden_grauekachel_grasskanteu;
            case "boden_grass":
                return boden_grass;
            case "boden_erde_grasskanteru":
                return boden_erde_grasskanteru;
            case "boden_erde_grasskanteu":
                return boden_erde_grasskanteu;
            case "boden_erde_grasskantel":
                return boden_erde_grasskantel;
            case "boden_erde_grasskantelo":
                return boden_erde_grasskantelo;
            case "boden_erde_grasskantelu":
                return boden_erde_grasskantelu;
            case "boden_erde_grasskanteo":
                return boden_erde_grasskanteo;
            case "boden_erde_grasskanter":
                return boden_erde_grasskanter;
            case "boden_erde_grasskantero":
                return boden_erde_grasskantero;
            case "boden_erde_grasseckelo":
                return boden_erde_grasseckelo;
            case "boden_erde_grasseckelu":
                return boden_erde_grasseckelu;
            case "boden_erde_grasseckeru":
                return boden_erde_grasseckeru;
            case "boden_erde_grasseckero":
                return boden_erde_grasseckero;
            case "boden_erde":
                return boden_erde;
            case "player_vorne":
                return player_vorne;

            case "player_vorne_schlagen":
                return player_vorne_schlagen;
            case "player_hinten":
                return player_hinten;
            case "player_links":
                return player_links;
            case "player_rechts":
                return player_rechts;
            case "hostile_NPC":
                return hostile_NPC;
            case "neutral_NPC":
                return neutral_NPC;
            case "door_door":
                return door_door;
            case "door_leiter":
                return door_leiter;
            case "door_stein":
                return door_stein;
            case "door_dungeon1":
                return door_dungeon1;
            default:
                return black;
        }
    }
}

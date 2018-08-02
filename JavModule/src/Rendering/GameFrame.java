package Rendering;

import java.awt.image.BufferedImage;
import java.util.List;

import javax.swing.JFrame;

public class GameFrame extends JFrame {
	
	
	private GamePanel gpanel;

	public GameFrame(String title, int xSize, int ySize) {
		super(title);
		
		setSize(xSize, ySize);
		
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationByPlatform(true);
		
		gpanel = new GamePanel();
		add(gpanel);
	}
	
	public void addImage(BufferedImage img, int x, int y) {
		gpanel.addImage(img, x, y);
	}
	public void addMapImage(BufferedImage img, int x, int y) {
		gpanel.addMapImage(img, x, y);
	}

	public void addText(GameText text ) {
		gpanel.addText(text);
	}

	public void setMapImages(List<GameImage> list) {
		gpanel.setMapimages(list);
	}
	
	public void setImages(List<GameImage> list) {
		gpanel.setImages(list);
	}
	
	public void setText(List<GameText> gtext) {
		gpanel.setText(gtext);
	}
	
	public void removeLastImage() {
		gpanel.removeLastImage();
	}
	
	public void clearImages() {
		gpanel.clearImages();
	}

	public void clearMapImages() {
		gpanel.clearMapImages();
	}

}

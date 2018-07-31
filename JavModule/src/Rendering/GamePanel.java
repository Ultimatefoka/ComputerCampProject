package Rendering;
import java.util.ArrayList;
import java.util.List;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

class GamePanel extends JPanel {

	private List<GameImage> mapimages;
	private List<GameImage> images;
	private List<GameText> text;

	public GamePanel() {
		images = new ArrayList<GameImage>();
		mapimages = new ArrayList<GameImage>();
		text = new ArrayList<GameText>();
	}

	@Override
	public void paint(Graphics g) {
		g.clearRect(0, 0, this.getWidth(), this.getHeight());

		for (GameImage mapImages : mapimages) {
			g.drawImage(mapImages.getImage(), mapImages.getxPos(), mapImages.getyPos(), this);
		}

		for (GameImage gimg : images) {
			g.drawImage(gimg.getImage(), gimg.getxPos(), gimg.getyPos(), this);
		}
		
		for (GameText gameText : text) {			
			 g.setColor(gameText.getColor());
			 g.setFont(new Font(gameText.getFontName(), Font.PLAIN, gameText.getFontSize()));			     
				
			 g.drawString(gameText.getText(), gameText.getxPos(), gameText.getyPos());
			 // g.drawString(gt.getText(), gt.getxPos(), gt.getyPos());

		}

	}

	public void addImage(BufferedImage img, int x, int y) {
		images.add(new GameImage(img, x, y));
	}
	public void addMapImage(BufferedImage img, int x, int y) {
		mapimages.add(new GameImage(img, x, y));
	}

	public void addText(GameText text) {
		this.text.add(text);
	}

	public void setMapimages(List<GameImage> mapimages) {
		this.mapimages = mapimages;
	}

	public void setText(List<GameText> text) {
		this.text = text;
	}

	public void setImages(List<GameImage> images) {
		this.images = images;
	}

	public void clearImages() {
		images.clear();
	}
	
	public void clearMapImages() {
		mapimages.clear();
	}

	public void removeLastImage() {
		images.remove(images.size() - 1);
	}
}

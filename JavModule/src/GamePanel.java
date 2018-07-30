import java.util.ArrayList;
import java.util.List;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;


class GamePanel extends JPanel {

	private List<GameImage> mapimages;
	private List<GameImage> images;

	public GamePanel() {
		images = new ArrayList<GameImage>();
		mapimages = new ArrayList<GameImage>();
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

	}

	public void addImage(BufferedImage img, int x, int y) {
		images.add(new GameImage(img, x, y));
	}


	public void setMapimages(List<GameImage> mapimages) {
		this.mapimages = mapimages;
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

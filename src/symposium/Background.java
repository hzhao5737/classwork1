package symposium;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

import gui.components.Component;

public class Background extends Component{

	private String background = "resources/sampleImages/Pallet.png";
	private int file;

	public Background(int x, int y, int w, int h, int file){
		super(x, y, w, h);
		this.file = file;
		update();
	}

	@Override
	public void update(Graphics2D g) {
		g = clear();
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.fillRect(0, 0, getWidth(), getHeight());
		ImageIcon image = new ImageIcon(background);
		g.drawImage(image.getImage(), 0, 0, 640, 480, null);
	}
}

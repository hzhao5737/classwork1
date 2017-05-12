package symposium;

import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.ImageIcon;

import gui.components.Component;
import gui.components.MovingComponent;

public class Background extends MovingComponent{

	private int file;

	public Background(int x, int y, int w, int h, int file){
		super(x,y,w,h);
		this.file = file;
		update();
	}

	@Override
	public void update(Graphics2D g) {
		String[] background = {"resources/sampleImages/Pallet.png", "resources/sampleImages/Block.png"};
		g = clear();
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.fillRect(0, 0, getWidth(), getHeight());
		ImageIcon image = new ImageIcon(background[file]);
		g.drawImage(image.getImage(), 0, 0, getWidth(), getHeight(), null);
	}
}

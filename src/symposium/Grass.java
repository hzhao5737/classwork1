package symposium;

import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.ImageIcon;

import gui.components.Component;

public class Grass extends Component {

	public Grass(int x, int y, int w, int h) {
		super(x, y, w, h);
		update();
	}

	@Override
	public void update(Graphics2D g) {
		String grass = "resources/sampleImages/Grass.png" ;
		g = clear();
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.fillRect(0, 0, getWidth(), getHeight());
		ImageIcon image = new ImageIcon(grass);
		g.drawImage(image.getImage(), 0, 0, getWidth(), getHeight(), null);
	}
}

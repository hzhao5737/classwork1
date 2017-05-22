package symposium;

import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.ImageIcon;

import gui.components.Component;

public class Front extends Component {

	private int file;

	public Front(int x, int y, int w, int h, int file){
		super(x,y,w,h);
		this.file = file;
		update();
	}

	@Override
	public void update(Graphics2D g) {
		String[] frontground = {"resources/sampleImages/Block.png",
				"resources/sampleImages/Water.png",
				"resources/sampleImages/Fence.png",
				"resources/sampleImages/House.png",
				"resources/sampleImages/Lab.png",
				"resources/sampleImages/Shelf.png",
				"resources/sampleImages/Table.png",
				"resources/sampleImages/Computer.png"};
		g = clear();
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.fillRect(0, 0, getWidth(), getHeight());
		ImageIcon image = new ImageIcon(frontground[file]);
		g.drawImage(image.getImage(), 0, 0, getWidth(), getHeight(), null);
	}
}

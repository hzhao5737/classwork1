package symposium;

import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.ImageIcon;

import gui.Screen;
import gui.components.Component;

public class Door extends Component {
	
	private int file;

	public Door(int x, int y, int w, int h, int file){
		super(x,y,w,h);
		this.file = file;
		update();
	}

	@Override
	public void update(Graphics2D g) {
		String[] door = {"resources/sampleImages/Door.png"};
		g = clear();
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.fillRect(0, 0, getWidth(), getHeight());
		ImageIcon image = new ImageIcon(door[file]);
		g.drawImage(image.getImage(), 0, 0, getWidth(), getHeight(), null);
	}

	public Screen getScreen() {
		if(file == 0){
			Player.screen = 1;
			WorldMain.player.setX(144);
			WorldMain.player.setY(460);
			return Symposium.labScreen;
		}
		return null;
	}
}

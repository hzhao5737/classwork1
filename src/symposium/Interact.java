package symposium;

import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.ImageIcon;

import gui.components.Component;

public class Interact extends Component {
	
	public static boolean isText;
	private int file;

	public Interact(int x, int y, int w, int h, int file) {
		super(x, y, w, h);
		this.file = file;
		update();
	}

	@Override
	public void update(Graphics2D g) {
		String[] action = {"resources/sampleImages/Door.png",
				"resources/sampleImages/Prof.png"};
		g = clear();
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.fillRect(0, 0, getWidth(), getHeight());
		ImageIcon image = new ImageIcon(action[file]);
		g.drawImage(image.getImage(), 0, 0, getWidth(), getHeight(), null);
	}

	public void act() {
		if(file == 0){
			WorldMain.box.setVisible(true);
			isText = true;
			WorldMain.text.setText("Door is locked.");
			Player.moveable = false;
		}
		if(file == 1){
			LabMain.box.setVisible(true);
			isText = true;
			LabMain.text.setText("Defeat the gym leaders to win");
			Player.moveable = false;
		}
	}
}

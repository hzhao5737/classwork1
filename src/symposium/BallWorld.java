package symposium;

import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.ImageIcon;

import gui.components.Component;

public class BallWorld extends Component {
	
	private int file;

	public BallWorld(int x, int y, int w, int h, int file) {
		super(x, y, w, h);
		this.file = file;
		update();
	}

	@Override
	public void update(Graphics2D g) {
		g = clear();
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.fillRect(0, 0, getWidth(), getHeight());
		ImageIcon image = new ImageIcon("resources/sampleImages/Ballworld.png");
		g.drawImage(image.getImage(), 0, 0, getWidth(), getHeight(), null);
	}

	public void act() {
		if(file == 0){
			LabMain.box.setVisible(true);
			Player.isChoose = true;
			LabMain.text.setText("Take Venusaur?     Yes   No");
			Player.moveable = false;
		}
		if(file == 1){
			LabMain.box.setVisible(true);
			Player.isChoose = true;
			LabMain.text.setText("Take Charizard?     Yes   No");
			Player.moveable = false;
		}
		if(file == 2){
			LabMain.box.setVisible(true);
			Player.isChoose = true;
			LabMain.text.setText("Take Blastoise?     Yes   No");
			Player.moveable = false;
		}
	}

	public int getFile() {
		return file;
	}
}

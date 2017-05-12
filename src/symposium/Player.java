package symposium;

import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.ImageIcon;

import gui.components.Component;
import gui.components.MovingComponent;

public class Player extends MovingComponent {
	
	private int pos;

	public Player(int x, int y, int w, int h, int pos) {
		super(x, y, w, h);
		this.pos = pos;
		update();
	}
	
	@Override
	public void update(Graphics2D g) {
		String[] player = {"resources/sampleImages/PlayerD.png",
				"resources/sampleImages/PlayerD.png",
				"resources/sampleImages/PlayerD.png",
				"resources/sampleImages/PlayerD.png"};
		g = clear();
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.fillRect(0, 0, getWidth(), getHeight());
		ImageIcon play = new ImageIcon(player[pos]);
		g.drawImage(play.getImage(), 0, 0, getWidth(), getHeight(), null);
	}
	
	public void setPos(int pos){
		this.pos = pos;
	}

	public void move() {
		if(pos == 0){
			super.setY(getY()+24);
		}
		if(pos == 1){
			super.setX(getX()-32);
		}
		if(pos == 2){
			super.setY(getY()-24);
		}
		if(pos == 3){
			super.setX(getX()+32);
		}
	}
}

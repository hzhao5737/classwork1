package symposium;

import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.ImageIcon;

import gui.components.Component;
import gui.components.MovingComponent;

public class Player extends MovingComponent {

	private int pos;
	public static int screen;

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
		if(pos == 0 && isValid0()){
			super.setY(getY()+40);
		}
		if(pos == 1 && isValid1()){
			super.setX(getX()-36);
		}
		if(pos == 2 && isValid2()){
			super.setY(getY()-40);
		}
		if(pos == 3 && isValid3()){
			super.setX(getX()+36);
		}
	}

	private boolean isValid0() {
		if(screen == 0){
			if(getY() >= 660){
				return false;
			}
		}
		return true;
	}

	private boolean isValid1() {
		if(screen == 0){
			if(getX() <= 36){
				return false;
			}
		}
		return true;
	}

	private boolean isValid2() {
		if(screen == 1){
			return false;
		}
		return true;
	}

	private boolean isValid3() {
		if(screen == 0){
			if(getX() >= 648){
				return false;
			}
		}
		return true;
	}
}

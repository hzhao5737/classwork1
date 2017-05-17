package symposium;

import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.ImageIcon;

import gui.Screen;
import gui.components.Component;
import gui.components.MovingComponent;

public class Player extends MovingComponent {

	private int pos;
	public static int screen;
	private int newX;
	private int newY;

	public Player(int x, int y, int w, int h, int pos) {
		super(x, y, w, h);
		this.pos = pos;
		update();
	}

	@Override
	public void update(Graphics2D g) {
		String[] player = {"resources/sampleImages/PlayerD.png",
				"resources/sampleImages/PlayerL.png",
				"resources/sampleImages/PlayerU.png",
		"resources/sampleImages/PlayerR.png"};
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
			setY(getY()+40);
		}
		if(pos == 1 && isValid1()){
			setX(getX()-36);
		}
		if(pos == 2 && isValid2()){
			setY(getY()-40);
		}
		if(pos == 3 && isValid3()){
			setX(getX()+36);
		}
	}

	private boolean isValid0() {
		newX = getX();
		newY = getY()+40;
		if(screen == 0){
			if(getY() >= 660 || outOfBounds0()){
				return false;
			}
		}
		return true;
	}

	private boolean isValid1() {
		newX = getX()-36;
		newY = getY();
		if(screen == 0){
			if(getX() <= 36 || outOfBounds0()){
				return false;
			}
		}
		return true;
	}

	private boolean isValid2() {
		newX = getX();
		newY = getY()-40;
		if(screen == 0){
			if(outOfBounds0()){
				return false;
			}
		}
		return true;
	}

	private boolean isValid3() {
		newX = getX()+36;
		newY = getY();
		if(screen == 0){
			if(getX() >= 648 || outOfBounds0()){
				return false;
			}
		}
		return true;
	}

	private boolean outOfBounds0() {
		for(Door d : WorldMain.door){
			if(newX == d.getX() && newY == d.getY()){
				Symposium.game.setScreen(d.getScreen());
				Player.screen = 1;
			}
		}
		for(Front f : WorldMain.fore){
			if((newX >= f.getX() && newX < f.getX() + f.getWidth())
					&& (newY >= f.getY() && newY < f.getY() + f.getHeight())){
				return true;
			}
		}
		return false;
	}

	public void act() {
		// TODO Auto-generated method stub
		
	}
}

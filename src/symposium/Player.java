package symposium;

import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.ImageIcon;

import gui.Screen;
import gui.components.Component;
import gui.components.MovingComponent;
import gui.components.TextLabel;

public class Player extends MovingComponent {

	public boolean isMenu;
	private int pos;
	public static int screen;
	private int newX;
	private int newY;
	public boolean moveable;

	public Player(int x, int y, int w, int h, int pos) {
		super(x, y, w, h);
		this.pos = pos;
		moveable = true;
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

	public void move(int pos) {
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
			if(outOfBounds0() || getY() >= 660){
				return false;
			}
		}
		if(screen == 1){
			if(outOfBounds1() || getY() >= 460){
				return false;
			}
		}
		return true;
	}

	private boolean isValid1() {
		newX = getX()-36;
		newY = getY();
		if(screen == 0){
			if(outOfBounds0() || getX() <= 36){
				return false;
			}
		}
		if(screen == 1){
			if(outOfBounds1() || getX() <= 0){
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
		if(screen == 1){
			if(outOfBounds1() || getY() <= 60){
				return false;
			}
		}
		return true;
	}

	private boolean isValid3() {
		newX = getX()+36;
		newY = getY();
		if(screen == 0){
			if(outOfBounds0() || getX() >= 648){
				return false;
			}
		}
		if(screen == 1){
			if(outOfBounds1() || getX() >= 324){
				return false;
			}
		}
		return true;
	}

	private boolean outOfBounds1() {
		for(Door d : LabMain.door){
			if(newX == d.getX() && newY == d.getY()){
				Symposium.game.setScreen(d.getScreen());
			}
		}
		for(Front f : LabMain.fore){
			if((newX >= f.getX() && newX < f.getX() + f.getWidth())
					&& (newY >= f.getY() && newY < f.getY() + f.getHeight())){
				return true;
			}
		}
		return false;
	}

	private boolean outOfBounds0() {
		for(Door d : WorldMain.door){
			if(newX == d.getX() && newY == d.getY()){
				Symposium.game.setScreen(d.getScreen());
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
		if(pos == 0){
			for(Interact i : WorldMain.act){
				if(getY()+40 == i.getY() && getX() == i.getX()){
					i.act();
				}
			}
		}
		if(pos == 1){
			for(Interact i : WorldMain.act){
				if(getY() == i.getY() && getX()-36 == i.getX()){
					i.act();
				}
			}
		}
		if(pos == 2){
			for(Interact i : WorldMain.act){
				if(getY()-40 == i.getY() && getX() == i.getX()){
					i.act();
				}
			}
		}
		if(pos == 3){
			for(Interact i : WorldMain.act){
				if(getY() == i.getY() && getX()+36 == i.getX()){
					i.act();
				}
			}
		}
	}

	public void endText() {
		WorldMain.text.setText("");
		WorldMain.box.setVisible(false);
		WorldMain.menu.setVisible(false);
		for(TextLabel t : WorldMain.menuText){
			t.setVisible(false);
		}
		WorldMain.player.moveable = true;
	}

	public void menu() {
		WorldMain.player.moveable = false;
		WorldMain.menu.setVisible(true);
		isMenu = true;
		for(TextLabel t : WorldMain.menuText){
			t.setVisible(true);
		}
	}

	public void menuAct() {
		if(Interact.isText == true){
			WorldMain.text.setText("");
			WorldMain.box.setVisible(false);
			WorldMain.player.moveable = true;
			Interact.isText = false;
		}
	}

	public void menuClose() {
		if(isMenu == true){
			WorldMain.menu.setVisible(false);
			for(TextLabel t : WorldMain.menuText){
				t.setVisible(false);
			}
			isMenu = false;
			WorldMain.player.moveable = true;
		}
	}
}

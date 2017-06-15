package symposium;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import gui.Screen;
import gui.components.Component;
import gui.components.MovingComponent;
import gui.components.TextLabel;

public class Player extends MovingComponent {

	public static boolean isMenu;
	private int pos;
	public static int screen;
	private int newX;
	private int newY;
	public static boolean moveable;
	public static boolean isChoose;
	public int chosen;
	public static ArrayList<Pok> party;
	public static ArrayList<Pok> pc;

	public Player(int x, int y, int w, int h, int pos) {
		super(x, y, w, h);
		this.pos = pos;
		moveable = true;
		party = new ArrayList<Pok>();
		pc = new ArrayList<Pok>();
		screen = 0;
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
		switch(pos){
		case 0:
			if(isValid()){
				setY(getY()+40);
				break;
			}
		case 1:
			if(isValid()){
				setX(getX()-36);
				break;
			}
		case 2:
			if(isValid()){
				setY(getY()-40);
				break;
			}
		case 3:
			if(isValid()){
				setX(getX()+36);
				break;
			}
		}
		if(isGrass()){
			if(Math.random() < .1){
				BattleMain.startBattle();
				int pokemon = (int) (Math.random() * 5);
				switch(pokemon){
				case 0:
					BattleMain.opponent = new Pok("Venusaur");
					break;
				case 1:
					BattleMain.opponent = new Pok("Charizard");
					break;
				case 2:
					BattleMain.opponent = new Pok("Blastoise");
					break;
				case 3:
					BattleMain.opponent = new Pok("Golem");
					break;
				case 4:
					BattleMain.opponent = new Pok("Onix");
					break;
				}
				BattleMain.oppPok.setText(BattleMain.opponent.name
						+ "   " + BattleMain.opponent.currenthp
						+ "/" + BattleMain.opponent.hp);
				BattleMain.ownPok.setText(current().name
						+ "   " + current().currenthp
						+ "/" + current().hp);
				Symposium.game.setScreen(Symposium.battleScreen);
			}
		}
	}

	private boolean isGrass() {
		switch(screen){
		case 0: 
			for(Grass g : WorldMain.grass){
				if(getX() == g.getX() && getY() == g.getY()){
					return true;
				}
			}
			break;
		case 2:
			for(Grass g : RouteMain1.grass){
				if(getX() == g.getX() && getY() == g.getY()){
					return true;
				}
			}
			break;
		}
		return false;
	}

	private boolean isValid() {
		switch(pos){
		case 0:
			newX = getX();
			newY = getY()+40;
			switch(screen){
			case 0:
				if(outOfBounds() || getY() >= 660){
					return false;
				}
				return true;
			case 1:
				if(outOfBounds() || getY() >= 460){
					return false;
				}
				return true;
			case 2:
				if(outOfBounds() || getY() >= 580){
					return false;
				}
				return true;
			}
		case 1:
			newX = getX()-36;
			newY = getY();
			switch(screen){
			case 0:
				if(outOfBounds() || getX() <= 36){
					return false;
				}
				return true;
			case 1:
				if(outOfBounds() || getX() <= 0){
					return false;
				}
				return true;
			case 2:
				if(outOfBounds() || getX() <= 36){
					return false;
				}
				return true;
			}
		case 2:
			newX = getX();
			newY = getY()-40;
			switch(screen){
			case 0:
				if(outOfBounds() || (getY() <= 100 && party.size() == 0)){
					return false;
				}
				return true;
			case 1:
				if(outOfBounds() || getY() <= 60){
					return false;
				}
				return true;
			case 2:
				if(outOfBounds() || getY() <= 60){
					return false;
				}
				return true;
			}
		case 3:
			newX = getX()+36;
			newY = getY();
			switch(screen){
			case 0:
				if(outOfBounds() || getX() >= 648){
					return false;
				}
				return true;
			case 1:
				if(outOfBounds() || getX() >= 324){
					return false;
				}
				return true;
			case 2:
				if(outOfBounds() || getX() >= 504){
					return false;
				}
				return true;
			}
		}
		return false;
	}

	private boolean outOfBounds() {
		switch(screen){
		case 0:
			for(Door d : WorldMain.door){
				if(newX == d.getX() && newY == d.getY()){
					Symposium.game.setScreen(d.getScreen());
					break;
				}
			}
			for(Front f : WorldMain.fore){
				if((newX >= f.getX() && newX < f.getX() + f.getWidth())
						&& (newY >= f.getY() && newY < f.getY() + f.getHeight())){
					return true;
				}
			}
			for(Interact a : WorldMain.act){
				if((newX >= a.getX() && newX < a.getX() + a.getWidth())
						&& (newY >= a.getY() && newY < a.getY() + a.getHeight())){
					return true;
				}
			}
			return false;
		case 1:
			for(Door d : LabMain.door){
				if(newX == d.getX() && newY == d.getY()){
					Symposium.game.setScreen(d.getScreen());
					break;
				}
			}
			for(Front f : LabMain.fore){
				if((newX >= f.getX() && newX < f.getX() + f.getWidth())
						&& (newY >= f.getY() && newY < f.getY() + f.getHeight())){
					return true;
				}
			}
			return false;
		case 2:
			for(Door d : RouteMain1.door){
				if(newX == d.getX() && newY == d.getY()){
					Symposium.game.setScreen(d.getScreen());
					break;
				}
			}
			for(Front f : RouteMain1.fore){
				if((newX >= f.getX() && newX < f.getX() + f.getWidth())
						&& (newY >= f.getY() && newY < f.getY() + f.getHeight())){
					return true;
				}
			}
			return false;
		}
		return false;
	}

	public void act(){
		switch(screen){
		case 0:
			switch(pos){
			case 0:
				for(Interact i : WorldMain.act){
					if(getY()+40 == i.getY() && getX() == i.getX()){
						i.act();
					}
				}
			case 1:
				for(Interact i : WorldMain.act){
					if(getY() == i.getY() && getX()-36 == i.getX()){
						i.act();
					}
				}
			case 2:
				for(Interact i : WorldMain.act){
					if(getY()-40 == i.getY() && getX() == i.getX()){
						i.act();
					}
				}
			case 3:
				for(Interact i : WorldMain.act){
					if(getY() == i.getY() && getX()+36 == i.getX()){
						i.act();
					}
				}
			}
		case 1:
			switch(pos){
			case 0:
				for(Interact i : LabMain.act){
					if(getY()+40 == i.getY() && getX() == i.getX()){
						i.act();
					}
				}
				for(BallWorld i : LabMain.balls){
					if(getY()+40 == i.getY() && getX() == i.getX()){
						chosen = i.getFile();
						i.act();
					}
				}
			case 1:
				for(Interact i : LabMain.act){
					if(getY() == i.getY() && getX()-36 == i.getX()){
						i.act();
					}
				}
				for(BallWorld i : LabMain.balls){
					if(getY() == i.getY() && getX()-36 == i.getX()){
						chosen = i.getFile();
						i.act();
					}
				}
			case 2:
				for(Interact i : LabMain.act){
					if(getY()-40 == i.getY() && getX() == i.getX()){
						i.act();
					}
				}
				for(BallWorld i : LabMain.balls){
					if(getY()-40 == i.getY() && getX() == i.getX()){
						chosen = i.getFile();
						i.act();
					}
				}
			case 3:
				for(Interact i : LabMain.act){
					if(getY() == i.getY() && getX()+36 == i.getX()){
						i.act();
					}
				}
				for(BallWorld i : LabMain.balls){
					if(getY() == i.getY() && getX()+36 == i.getX()){
						chosen = i.getFile();
						i.act();
					}
				}
			}
		}
	}

	public void endText() {
		switch(screen){
		case 0:
			WorldMain.text.setText("");
			WorldMain.box.setVisible(false);
			WorldMain.menu.setVisible(false);
			for(TextLabel t : WorldMain.menuText){
				t.setVisible(false);
			}
			isMenu = false;
			Interact.isText = false;
			moveable = true;
		case 1:
			LabMain.text.setText("");
			LabMain.box.setVisible(false);
			LabMain.menu.setVisible(false);
			for(TextLabel t : LabMain.menuText){
				t.setVisible(false);
			}
			isMenu = false;
			isChoose = false;
			Interact.isText = false;
			moveable = true;
		case 2:
			RouteMain1.text.setText("");
			RouteMain1.box.setVisible(false);
			RouteMain1.menu.setVisible(false);
			for(TextLabel t : RouteMain1.menuText){
				t.setVisible(false);
			}
			isMenu = false;
			Interact.isText = false;
			moveable = true;
		}
	}

	public void menu() {
		switch(screen){
		case 0:
			moveable = false;
			WorldMain.menu.setVisible(true);
			isMenu = true;
			for(TextLabel w : WorldMain.menuText){
				w.setVisible(true);
			}
		case 1:
			moveable = false;
			LabMain.menu.setVisible(true);
			isMenu = true;
			for(TextLabel l : LabMain.menuText){
				l.setVisible(true);
			}
		case 2:
			moveable = false;
			RouteMain1.menu.setVisible(true);
			isMenu = true;
			for(TextLabel w : RouteMain1.menuText){
				w.setVisible(true);
			}
		}
	}

	public void menuAct() {
		switch(screen){
		case 0:
			if(Interact.isText){
				WorldMain.text.setText("");
				WorldMain.box.setVisible(false);
				moveable = true;
				Interact.isText = false;
				break;
			}
		case 1:
			if(Interact.isText){
				LabMain.text.setText("");
				LabMain.box.setVisible(false);
				moveable = true;
				Interact.isText = false;
				break;
			}
			if(isChoose){
				isChoose = false;
				moveable = true;
				LabMain.text.setText("");
				LabMain.box.setVisible(false);
				break;
			}
		case 2:
			if(Interact.isText){
				RouteMain1.text.setText("");
				RouteMain1.box.setVisible(false);
				moveable = true;
				Interact.isText = false;
				break;
			}
		}
	}

	public void menuClose() {
		switch(screen){
		case 0:
			if(isMenu){
				WorldMain.menu.setVisible(false);
				for(TextLabel t : WorldMain.menuText){
					t.setVisible(false);
				}
				isMenu = false;
				moveable = true;
			}
		case 1:
			if(isMenu){
				LabMain.menu.setVisible(false);
				for(TextLabel t : LabMain.menuText){
					t.setVisible(false);
				}
				isMenu = false;
				moveable = true;
			}
		case 2:
			if(isMenu){
				RouteMain1.menu.setVisible(false);
				for(TextLabel t : RouteMain1.menuText){
					t.setVisible(false);
				}
				isMenu = false;
				moveable = true;
			}
		}
	}

	public void selectBall() {
		if(chosen == 0){
			party.add(new Pok("Venusaur"));
		}
		if(chosen == 1){
			party.add(new Pok("Charizard"));
		}
		if(chosen == 2){
			party.add(new Pok("Blastoise"));
		}
		if(party.size() > 6){
			pc.add(party.get(6));
			party.remove(6);
		}
		MenuMain.partyUpdate();
	}

	public static Pok current(){
		for(Pok p : party){
			if(p.currenthp != 0){
				return p;
			}
		}
		return null;
	}

	public static void healAll(){
		for(Pok p : party){
			p.currenthp = p.hp;
			for(Moves m : p.moves){
				m.currentpp = m.pp;
			}
			p.clearStatus();
		}
	}
}

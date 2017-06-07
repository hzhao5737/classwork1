package symposium;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import gui.Screen;
import gui.components.Button;
import gui.components.TextLabel;
import gui.components.Visible;

public class BattleMain extends Screen implements Runnable, KeyListener{

	public static ArrayList<TextLabel> moves;
	public static ArrayList<TextLabel> actions;
	public static Button menu;
	public static TextLabel ownPok;
	public static TextLabel oppPok;
	public static TextLabel action;
	public boolean inMenu;
	public boolean inAttack;
	public boolean inAction;
	public boolean isFirst;
	public static Pok opponent;
	public static Moves playermove;
	public static Pok ours;
	public static Moves oppMove;
	public int message;
	public int damage;
	public int multiplier;

	public BattleMain(int width, int height) {
		super(width, height);
		update();
	}

	public static void showMoves(){
		for(int i = 0; i < moves.size(); i++){
			moves.get(i).setText(i+1 + ". " + ours.moves[i].move);
		}
	}

	public static void hideMoves(){
		for(int i = 0; i < moves.size(); i++){
			moves.get(i).setText("");
		}
	}

	public static void showMenu(){
		for(int i = 0; i < moves.size(); i++){
			actions.get(i).setVisible(true);
		}
	}

	public static void hideMenu(){
		for(int i = 0; i < moves.size(); i++){
			actions.get(i).setVisible(false);
		}
	}

	public static void showAction(){
		action.setVisible(true);

	}

	public static void hideAction(){
		action.setVisible(false);
	}

	@Override
	public void initObjects(ArrayList<Visible> v) {
		moves = new ArrayList<TextLabel>();
		actions = new ArrayList<TextLabel>();
		menu = new Button(50, 500, 600, 200, null, null, null);
		action = new TextLabel(100, 550, 500, 50, "");
		oppPok = new TextLabel(200, 100, 500, 50, "");
		ownPok = new TextLabel(400, 400, 500, 50, "");
		moves.add(new TextLabel(100, 500, 500, 50, ""));
		moves.add(new TextLabel(100, 550, 500, 50, ""));
		moves.add(new TextLabel(100, 600, 500, 50, ""));
		moves.add(new TextLabel(100, 650, 500, 50, ""));
		actions.add(new TextLabel(500, 500, 500, 50, "1. Fight"));
		actions.add(new TextLabel(500, 550, 500, 50, "2. Pokemon"));
		actions.add(new TextLabel(500, 600, 500, 50, "3. Items"));
		actions.add(new TextLabel(500, 650, 500, 50, "4. Run"));
		v.add(oppPok);
		v.add(ownPok);
		v.add(menu);
		v.addAll(actions);
		v.addAll(moves);
		v.add(action);
		action.setVisible(false);
		inMenu = true;
		inAttack = false;
	}

	public KeyListener getKeyListener() {
		return this;
	}

	@Override
	public void keyPressed(KeyEvent k) {
		int key = k.getKeyCode();
		if(inAttack){
			if (key == KeyEvent.VK_ESCAPE){
				hideMoves();
				showMenu();
				inMenu = true;
				inAttack = false;
			}if (key == KeyEvent.VK_1){
				playermove = ours.moves[0];
				hideMoves();
				hideMenu();
				startTurn();
			}if (key == KeyEvent.VK_2){
				playermove = ours.moves[1];
				hideMoves();
				hideMenu();
				startTurn();
			}if (key == KeyEvent.VK_3){
				playermove = ours.moves[2];
				hideMoves();
				hideMenu();
				startTurn();
			}if (key == KeyEvent.VK_4){
				playermove = ours.moves[3];
				hideMoves();
				hideMenu();
				startTurn();
			}
		}else if(inMenu){
			if (key == KeyEvent.VK_1){
				showMoves();
				hideMenu();
				inMenu = false;
				inAttack = true;
			}
			if (key == KeyEvent.VK_4){
				if(ours.currentspeed >= opponent.currentspeed){
					switch(Player.screen){
					case 0:
						Symposium.game.setScreen(Symposium.worldScreen);
						break;
					case 1:
						Symposium.game.setScreen(Symposium.labScreen);
						break;
					case 2:
						Symposium.game.setScreen(Symposium.routeScreen1);
						break;
					}
				}else{
					inMenu = false;
					inAction = true;
					hideMenu();
					opponentAttack();
				}
			}
		}else if(inAction){
			if (key == KeyEvent.VK_ENTER){
				nextAttack();
			}
		}
	}

	private void nextAttack() {
		if(message == 0){
			if(ours.currenthp == 0 && Player.current() == null){
				hideAction();
				updateHealth();
				showMenu();
				inAttack = false;
				inMenu = true;
				inAction = false;
				message = 0;
				endBattle();
			}
			ours = Player.current();
			hideAction();
			updateHealth();
			showMenu();
			inAttack = false;
			inMenu = true;
			inAction = false;
		}
		if(message == 1){
			if(opponent.currenthp == 0){
				hideAction();
				updateHealth();
				showMenu();
				inAttack = false;
				inMenu = true;
				inAction = false;
				message = 0;
				endBattle();
			}else{
				opponentAttack();
				message = 3;
			}
		}else if(message == 2){
			if(ours.currenthp == 0 && Player.current() == null){
				hideAction();
				updateHealth();
				showMenu();
				inAttack = false;
				inMenu = true;
				inAction = false;
				message = 0;
				endBattle();
			}else{
				ours = Player.current();
				youAttack();
				message = 4;
			}
		}else if(message == 3){
			if(ours.currenthp == 0 && Player.current() == null){
				hideAction();
				updateHealth();
				showMenu();
				inAttack = false;
				inMenu = true;
				inAction = false;
				message = 0;
				endBattle();
			}
			ours = Player.current();
			hideAction();
			updateHealth();
			showMenu();
			inAttack = false;
			inMenu = true;
			inAction = false;
			message = 0;
		}else if(message == 4){
			if(opponent.currenthp == 0){
				hideAction();
				updateHealth();
				showMenu();
				inAttack = false;
				inMenu = true;
				inAction = false;
				message = 0;
				endBattle();
			}
			hideAction();
			updateHealth();
			showMenu();
			inAttack = false;
			inMenu = true;
			inAction = false;
			message = 0;
		}
	}

	public static void startBattle(){
		ours = Player.current();
	}

	private void startTurn() {
		inAttack = false;
		message = 0;
		inAction = true;
		isFirst = ours.currentspeed >= opponent.currentspeed;
		if(isFirst){
			youAttack();
			message = 1;
		}else{
			opponentAttack();
			message = 2;
		}
	}

	private void endBattle() {
		if(Player.current() == null){
			Player.healAll();
			WorldMain.player.setX(180);
			WorldMain.player.setY(260);
			WorldMain.player.setPos(0);
			WorldMain.player.update();
			Symposium.game.setScreen(Symposium.worldScreen);
		}else{
			switch(Player.screen){
			case 0:
				Symposium.game.setScreen(Symposium.worldScreen);
				break;
			case 1:
				Symposium.game.setScreen(Symposium.labScreen);
				break;
			case 2:
				Symposium.game.setScreen(Symposium.routeScreen1);
				break;
			}
		}
	}

	private void youAttack() {
		if(playermove.which == 1){
			damage = playermove.power + ours.currentattack - opponent.currentdefense;
		}else if(playermove.which == 2){
			damage = playermove.power + ours.currentspecial - opponent.currentspecial;
		}
		isEffective(playermove.type);
		damage = damage * multiplier;
		opponent.currenthp = opponent.currenthp - damage;
		if(opponent.currenthp <= 0){
			opponent.currenthp = 0;
		}
		showAction();
		action.setText("You used " + playermove.move);
		updateHealth();
	}

	private void opponentAttack() {
		oppMove = opponent.moves[(int) Math.random() * 4];
		if(oppMove.which == 1){
			damage = oppMove.power + opponent.currentattack - ours.currentdefense;
		}else if(oppMove.which == 2){
			damage = oppMove.power + opponent.currentspecial - ours.currentspecial;
		}
		isEffective(oppMove.type);
		damage = damage * multiplier;
		ours.currenthp = ours.currenthp - damage;
		if(ours.currenthp <= 0){
			ours.currenthp = 0;
		}
		showAction();
		action.setText("He used " + oppMove.move);
		updateHealth();
	}

	private void isEffective(int type) {
		multiplier = 1;
		switch(type){
		case 0:
			for(int t: opponent.type){
				if(t == 12){
					multiplier = multiplier / 2;
				}if(t == 13){
					multiplier = multiplier * 0;
				}
			}
		case 1:
			for(int t: opponent.type){
				if(t == 1){
					multiplier = multiplier / 2;
				}if(t == 2){
					multiplier = multiplier / 2;
				}if(t == 4){
					multiplier = multiplier * 2;
				}if(t == 5){
					multiplier = multiplier * 2;
				}if(t == 11){
					multiplier = multiplier * 2;
				}if(t == 12){
					multiplier = multiplier / 2;
				}if(t == 14){
					multiplier = multiplier / 2;
				}
			}
		}
	}

	private void updateHealth() {
		oppPok.setText(BattleMain.opponent.name
				+ "   " + BattleMain.opponent.currenthp
				+ "/" + BattleMain.opponent.hp);
		ownPok.setText(ours.name
				+ "   " + ours.currenthp
				+ "/" + ours.hp);
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void run() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

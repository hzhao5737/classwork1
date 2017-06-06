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
	public static Pok opponent;
	public static Moves playermove;
	public static Pok ours;
	public static Moves oppMove;

	public BattleMain(int width, int height) {
		super(width, height);
		update();
	}

	public static void showMoves(){
		for(int i = 0; i < moves.size(); i++){
			moves.get(i).setText(ours.moves[i].move);
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
		menu = new Button(100, 500, 500, 200, null, null, null);
		action = new TextLabel(100, 550, 500, 50, "YOU USED TACKLE");
		oppPok = new TextLabel(200, 100, 500, 50, "");
		ownPok = new TextLabel(400, 400, 500, 50, "");
		moves.add(new TextLabel(100, 500, 500, 50, ""));
		moves.add(new TextLabel(100, 550, 500, 50, ""));
		moves.add(new TextLabel(100, 600, 500, 50, ""));
		moves.add(new TextLabel(100, 650, 500, 50, ""));
		actions.add(new TextLabel(500, 500, 500, 50, "Fight"));
		actions.add(new TextLabel(500, 550, 500, 50, "Pokemon"));
		actions.add(new TextLabel(500, 600, 500, 50, "Items"));
		actions.add(new TextLabel(500, 650, 500, 50, "Run"));
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
	}

	public static void startBattle(){
		ours = Player.current();
	}

	private void startTurn() {
		oppMove = opponent.moves[(int) Math.random() * 4];
		boolean isFirst = ours.currentspeed >= opponent.currentspeed;
		if(isFirst){
			youAttack();
			if(opponent.currenthp == 0){
				endBattle();
			}else{
				opponentAttack();
				if(ours.currenthp == 0 && Player.current() == null){
					endBattle();
				}
				ours = Player.current();
			}
		}else{
			opponentAttack();
			if(ours.currenthp == 0 && Player.current() == null){
				endBattle();
			}else{
				ours = Player.current();
				youAttack();
				if(opponent.currenthp == 0){
					endBattle();
				}
			}
		}
		updateHealth();
		showMenu();
		inAttack = false;
		inMenu = true;
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
		opponent.currenthp = opponent.currenthp - playermove.power;
		if(opponent.currenthp <= 0){
			opponent.currenthp = 0;
		}
		showAction();
		updateHealth();
		hideAction();
	}

	private void opponentAttack() {
		ours.currenthp = ours.currenthp - oppMove.power;
		if(ours.currenthp <= 0){
			ours.currenthp = 0;
		}
		showAction();
		updateHealth();
		hideAction();
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

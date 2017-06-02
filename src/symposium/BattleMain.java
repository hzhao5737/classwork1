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
	public boolean inMenu;
	public boolean inAttack;
	public static Pok opponent;
	public static Moves playermove;
	public static Pok ours;
	
	public BattleMain(int width, int height) {
		super(width, height);
		update();
	}
	
	public static void showMoves(){
		for(int i = 0; i < moves.size(); i++){
			actions.get(i).setVisible(false);
			moves.get(i).setText(Player.current().moves[i].move);
		}
	}
	
	public static void hideMoves(){
		for(int i = 0; i < moves.size(); i++){
			actions.get(i).setVisible(true);
			moves.get(i).setText("");
		}
	}

	@Override
	public void initObjects(ArrayList<Visible> v) {
		moves = new ArrayList<TextLabel>();
		actions = new ArrayList<TextLabel>();
		menu = new Button(100, 500, 500, 200, null, null, null);
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
				inMenu = true;
				inAttack = false;
			}if (key == KeyEvent.VK_1){
				playermove = Player.current().moves[0];
				hideMoves();
				startTurn();
			}if (key == KeyEvent.VK_2){
				playermove = Player.current().moves[1];
				hideMoves();
				startTurn();
			}if (key == KeyEvent.VK_3){
				playermove = Player.current().moves[2];
				hideMoves();
				startTurn();
			}if (key == KeyEvent.VK_4){
				playermove = Player.current().moves[3];
				hideMoves();
				startTurn();
			}
		}
		if(inMenu){
			if (key == KeyEvent.VK_1){
				showMoves();
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

	private void startTurn() {
		ours = Player.current();
		Moves oppMove = opponent.moves[(int) Math.random() * 4];
		boolean isFirst = ours.currentspeed >= opponent.currentspeed;
		if(isFirst){
			opponent.currenthp = opponent.currenthp - playermove.power;
			if(opponent.currenthp <= 0){
				opponent.currenthp = 0;
			}else{
				ours.currenthp = ours.currenthp - oppMove.power;
				if(ours.currenthp <= 0){
					ours.currenthp = 0;
				}
			}
		}else{
			ours.currenthp = ours.currenthp - oppMove.power;
			if(ours.currenthp <= 0){
				ours.currenthp = 0;
			}else{
				opponent.currenthp = opponent.currenthp - playermove.power;
				if(opponent.currenthp <= 0){
					opponent.currenthp = 0;
				}
			}
		}
		updateHealth();
		inAttack = false;
		inMenu = true;
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
		while(true){
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//update();
		}
	}
}

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
	private int[][] effective;

	public BattleMain(int width, int height) {
		super(width, height);
		update();
	}

	public static void showMoves(){
		for(int i = 0; i < moves.size(); i++){
			moves.get(i).setText(i+1 + ". " + ours.moves[i].move + "   " + ours.moves[i].currentpp + "/" + ours.moves[i].pp);
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
		effective = new int[15][15];
		effective[0][7] = -1;
		effective[1][7] = -1;
		effective[4][2] = -1;
		effective[7][0] = -1;
		effective[7][12] = -1;
		effective[11][4] = -1;
		effective[0][5] = 1;
		effective[1][2] = 1;
		effective[1][3] = 1;
		effective[1][6] = 1;
		effective[1][12] = 1;
		effective[2][5] = 1;
		effective[2][11] = 1;
		effective[3][3] = 1;
		effective[3][4] = 1;
		effective[3][5] = 1;
		effective[3][7] = 1;
		effective[4][6] = 1;
		effective[4][10] = 1;
		effective[5][1] = 1;
		effective[5][4] = 1;
		effective[6][1] = 1;
		effective[6][2] = 1;
		effective[6][7] = 1;
		effective[6][8] = 1;
		effective[8][5] = 1;
		effective[8][8] = 1;
		effective[8][9] = 1;
		effective[8][14] = 1;
		effective[9][9] = 1;
		effective[9][10] = 1;
		effective[9][14] = 1;
		effective[10][2] = 1;
		effective[10][3] = 1;
		effective[10][6] = 1;
		effective[10][8] = 1;
		effective[10][10] = 1;
		effective[10][14] = 1;
		effective[11][10] = 1;
		effective[11][11] = 1;
		effective[11][14] = 1;
		effective[12][12] = 1;
		effective[13][9] = 1;
		effective[13][13] = 1;
		effective[1][0] = 2;
		effective[1][5] = 2;
		effective[1][13] = 2;
		effective[2][1] = 2;
		effective[2][6] = 2;
		effective[2][10] = 2;
		effective[3][6] = 2;
		effective[3][10] = 2;
		effective[4][3] = 2;
		effective[4][5] = 2;
		effective[4][8] = 2;
		effective[4][11] = 2;
		effective[5][2] = 2;
		effective[5][6] = 2;
		effective[5][8] = 2;
		effective[5][13] = 2;
		effective[6][3] = 2;
		effective[6][10] = 2;
		effective[6][12] = 2;
		effective[7][7] = 2;
		
		effective[8][8] = 2;
		effective[8][9] = 2;
		effective[8][14] = 2;
		
		effective[9][9] = 2;
		effective[9][10] = 2;
		effective[9][14] = 2;
		effective[10][2] = 2;
		effective[10][3] = 2;
		effective[10][6] = 2;
		effective[10][8] = 2;
		effective[10][10] = 2;
		effective[10][14] = 2;
		effective[11][10] = 2;
		effective[11][11] = 2;
		effective[11][14] = 2;
		effective[12][12] = 2;
		effective[13][9] = 2;
		effective[13][13] = 2;
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
				if(ours.moves[0].currentpp > 0){
					playermove = ours.moves[0];
					hideMoves();
					hideMenu();
					startTurn();
				}
			}if (key == KeyEvent.VK_2){
				if(ours.moves[1].currentpp > 0){
					playermove = ours.moves[1];
					hideMoves();
					hideMenu();
					startTurn();
				}
			}if (key == KeyEvent.VK_3){
				if(ours.moves[2].currentpp > 0){
					playermove = ours.moves[2];
					hideMoves();
					hideMenu();
					startTurn();
				}
			}if (key == KeyEvent.VK_4){
				if(ours.moves[3].currentpp > 0){
					playermove = ours.moves[3];
					hideMoves();
					hideMenu();
					startTurn();
				}
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
		playermove.currentpp --;
		if(playermove.accuracy >= ((int) (Math.random() * 100))){
			if(playermove.which == 1){
				damage = ((42 * playermove.power * (ours.currentattack / opponent.currentdefense)) / 50) +2;
			}else if(playermove.which == 2){
				damage = ((42 * playermove.power * (ours.currentspecial / opponent.currentspecial)) / 50) +2;
			}
			if(isStabUs()){
				damage = (int) (damage * 1.5);
			}
			isEffectiveTo(playermove.type);
			damage = damage * multiplier;
			opponent.currenthp = opponent.currenthp - damage;
			if(opponent.currenthp <= 0){
				opponent.currenthp = 0;
			}
			showAction();
			if(multiplier < 1){
				action.setText("You used " + oppMove.move + ". It's was not very effective.");
			}else if(multiplier > 1){
				action.setText("You used " + oppMove.move + ". It's super effective.");
			}else{
				action.setText("You used " + playermove.move);
			}
			updateHealth();
		}else{
			showAction();
			action.setText("You missed");
		}
	}

	private void opponentAttack() {
		chooseMove();
		if(oppMove.accuracy >= ((int) (Math.random() * 100))){
			if(oppMove.which == 1){
				damage = ((42 * oppMove.power * (opponent.currentattack / ours.currentdefense)) / 50) +2;
			}else if(oppMove.which == 2){
				damage = ((42 * oppMove.power * (opponent.currentspecial / ours.currentspecial)) / 50) +2;
			}
			if(isStabOpp()){
				damage = (int) (damage * 1.5);
			}
			isEffectiveFrom(oppMove.type);
			damage = damage * multiplier;
			ours.currenthp = ours.currenthp - damage;
			if(ours.currenthp <= 0){
				ours.currenthp = 0;
			}
			showAction();
			if(multiplier < 1){
				action.setText("Opponent used " + oppMove.move + ". It's was not very effective.");
			}else if(multiplier > 1){
				action.setText("Opponent used " + oppMove.move + ". It's super effective.");
			}else{
				action.setText("Opponent used " + oppMove.move);
			}
			updateHealth();
		}else{
			showAction();
			action.setText("Opponent missed");
		}
	}

	private void chooseMove() {
		int[] moves = new int[4];
		int unusable = 0;
		boolean finding = true;
		for(int i = 0; i < 4; i++){
			if(opponent.moves[i].currentpp == 0){
				moves[i] = 1;
				unusable ++;
			}
		}
		if(unusable == 4){
			oppMove = new Moves("Struggle");
		}else{
			while(finding){
				oppMove = opponent.moves[(int) (Math.random() * 4)];
				if(oppMove.currentpp > 0){
					oppMove.currentpp --;
					finding = false;
				}
			}
		}
	}

	private boolean isStabUs() {
		for(int t: ours.type){
			if(t == playermove.type){
				return true;
			}	
		}
		return false;
	}

	private boolean isStabOpp() {
		for(int t: opponent.type){
			if(t == oppMove.type){
				return true;
			}	
		}
		return false;
	}

	private void isEffectiveFrom(int type) {

	}

	private void isEffectiveTo(int type) {
		multiplier = 1;
		switch(type){
		case 0:
			for(int t: opponent.type){
				if(t == 5){
					multiplier = multiplier / 2;
				}if(t == 7){
					multiplier = multiplier * 0;
				}
			}break;
		case 1:
			for(int t: opponent.type){
				if(t == 0){
					multiplier = multiplier * 2;
				}if(t == 2){
					multiplier = multiplier / 2;
				}if(t == 3){
					multiplier = multiplier / 2;
				}if(t == 5){
					multiplier = multiplier * 2;
				}if(t == 6){
					multiplier = multiplier / 2;
				}if(t == 7){
					multiplier = multiplier * 0;
				}if(t == 12){
					multiplier = multiplier / 2;
				}if(t == 13){
					multiplier = multiplier * 2;
				}
			}break;
		case 2:
			for(int t: opponent.type){
				if(t == 1){
					multiplier = multiplier * 2;
				}if(t == 5){
					multiplier = multiplier / 2;
				}if(t == 6){
					multiplier = multiplier * 2;
				}if(t == 10){
					multiplier = multiplier * 2;
				}if(t == 11){
					multiplier = multiplier / 2;
				}
			}break;
		case 3:
			for(int t: opponent.type){
				if(t == 3){
					multiplier = multiplier / 2;
				}if(t == 4){
					multiplier = multiplier / 2;
				}if(t == 5){
					multiplier = multiplier / 2;
				}if(t == 6){
					multiplier = multiplier * 2;
				}if(t == 7){
					multiplier = multiplier / 2;
				}if(t == 10){
					multiplier = multiplier * 2;
				}
			}break;
		case 4:
			for(int t: opponent.type){
				if(t == 2){
					multiplier = multiplier * 0;
				}if(t == 3){
					multiplier = multiplier / 2;
				}if(t == 5){
					multiplier = multiplier * 2;
				}if(t == 6){
					multiplier = multiplier / 2;
				}if(t == 8){
					multiplier = multiplier * 2;
				}if(t == 10){
					multiplier = multiplier / 2;
				}if(t == 11){
					multiplier = multiplier * 2;
				}
			}break;
		case 5:
			for(int t: opponent.type){
				if(t == 2){
					multiplier = multiplier * 0;
				}if(t == 3){
					multiplier = multiplier / 2;
				}if(t == 5){
					multiplier = multiplier * 2;
				}if(t == 6){
					multiplier = multiplier / 2;
				}if(t == 8){
					multiplier = multiplier * 2;
				}if(t == 10){
					multiplier = multiplier / 2;
				}if(t == 11){
					multiplier = multiplier * 2;
				}
			}break;
		}
	}

	/* 0 normal
	 * 1 fight
	 * 2 flying
	 * 3 poison
	 * 4 ground
	 * 5 rock
	 * 6 bug
	 * 7 ghost
	 * 8 fire
	 * 9 water
	 * 10 grass
	 * 11 electric
	 * 12 psychic
	 * 13 ice
	 * 14 dragon
	 */

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

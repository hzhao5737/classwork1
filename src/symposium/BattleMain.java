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
	public static boolean inMenu;
	public static boolean inAttack;
	public static boolean inAction;
	public static boolean isFirst;
	public static Pok opponent;
	public static Moves playermove;
	public static Pok ours;
	public static Moves oppMove;
	public static int message;
	public static int damage;
	public static double multiplier;
	private static double[][] effective;
	private static int chargeTurn;
	private static int oppChargeTurn;
	private static boolean isCrit;
	private static double rageCount;
	private static double oppRageCount;
	private static int firespindmg;
	private static int oppfirespindmg;
	public static boolean inBattle;

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
		action = new TextLabel(50, 550, 600, 50, "");
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
		effective = new double[15][15];
		for(int i = 0; i < effective.length; i++){
			for(int k = 0; k < effective[i].length; k++){
				effective[i][k] = 1;
			}
		}
		effective[0][7] = 0;
		effective[1][7] = 0;
		effective[4][2] = 0;
		effective[7][0] = 0;
		effective[7][12] = 0;
		effective[11][4] = 0;
		effective[0][5] = .5;
		effective[1][2] = .5;
		effective[1][3] = .5;
		effective[1][6] = .5;
		effective[1][12] = .5;
		effective[2][5] = .5;
		effective[2][11] = .5;
		effective[3][3] = .5;
		effective[3][4] = .5;
		effective[3][5] = .5;
		effective[3][7] = .5;
		effective[4][6] = .5;
		effective[4][10] = .5;
		effective[5][1] = .5;
		effective[5][4] = .5;
		effective[6][1] = .5;
		effective[6][2] = .5;
		effective[6][7] = .5;
		effective[6][8] = .5;
		effective[8][5] = .5;
		effective[8][8] = .5;
		effective[8][9] = .5;
		effective[8][14] = .5;
		effective[9][9] = .5;
		effective[9][10] = .5;
		effective[9][14] = .5;
		effective[10][2] = .5;
		effective[10][3] = .5;
		effective[10][6] = .5;
		effective[10][8] = .5;
		effective[10][10] = .5;
		effective[10][14] = .5;
		effective[11][10] = .5;
		effective[11][11] = .5;
		effective[11][14] = .5;
		effective[12][12] = .5;
		effective[13][9] = .5;
		effective[13][13] = .5;
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
		effective[8][6] = 2;
		effective[8][10] = 2;
		effective[8][13] = 2;
		effective[9][4] = 2;
		effective[9][5] = 2;
		effective[9][8] = 2;
		effective[10][4] = 2;
		effective[10][5] = 2;
		effective[10][9] = 2;
		effective[11][2] = 2;
		effective[11][9] = 2;
		effective[12][1] = 2;
		effective[12][3] = 2;
		effective[13][2] = 2;
		effective[13][4] = 2;
		effective[13][10] = 2;
		effective[13][14] = 2;
		effective[14][14] = 2;
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
				if(chargeTurn == 1){
					hideMoves();
					hideMenu();
					startTurn();
					inMenu = false;
				}else if(rageCount > 1){
					hideMoves();
					hideMenu();
					startTurn();
					inMenu = false;
				}
				else if(noMoves()){
					hideMoves();
					hideMenu();
					playermove = new Moves("Struggle");
					startTurn();
					inMenu = false;
				}else{
					showMoves();
					hideMenu();
					inMenu = false;
					inAttack = true;
				}
			}
			if (key == KeyEvent.VK_2){
				MenuMain.partyUpdate();
				Symposium.game.setScreen(Symposium.infoScreen);
			}
			if (key == KeyEvent.VK_3){
				ItemMain.itemUpdate();
				Symposium.game.setScreen(Symposium.itemScreen);
			}
			if(key == KeyEvent.VK_4){
				if(ours.wrapped){
					inMenu = false;
					inAction = true;
					ours.turnsSkipped++;
					hideMenu();
					opponentAttack();
				}
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
		}
		else if(inAction){
			if (key == KeyEvent.VK_ENTER){
				nextAttack();
			}
		}
	}

	private boolean noMoves(){
		int moves = 0;
		for(Moves m : ours.moves){
			if(m.currentpp == 0){
				moves++;
			}
		}if(moves == 4){
			return true;
		}
		return false;
	}

	private void nextAttack() {
		if(message == 0){
			if(ours.currenthp == 0 && Player.current() == null || (opponent.currenthp == 0)){
				hideAction();
				updateHealth();
				showMenu();
				inAttack = false;
				inMenu = true;
				inAction = false;
				message = 0;
				endBattle();
			}if(ours != Player.current()){
				chargeTurn = 0;
				rageCount = 1;
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
			}if(ours != Player.current()){
				chargeTurn = 0;
				rageCount = 1;
				ours = Player.current();
				hideAction();
				updateHealth();
				showMenu();
				inAttack = false;
				inMenu = true;
				inAction = false;
				message = 0;
			}else {
				youAttack();
				message = 4;
			}
		}else if(message == 3){
			if((ours.currenthp == 0 && Player.current() == null) || opponent.currenthp == 0){
				hideAction();
				updateHealth();
				showMenu();
				inAttack = false;
				inMenu = true;
				inAction = false;
				message = 0;
				endBattle();
			}if(opponent.currenthp == 0){
				hideAction();
				updateHealth();
				showMenu();
				inAttack = false;
				inMenu = true;
				inAction = false;
				message = 0;
				endBattle();
			}if(ours != Player.current()){
				chargeTurn = 0;
				rageCount = 1;
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
		chargeTurn = 0;
		rageCount = 1;
		oppChargeTurn = 0;
		oppRageCount = 1;
		inBattle = true;
	}

	public static void startTurn() {
		inAttack = false;
		message = 0;
		inAction = true;
		isFirst = ours.currentspeed >= opponent.currentspeed;
		if(isFirst){
			youAttack();
			if(playermove.action.equals("Flinch") && Math.random() < .1){
				action.setText("You used " + playermove.move + " and opponent flinched");
				message = 0;
			}else message = 1;
		}else{
			opponentAttack();
			if(oppMove.action.equals("Flinch") && Math.random() < .1){
				action.setText("Opponent used " + oppMove.move + " and you flinched");
				message = 0;
			}else message = 2;
		}
	}

	private static void endBattle() {
		hideAction();
		inBattle = false;
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

	private static void youAttack() {
		if(ours.turnsSkipped == 3){
			ours.turnsSkipped = 0;
			ours.wrapped = false;
		}
		if(ours.wrapped && ours.turnsSkipped < 3){
			ours.turnsSkipped++;
			ours.currenthp = ours.currenthp = oppfirespindmg;
			if(ours.currenthp <= 0){
				ours.currenthp = 0;
			}
			showAction();
			updateHealth();
			action.setText("You can't move");
			return;
		}
		if(opponent.currenthp == 0){
			showAction();
			action.setText("No target");
		}else if(playermove.action.equals("Skip First Turn") && chargeTurn == 0){
			showAction();
			chargeTurn++;
			action.setText("You are charging");
		}else if(opponent.wrapped && playermove.action.equals("Fire Wrap")){
			showAction();
			action.setText("Your move failed");
		}else{
			playermove.currentpp --;
			if(playermove.accuracy >= ((int) (Math.random() * 100))){
				if(playermove.physical){
					damage = (int) (((42 * playermove.power * (ours.currentattack / opponent.currentdefense)) / 50) +2);
					//System.out.println(damage);
				}else{
					damage = (int) (((42 * playermove.power * (ours.currentspecial / opponent.currentspecial)) / 50) +2);
					//System.out.println(damage);
				}
				if(playermove.action.equals("Fire Wrap")){
					opponent.skipTurn();
				}
				if(playermove.action.equals("Burn") && Math.random() < .1){
					opponent.burned();
				}
				if(playermove.action.equals("Crit") && Math.random() < .5){
					damage = damage *2;
					isCrit = true;
					//System.out.println(damage);
				}
				if(isStabUs()){
					damage = (int) (damage * 1.5);
					//System.out.println(damage);
				}
				isEffective(playermove.type, opponent.type);
				damage = (int) (damage * multiplier);
				//System.out.println(damage);
				if(playermove.action.equals("Rage")){
					damage = (int) (damage * rageCount);
					if(rageCount > 1){
						playermove.currentpp++;
					}
					rageCount += .5;
					//System.out.println(damage);
				}
				//System.out.println(damage);
				if(ours.isBurned && playermove.physical){
					damage /= 2;
					//System.out.println(damage);
				}
				if(damage < 1 && multiplier != 0){
					damage = 1;
					//System.out.println(damage);
				}
				if(playermove.action.equals("Fire Wrap")){
					opponent.skipTurn();
					firespindmg = damage;
				}
				opponent.currenthp = opponent.currenthp - damage;
				if(opponent.currenthp <= 0){
					opponent.currenthp = 0;
				}
				if(playermove.action.equals("Recoil 1/2")){
					ours.currenthp = ours.currenthp - (damage /2);
				}
				if(ours.isBurned){
					ours.currenthp -= (ours.hp /16);
				}
				if(ours.currenthp <= 0){
					ours.currenthp = 0;
				}
				chargeTurn = 0;
				showAction();
				if(multiplier < 1){
					if(isCrit){
						action.setText("Critical hit. You used " + playermove.move + ". It's was not very effective.");
					}else{
						action.setText("You used " + playermove.move + ". It's was not very effective.");
					}
				}else if(multiplier > 1){
					if(isCrit){
						action.setText("Critical hit. You used " + playermove.move + ". It's super effective.");
					}else{
						action.setText("You used " + playermove.move + ". It's super effective.");
					}
				}else{
					if(isCrit){
						action.setText("Critical hit. You used " + playermove.move);
					}else{
						action.setText("You used " + playermove.move);
					}
				}
				isCrit = false;
				updateHealth();
			}else{
				showAction();
				action.setText("You missed");
			}
		}
	}

	public static void opponentAttack() {
		if(ours.currenthp != 0){
			if(opponent.turnsSkipped == 3){
				opponent.turnsSkipped = 0;
				opponent.wrapped = false;
			}
			if(opponent.wrapped && opponent.turnsSkipped < 3){
				opponent.turnsSkipped++;
				opponent.currenthp = opponent.currenthp - firespindmg;
				if(opponent.currenthp <= 0){
					opponent.currenthp = 0;
				}
				showAction();
				updateHealth();
				action.setText("Opponent can't move");
				return;
			}
			if(oppChargeTurn == 0){
				chooseMove();
			}if(oppMove.action.equals("Skip First Turn") && oppChargeTurn == 0){
				showAction();
				oppChargeTurn++;
				action.setText("Opponent is charging");
			}else if(ours.wrapped && oppMove.action.equals("Fire Wrap")){
				showAction();
				action.setText("Opponent move failed");
			}else{
				if(oppMove.accuracy >= ((int) (Math.random() * 100)) + 1){
					if(oppMove.physical){
						damage = (int) (((42 * oppMove.power * (opponent.currentattack / ours.currentdefense)) / 50) +2);
						//System.out.println(damage);
					}else{
						damage = (int) (((42 * oppMove.power * (opponent.currentspecial / ours.currentspecial)) / 50) +2);
						//System.out.println(damage);
					}
					if(oppMove.action.equals("Burn") && Math.random() < .1){
						ours.burned();
					}
					if(oppMove.action.equals("Crit") && Math.random() < .5){
						damage = damage *2;
						isCrit = true;
						//System.out.println(damage);
					}
					if(isStabOpp()){
						damage = (int) (damage * 1.5);
						//System.out.println(damage);
					}
					isEffective(oppMove.type, ours.type);
					damage = (int) (damage * multiplier);
					//System.out.println(damage);
					if(oppMove.action.equals("Rage")){
						damage = (int) (damage * oppRageCount);
						if(oppRageCount > 1){
							oppMove.currentpp++;
						}
						oppRageCount += .5;
						//System.out.println(damage);
					}
					//System.out.println(damage);
					if(opponent.isBurned && oppMove.physical){
						damage /= 2;
						//System.out.println(damage);
					}
					if(damage < 1 && multiplier != 0){
						damage = 1;
						//System.out.println(damage);
					}
					if(oppMove.action.equals("Fire Wrap")){
						ours.skipTurn();
						oppfirespindmg = damage;
					}
					ours.currenthp = ours.currenthp - damage;
					if(ours.currenthp <= 0){
						ours.currenthp = 0;
					}
					if(oppMove.action.equals("Recoil 1/2")){
						opponent.currenthp = opponent.currenthp - (damage /2);
					}
					if(opponent.isBurned){
						opponent.currenthp -= (opponent.hp /16);
					}
					if(opponent.currenthp <= 0){
						opponent.currenthp = 0;
					}
					oppChargeTurn = 0;
					showAction();
					if(multiplier < 1){
						if(isCrit){
							action.setText("Critical hit. Opponent used " + oppMove.move + ". It's was not very effective.");
						}else{
							action.setText("Opponent used " + oppMove.move + ". It's was not very effective.");
						}
					}else if(multiplier > 1){
						if(isCrit){
							action.setText("Critical hit. Opponent used " + oppMove.move + ". It's super effective.");
						}else{
							action.setText("Opponent used " + oppMove.move + ". It's super effective.");
						}
					}else{
						if(isCrit){
							action.setText("Critical hit. Opponent used " + oppMove.move);
						}else{
							action.setText("Opponent used " + oppMove.move);
						}
					}
					isCrit = false;
					updateHealth();
				}else{
					showAction();
					action.setText("Opponent missed");
				}
			}
		}else{
			showAction();
			action.setText("No target");
		}
	}

	private static void isEffective(int type, int[] type2) {
		multiplier = 1;
		for(int t: type2){
			multiplier = multiplier * effective[type][t];
		}
	}

	private static void chooseMove() {
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
		}else if(oppRageCount > 1){
			return;
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

	private static boolean isStabUs() {
		for(int t: ours.type){
			if(t == playermove.type){
				return true;
			}	
		}
		return false;
	}

	private static boolean isStabOpp() {
		for(int t: opponent.type){
			if(t == oppMove.type){
				return true;
			}	
		}
		return false;
	}

	public static void updateHealth() {
		oppPok.setText(BattleMain.opponent.name
				+ "   " + BattleMain.opponent.currenthp
				+ "/" + BattleMain.opponent.hp
				+ "   " + BattleMain.opponent.status);
		ownPok.setText(ours.name
				+ "   " + ours.currenthp
				+ "/" + ours.hp
				+ "   " + ours.status);
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

	public static void catchPok() {
		if(opponent.currenthp < (opponent.hp / 4)){
			opponent.wrapped = false;
			Player.party.add(opponent);
			if(Player.party.size() > 6){
				Player.pc.add(Player.party.get(6));
				Player.party.remove(6);
			}
			MenuMain.partyUpdate();
			endBattle();
		}else{
			inMenu = false;
			inAction = true;
			hideMenu();
			opponentAttack();
		}
	}
}

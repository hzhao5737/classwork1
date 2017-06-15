package symposium;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import gui.Screen;
import gui.components.TextLabel;
import gui.components.Visible;

public class MenuMain extends Screen implements Runnable, KeyListener {

	public static ArrayList<TextLabel> pok;

	public MenuMain(int width, int height) {
		super(width, height);
		update();
	}

	@Override
	public void initObjects(ArrayList<Visible> v) {
		pok = new ArrayList<TextLabel>();
		pok.add(new TextLabel(100, 100, 500, 50, ""));
		pok.add(new TextLabel(100, 150, 500, 50, ""));
		pok.add(new TextLabel(100, 200, 500, 50, ""));
		pok.add(new TextLabel(100, 250, 500, 50, ""));
		pok.add(new TextLabel(100, 300, 500, 50, ""));
		pok.add(new TextLabel(100, 350, 500, 50, ""));
		v.addAll(pok);
	}

	@Override
	public void run() {
		while(true){
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void partyUpdate() {
		for(int i = 0; i < Player.party.size(); i++){
			pok.get(i).setText(i+1 + " " + Player.party.get(i).name
					+ " " + Player.party.get(i).currenthp
					+ "/" + Player.party.get(i).hp);
		}
	}

	public KeyListener getKeyListener() {
		return this;
	}

	@Override
	public void keyPressed(KeyEvent k) {
		int size = Player.party.size();
		int key = k.getKeyCode();
		if (key == KeyEvent.VK_ESCAPE) {
			if(BattleMain.inBattle){
				Symposium.game.setScreen(Symposium.battleScreen);
			}else switch(Player.screen){
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
		if (key == KeyEvent.VK_2) {
			if(BattleMain.inBattle && size > 1 && Player.party.get(1).currenthp > 0){
				Player.party.get(0).wrapped = false;
				Pok sub = Player.party.get(0);
				Player.party.set(0, Player.party.get(1));
				Player.party.set(1, sub);
				BattleMain.inMenu = false;
				BattleMain.inAction = true;
				BattleMain.hideMenu();
				BattleMain.ours = Player.current();
				BattleMain.updateHealth();
				BattleMain.opponentAttack();
				Symposium.game.setScreen(Symposium.battleScreen);
			}
			else if(size > 1 && Player.party.get(1).currenthp > 0){
				Pok sub = Player.party.get(0);
				Player.party.set(0, Player.party.get(1));
				Player.party.set(1, sub);
				partyUpdate();
			}
		}
		if (key == KeyEvent.VK_3) {
			if(BattleMain.inBattle && size > 2 && Player.party.get(2).currenthp > 0){
				Player.party.get(0).wrapped = false;
				Pok sub = Player.party.get(0);
				Player.party.set(0, Player.party.get(2));
				Player.party.set(2, sub);
				BattleMain.inMenu = false;
				BattleMain.inAction = true;
				BattleMain.hideMenu();
				BattleMain.ours = Player.current();
				BattleMain.updateHealth();
				BattleMain.opponentAttack();
				Symposium.game.setScreen(Symposium.battleScreen);
			}
			else if(size > 2 && Player.party.get(2).currenthp > 0){
				Pok sub = Player.party.get(0);
				Player.party.set(0, Player.party.get(2));
				Player.party.set(2, sub);
				partyUpdate();
			}
		}
		if (key == KeyEvent.VK_4) {
			if(BattleMain.inBattle && size > 3 && Player.party.get(3).currenthp > 0){
				Player.party.get(0).wrapped = false;
				Pok sub = Player.party.get(0);
				Player.party.set(0, Player.party.get(3));
				Player.party.set(3, sub);
				BattleMain.inMenu = false;
				BattleMain.inAction = true;
				BattleMain.hideMenu();
				BattleMain.ours = Player.current();
				BattleMain.updateHealth();
				BattleMain.opponentAttack();
				Symposium.game.setScreen(Symposium.battleScreen);
			}
			else if(size > 3 && Player.party.get(3).currenthp > 0){
				Pok sub = Player.party.get(0);
				Player.party.set(0, Player.party.get(3));
				Player.party.set(3, sub);
				partyUpdate();
			}
		}
		if (key == KeyEvent.VK_5) {
			if(BattleMain.inBattle && size > 4 && Player.party.get(4).currenthp > 0){
				Player.party.get(0).wrapped = false;
				Pok sub = Player.party.get(0);
				Player.party.set(0, Player.party.get(4));
				Player.party.set(4, sub);
				BattleMain.inMenu = false;
				BattleMain.inAction = true;
				BattleMain.hideMenu();
				BattleMain.ours = Player.current();
				BattleMain.updateHealth();
				BattleMain.opponentAttack();
				Symposium.game.setScreen(Symposium.battleScreen);
			}
			else if(size > 4 && Player.party.get(4).currenthp > 0){
				Pok sub = Player.party.get(0);
				Player.party.set(0, Player.party.get(4));
				Player.party.set(4, sub);
				partyUpdate();
			}
		}
		if (key == KeyEvent.VK_6) {
			if(BattleMain.inBattle && size > 5 && Player.party.get(5).currenthp > 0){
				Player.party.get(0).wrapped = false;
				Pok sub = Player.party.get(0);
				Player.party.set(0, Player.party.get(5));
				Player.party.set(5, sub);
				BattleMain.inMenu = false;
				BattleMain.inAction = true;
				BattleMain.hideMenu();
				BattleMain.ours = Player.current();
				BattleMain.updateHealth();
				BattleMain.opponentAttack();
				Symposium.game.setScreen(Symposium.battleScreen);
			}
			else if(size > 5 && Player.party.get(5).currenthp > 0){
				Pok sub = Player.party.get(0);
				Player.party.set(0, Player.party.get(5));
				Player.party.set(5, sub);
				partyUpdate();
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}
}

package symposium;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import gui.Screen;
import gui.components.TextLabel;
import gui.components.Visible;

public class ItemMain extends Screen implements Runnable, KeyListener {

	public static ArrayList<TextLabel> items;
	public static int ultraballs;

	public ItemMain(int width, int height) {
		super(width, height);
		update();
	}

	@Override
	public void initObjects(ArrayList<Visible> v) {
		items = new ArrayList<TextLabel>();
		ultraballs = 999;
		items.add(new TextLabel(100, 100, 500, 50, "Ultraballs x" + ultraballs));
		v.addAll(items);
	}

	public KeyListener getKeyListener() {
		return this;
	}

	public static void itemUpdate() {
		items.get(0).setText("Ultraballs x" + ultraballs);
	}

	@Override
	public void keyPressed(KeyEvent k) {
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
		}else if (key == KeyEvent.VK_1) {
			if(BattleMain.inBattle && ultraballs >= 1){
				ultraballs--;
				Symposium.game.setScreen(Symposium.battleScreen);
				BattleMain.catchPok();
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

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}
}

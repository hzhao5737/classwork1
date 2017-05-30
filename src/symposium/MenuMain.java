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
			pok.get(i).setText(Player.party.get(i).getName());
		}
	}

	public KeyListener getKeyListener() {
		return this;
	}

	@Override
	public void keyPressed(KeyEvent k) {
		int key = k.getKeyCode();
		if (key == KeyEvent.VK_ESCAPE) {
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

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}
}

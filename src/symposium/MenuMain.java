package symposium;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import gui.Screen;
import gui.components.TextLabel;
import gui.components.Visible;

public class MenuMain extends Screen implements Runnable, KeyListener {

	public static TextLabel pok0;
	public static TextLabel pok1;
	public static TextLabel pok2;
	public static TextLabel pok3;
	public static TextLabel pok4;
	public static TextLabel pok5;

	public MenuMain(int width, int height) {
		super(width, height);
		update();
	}

	@Override
	public void initObjects(ArrayList<Visible> v) {
		pok0 = new TextLabel(100, 100, 500, 50, "A");
		pok1 = new TextLabel(100, 150, 500, 50, "B");
		pok2 = new TextLabel(100, 200, 500, 50, "C");
		pok3 = new TextLabel(100, 250, 500, 50, "D");
		pok4 = new TextLabel(100, 300, 500, 50, "E");
		pok5 = new TextLabel(100, 350, 500, 50, "F");
		v.add(pok0);
		v.add(pok1);
		v.add(pok2);
		v.add(pok3);
		v.add(pok4);
		v.add(pok5);
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
		pok0.setText(Player.party.get(0).getName());
	}
	
	public KeyListener getKeyListener() {
		return this;
	}

	@Override
	public void keyPressed(KeyEvent k) {
		int key = k.getKeyCode();
		if (key == KeyEvent.VK_ESCAPE) {
			Symposium.game.setScreen(Symposium.worldScreen);
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

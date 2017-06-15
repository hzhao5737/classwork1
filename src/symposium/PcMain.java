package symposium;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import gui.Screen;
import gui.components.TextLabel;
import gui.components.Visible;

public class PcMain extends Screen implements KeyListener, Runnable {

	public static ArrayList<TextLabel> pokemon;
	public static ArrayList<TextLabel> pok;
	public static int amount;

	public PcMain(int width, int height) {
		super(width, height);
		update();
	}

	@Override
	public void initObjects(ArrayList<Visible> v) {
		pokemon = new ArrayList<TextLabel>();
		pok = new ArrayList<TextLabel>();
		pok.add(new TextLabel(500, 100, 500, 50, ""));
		pok.add(new TextLabel(500, 150, 500, 50, ""));
		pok.add(new TextLabel(500, 200, 500, 50, ""));
		pok.add(new TextLabel(500, 250, 500, 50, ""));
		pok.add(new TextLabel(500, 300, 500, 50, ""));
		pok.add(new TextLabel(500, 350, 500, 50, ""));
		pokemon.add(new TextLabel(100, 100, 500, 50, ""));
		pokemon.add(new TextLabel(100, 150, 500, 50, ""));
		pokemon.add(new TextLabel(100, 200, 500, 50, ""));
		pokemon.add(new TextLabel(100, 250, 500, 50, ""));
		pokemon.add(new TextLabel(100, 300, 500, 50, ""));
		pokemon.add(new TextLabel(100, 350, 500, 50, ""));
		pokemon.add(new TextLabel(100, 400, 500, 50, ""));
		pokemon.add(new TextLabel(100, 450, 500, 50, ""));
		pokemon.add(new TextLabel(100, 500, 500, 50, ""));
		pokemon.add(new TextLabel(100, 550, 500, 50, ""));
		pokemon.add(new TextLabel(300, 100, 500, 50, ""));
		pokemon.add(new TextLabel(300, 150, 500, 50, ""));
		pokemon.add(new TextLabel(300, 200, 500, 50, ""));
		pokemon.add(new TextLabel(300, 250, 500, 50, ""));
		pokemon.add(new TextLabel(300, 300, 500, 50, ""));
		pokemon.add(new TextLabel(300, 350, 500, 50, ""));
		pokemon.add(new TextLabel(300, 400, 500, 50, ""));
		pokemon.add(new TextLabel(300, 450, 500, 50, ""));
		pokemon.add(new TextLabel(300, 500, 500, 50, ""));
		pokemon.add(new TextLabel(300, 550, 500, 50, ""));
		v.addAll(pok);
		v.addAll(pokemon);
	}

	public KeyListener getKeyListener() {
		return this;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

	public static void updateList() {
		for(int i = 0; i < Player.pc.size(); i++){
			if(i > 19){
				return;
			}
			pokemon.get(i).setText(i+1 + " " + Player.pc.get(i).name);
		}
		for(int i = 0; i < Player.party.size(); i++){
			pok.get(i).setText(i+1 + " " + Player.party.get(i).name);
		}
	}

	@Override
	public void keyPressed(KeyEvent k) {
		int key = k.getKeyCode();
		if (key == KeyEvent.VK_ESCAPE) {
			Symposium.game.setScreen(Symposium.worldScreen);
		}
		if (key == KeyEvent.VK_Q) {
			Pok sub = Player.party.get(0);
			Player.party.set(0, Player.pc.get(0));
			Player.pc.set(0, sub);
		}
		if (key == KeyEvent.VK_W) {
			Pok sub = Player.party.get(0);
			Player.party.set(0, Player.pc.get(1));
			Player.pc.set(1, sub);
		}
		if (key == KeyEvent.VK_E) {
			Pok sub = Player.party.get(0);
			Player.party.set(0, Player.pc.get(2));
			Player.pc.set(2, sub);
		}
		if (key == KeyEvent.VK_R) {
			Pok sub = Player.party.get(0);
			Player.party.set(0, Player.pc.get(3));
			Player.pc.set(3, sub);
		}
		if (key == KeyEvent.VK_T) {
			Pok sub = Player.party.get(0);
			Player.party.set(0, Player.pc.get(4));
			Player.pc.set(4, sub);
		}
		if (key == KeyEvent.VK_Y) {
			Pok sub = Player.party.get(0);
			Player.party.set(0, Player.pc.get(5));
			Player.pc.set(5, sub);
		}
		if (key == KeyEvent.VK_U) {
			Pok sub = Player.party.get(0);
			Player.party.set(0, Player.pc.get(6));
			Player.pc.set(6, sub);
		}
		if (key == KeyEvent.VK_I) {
			Pok sub = Player.party.get(0);
			Player.party.set(0, Player.pc.get(7));
			Player.pc.set(7, sub);
		}
		if (key == KeyEvent.VK_O) {
			Pok sub = Player.party.get(0);
			Player.party.set(0, Player.pc.get(8));
			Player.pc.set(8, sub);
		}
		if (key == KeyEvent.VK_P) {
			Pok sub = Player.party.get(0);
			Player.party.set(0, Player.pc.get(9));
			Player.pc.set(9, sub);
		}
		if (key == KeyEvent.VK_A) {
			Pok sub = Player.party.get(0);
			Player.party.set(0, Player.pc.get(10));
			Player.pc.set(10, sub);
		}
		if (key == KeyEvent.VK_S) {
			Pok sub = Player.party.get(0);
			Player.party.set(0, Player.pc.get(11));
			Player.pc.set(11, sub);
		}
		if (key == KeyEvent.VK_D) {
			Pok sub = Player.party.get(0);
			Player.party.set(0, Player.pc.get(12));
			Player.pc.set(12, sub);
		}
		if (key == KeyEvent.VK_F) {
			Pok sub = Player.party.get(0);
			Player.party.set(0, Player.pc.get(13));
			Player.pc.set(13, sub);
		}
		if (key == KeyEvent.VK_G) {
			Pok sub = Player.party.get(0);
			Player.party.set(0, Player.pc.get(14));
			Player.pc.set(14, sub);
		}
		if (key == KeyEvent.VK_H) {
			Pok sub = Player.party.get(0);
			Player.party.set(0, Player.pc.get(15));
			Player.pc.set(15, sub);
		}
		if (key == KeyEvent.VK_J) {
			Pok sub = Player.party.get(0);
			Player.party.set(0, Player.pc.get(16));
			Player.pc.set(16, sub);
		}
		if (key == KeyEvent.VK_K) {
			Pok sub = Player.party.get(0);
			Player.party.set(0, Player.pc.get(17));
			Player.pc.set(17, sub);
		}
		if (key == KeyEvent.VK_L) {
			Pok sub = Player.party.get(0);
			Player.party.set(0, Player.pc.get(18));
			Player.pc.set(18, sub);
		}
		if (key == KeyEvent.VK_Z) {
			Pok sub = Player.party.get(0);
			Player.party.set(0, Player.pc.get(19));
			Player.pc.set(19, sub);
		}
		updateList();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}

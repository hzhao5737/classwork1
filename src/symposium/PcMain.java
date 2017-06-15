package symposium;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import gui.Screen;
import gui.components.TextLabel;
import gui.components.Visible;

public class PcMain extends Screen implements KeyListener, Runnable {

	public static ArrayList<TextLabel> pokemon;
	public static int amount;

	public PcMain(int width, int height) {
		super(width, height);
		update();
	}

	@Override
	public void initObjects(ArrayList<Visible> v) {
		pokemon = new ArrayList<TextLabel>();
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
		pokemon.add(new TextLabel(400, 100, 500, 50, ""));
		pokemon.add(new TextLabel(400, 150, 500, 50, ""));
		pokemon.add(new TextLabel(400, 200, 500, 50, ""));
		pokemon.add(new TextLabel(400, 250, 500, 50, ""));
		pokemon.add(new TextLabel(400, 300, 500, 50, ""));
		pokemon.add(new TextLabel(400, 350, 500, 50, ""));
		pokemon.add(new TextLabel(400, 400, 500, 50, ""));
		pokemon.add(new TextLabel(400, 450, 500, 50, ""));
		pokemon.add(new TextLabel(400, 500, 500, 50, ""));
		pokemon.add(new TextLabel(400, 550, 500, 50, ""));
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
	}

	@Override
	public void keyPressed(KeyEvent k) {
		int key = k.getKeyCode();
		if (key == KeyEvent.VK_ESCAPE) {
			Symposium.game.setScreen(Symposium.worldScreen);
		}
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

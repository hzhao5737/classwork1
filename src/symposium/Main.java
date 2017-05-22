package symposium;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import gui.Screen;
import gui.components.TextLabel;
import gui.components.Visible;

public class Main extends Screen implements Runnable, KeyListener{

	private ArrayList<CustomTextLabel> intro;

	public Main(int width, int height) {
		super(width, height);
		Thread play = new Thread(this);
		play.start();
	}

	@Override
	public void initObjects(ArrayList<Visible> view) {
		intro = new ArrayList<CustomTextLabel>();
		intro.add(new CustomTextLabel(240, 240, 250, 30, "Press Any Key To Begin",Color.white));
		view.addAll(intro);
	}

	public void drawBackground(Graphics2D g){
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getImage().getWidth(), getImage().getHeight());
	}

	@Override
	public void run() {
		while(true){
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			update();
		}
	}

	public KeyListener getKeyListener() {
		return this;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		Symposium.game.setScreen(Symposium.worldScreen);
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

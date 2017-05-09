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

	private TextLabel intro;

	public Main(int width, int height) {
		super(width, height);
		Thread start = new Thread(this);
		start.start();
	}

	@Override
	public void initObjects(ArrayList<Visible> view) {
		intro = new CustomTextLabel(225, 200, 250, 30, "Press Any Key To Begin",Color.white);
		view.add(intro);
	}

	public void drawBackground(Graphics2D g){
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getImage().getWidth(), getImage().getHeight());
	}

	@Override
	public void run() {
		
	}

	public KeyListener getKeyListener() {
		return this;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_SPACE){
			System.out.println("Key pressed code=" + e.getKeyCode() + ", char=" + e.getKeyChar());
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

package symposium;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import gui.Screen;
import gui.components.TextLabel;
import gui.components.Visible;

public class Main extends Screen implements Runnable{

	private TextLabel intro;
	private KeyListener listener;

	public Main(int width, int height) {
		super(width, height);
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
		while(true){
			listener = new KeyListener() {
				@Override
				public void keyTyped(KeyEvent e) {
				}

				@Override
				public void keyPressed(KeyEvent e) {
					System.out.println("Key pressed code=" + e.getKeyCode() + ", char=" + e.getKeyChar());
					//Symposium.game.setScreen(Symposium.worldScreen);
				}

				@Override
				public void keyReleased(KeyEvent e) {
				}
			};
		}
	}
}

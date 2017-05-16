package symposium;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import gui.Screen;
import gui.components.Component;
import gui.components.Visible;

public class WorldMain extends Screen implements Runnable, KeyListener{
	
	private static final int DOWN = 0;
	private static final int LEFT = 1;
	private static final int UP = 2;
	private static final int RIGHT = 3;
	private static ArrayList<Background> back;
	public static ArrayList<Front> fore;
	public Player player;
	
	public WorldMain(int width, int height) {
		super(width, height);
		Player.screen = 0;
		Thread play = new Thread(this);
		play.start();
		update();
	}

	@Override
	public void initObjects(ArrayList<Visible> v) {
		back = new ArrayList<Background>();
		fore = new ArrayList<Front>();
		back.add(new Background(0,20,720,720,0));
		fore.add(new Front(36,60,36,40,0));
		fore.add(new Front(72,60,36,40,0));
		fore.add(new Front(108,60,36,40,0));
		fore.add(new Front(144,60,36,40,0));
		fore.add(new Front(180,60,36,40,0));
		fore.add(new Front(216,60,36,40,0));
		fore.add(new Front(252,60,36,40,0));
		fore.add(new Front(288,60,36,40,0));
		fore.add(new Front(324,60,36,40,0));
		fore.add(new Front(324,20,36,40,0));
		fore.add(new Front(72,700,36,40,0));
		fore.add(new Front(108,700,36,40,0));
		v.addAll(back);
		v.addAll(fore);
		player = new Player(180,260,36,40,DOWN);
		v.add(player);
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
	public void keyPressed(KeyEvent k) {
		int key = k.getKeyCode();
		if (key == KeyEvent.VK_DOWN) {
			player.setPos(DOWN);
			player.update();
	        player.move();
	    }
		if (key == KeyEvent.VK_LEFT) {
			player.setPos(LEFT);
			player.update();
	        player.move();
	    }
		if (key == KeyEvent.VK_UP) {
			player.setPos(UP);
			player.update();
	        player.move();
	    }
		if (key == KeyEvent.VK_RIGHT) {
			player.setPos(RIGHT);
			player.update();
	        player.move();
	    }
	}

	@Override
	public void keyReleased(KeyEvent k) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent k) {
		// TODO Auto-generated method stub
		
	}
}

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
	public static ArrayList<Background> back;
	public Player player;
	
	public WorldMain(int width, int height) {
		super(width, height);
		Thread play = new Thread(this);
		play.start();
		update();
	}

	@Override
	public void initObjects(ArrayList<Visible> v) {
		back = new ArrayList<Background>();
		back.add(new Background(0,0,640,480,0));
		back.add(new Background(64,456,32,24,1));
		back.add(new Background(96,456,32,24,1));
		v.addAll(back);
		player = new Player(160,160,32,24,DOWN);
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
	        player.move();
	    }
		if (key == KeyEvent.VK_LEFT) {
			player.setPos(LEFT);
	        player.move();
	    }
		if (key == KeyEvent.VK_UP) {
			player.setPos(UP);
	        player.move();
	    }
		if (key == KeyEvent.VK_RIGHT) {
			player.setPos(RIGHT);
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

package symposium;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import gui.Screen;
import gui.components.Visible;

public class LabMain extends Screen implements Runnable, KeyListener{
	
	private static final int DOWN = 0;
	private static final int LEFT = 1;
	private static final int UP = 2;
	private static final int RIGHT = 3;
	private static ArrayList<Background> back;
	public static ArrayList<Front> fore;
	public static ArrayList<Door> door;

	public LabMain(int width, int height) {
		super(width, height);
		update();
	}
	
	public void drawBackground(Graphics2D g){
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getImage().getWidth(), getImage().getHeight());
	}

	@Override
	public void initObjects(ArrayList<Visible> v) {
		back = new ArrayList<Background>();
		fore = new ArrayList<Front>();
		door = new ArrayList<Door>();
		back.add(new Background(0, 20, 360, 480, 2));
		back.add(new Background(180, 460, 36, 40, 3));
		v.addAll(back);
		v.addAll(fore);
		v.addAll(door);
		v.add(WorldMain.player);
	}

	public KeyListener getKeyListener() {
		return this;
	}
	
	@Override
	public void keyPressed(KeyEvent k) {
		int key = k.getKeyCode();
		if (key == KeyEvent.VK_DOWN) {
			WorldMain.player.setPos(DOWN);
			WorldMain.player.update();
			WorldMain.player.move();
	    }
		if (key == KeyEvent.VK_LEFT) {
			WorldMain.player.setPos(LEFT);
			WorldMain.player.update();
			WorldMain.player.move();
	    }
		if (key == KeyEvent.VK_UP) {
			WorldMain.player.setPos(UP);
			WorldMain.player.update();
			WorldMain.player.move();
	    }
		if (key == KeyEvent.VK_RIGHT) {
			WorldMain.player.setPos(RIGHT);
			WorldMain.player.update();
			WorldMain.player.move();
	    }
		if (key == KeyEvent.VK_ENTER) {
			WorldMain.player.act();
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
		while(true){
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//update();
		}
	}
}

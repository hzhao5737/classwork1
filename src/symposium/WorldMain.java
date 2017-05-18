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
import gui.components.Button;
import gui.components.Component;
import gui.components.TextLabel;
import gui.components.Visible;

public class WorldMain extends Screen implements Runnable, KeyListener{
	
	private static final int DOWN = 0;
	private static final int LEFT = 1;
	private static final int UP = 2;
	private static final int RIGHT = 3;
	private static ArrayList<Background> back;
	public static ArrayList<Front> fore;
	public static ArrayList<Door> door;
	public static ArrayList<Interact> act;
	public static Player player;
	public static TextLabel text;
	private Button box;
	
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
		door = new ArrayList<Door>();
		act = new ArrayList<Interact>();
		back.add(new Background(0,20,720,720,0));
		back.add(new Background(108,220,36,40,1));
		back.add(new Background(396,220,36,40,1));
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
		fore.add(new Front(432,20,36,40,0));
		fore.add(new Front(432,60,36,40,0));
		fore.add(new Front(468,60,36,40,0));
		fore.add(new Front(504,60,36,40,0));
		fore.add(new Front(540,60,36,40,0));
		fore.add(new Front(576,60,36,40,0));
		fore.add(new Front(612,60,36,40,0));
		fore.add(new Front(648,60,36,40,0));
		fore.add(new Front(72,700,36,40,0));
		fore.add(new Front(108,700,36,40,0));
		fore.add(new Front(144,580,144,160,1));
		fore.add(new Front(144,380,36,40,2));
		fore.add(new Front(180,380,36,40,2));
		fore.add(new Front(216,380,36,40,2));
		fore.add(new Front(252,380,36,40,2));
		fore.add(new Front(360,540,36,40,2));
		fore.add(new Front(396,540,36,40,2));
		fore.add(new Front(432,540,36,40,2));
		fore.add(new Front(468,540,36,40,2));
		fore.add(new Front(504,540,36,40,2));
		fore.add(new Front(540,540,36,40,2));
		fore.add(new Front(144,140,144,120,3));
		fore.add(new Front(432,140,144,120,3));
		fore.add(new Front(360,340,216,160,4));
		door.add(new Door(432,460,36,40,0));
		act.add(new Interact(180,220,36,40,0));
		v.addAll(back);
		v.addAll(fore);
		v.addAll(door);
		v.addAll(act);
		player = new Player(180,260,36,40,DOWN);
		v.add(player);
		box = new Button(36, 680, 650, 50, null, null, null);
		v.add(box);
		text = new TextLabel(36, 680, 648, 40, "");
		v.add(text);
		//v.remove(v.size()-1);
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
		if (key == KeyEvent.VK_ENTER) {
			player.act();
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

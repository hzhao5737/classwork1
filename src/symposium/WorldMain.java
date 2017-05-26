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
	public static ArrayList<TextLabel> menuText;
	public static Button box;
	public static Button menu;

	public WorldMain(int width, int height) {
		super(width, height);
		update();
	}

	@Override
	public void initObjects(ArrayList<Visible> v) {
		back = new ArrayList<Background>();
		fore = new ArrayList<Front>();
		door = new ArrayList<Door>();
		act = new ArrayList<Interact>();
		menuText = new ArrayList<TextLabel>();
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
		act.add(new Interact(468,220,36,40,0));
		v.addAll(back);
		v.addAll(fore);
		v.addAll(door);
		v.addAll(act);
		player = new Player(180,260,36,40,DOWN);
		v.add(player);
		box = new Button(36, 680, 650, 50, null, null, null);
		box.setVisible(false);
		menu = new Button(524, 40, 160, 200, null, null, null);
		menu.setVisible(false);
		v.add(box);
		v.add(menu);
		text = new TextLabel(36, 680, 648, 40, "");
		menuText.add(new TextLabel(550, 80, 160, 40, "POKEMON"));
		menuText.add(new TextLabel(550, 120, 160, 40, "ITEM"));
		menuText.add(new TextLabel(550, 160, 160, 40, "EXIT"));
		for(TextLabel t : menuText){
			t.setVisible(false);
		}
		v.addAll(menuText);
		v.add(text);
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
		if(Player.isMenu){
			if (key == KeyEvent.VK_1){
				Symposium.game.setScreen(Symposium.infoScreen);
			}
			if (key == KeyEvent.VK_2){
				Symposium.game.setScreen(Symposium.infoScreen);
			}
			if (key == KeyEvent.VK_3){
				player.menuClose();
			}
		}
		if(Player.moveable){
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
				player.act0();
			}
			if (key == KeyEvent.VK_SPACE) {
				player.menu();
			}
		}else{
			if (key == KeyEvent.VK_ENTER) {
				player.menuAct();
			}
			if (key == KeyEvent.VK_SPACE) {
				player.menuClose();
			}
			if (key == KeyEvent.VK_ESCAPE) {
				player.endText();
			}
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

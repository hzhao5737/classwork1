package symposium;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import gui.Screen;
import gui.components.Button;
import gui.components.TextLabel;
import gui.components.Visible;

public class LabMain extends Screen implements Runnable, KeyListener{

	private static final int DOWN = 0;
	private static final int LEFT = 1;
	private static final int UP = 2;
	private static final int RIGHT = 3;
	private static ArrayList<Background> back;
	public static ArrayList<Front> fore;
	public static ArrayList<Door> door;
	public static ArrayList<Interact> act;
	public static ArrayList<BallWorld> balls;
	public static TextLabel text;
	public static ArrayList<TextLabel> menuText;
	public static Button box;
	public static Button menu;


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
		balls = new ArrayList<BallWorld>();
		menuText = new ArrayList<TextLabel>();
		act = new ArrayList<Interact>();
		back.add(new Background(0, 20, 360, 480, 2));
		back.add(new Background(180, 460, 36, 40, 3));
		fore.add(new Front(0, 260, 144, 80, 5));
		fore.add(new Front(216, 260, 144, 80, 5));
		fore.add(new Front(216, 20, 144, 80, 5));
		fore.add(new Front(216, 140, 108, 40, 6));
		fore.add(new Front(0, 60, 144, 40, 7));
		fore.add(new Front(144, 100, 36, 40, 8));
		door.add(new Door(144, 500, 36, 40, 1));
		balls.add(new BallWorld(216, 140, 36, 40, 0));
		balls.add(new BallWorld(252, 140, 36, 40, 1));
		balls.add(new BallWorld(288, 140, 36, 40, 2));
		act.add(new Interact(144, 100, 36, 40, 1));
		v.addAll(back);
		v.addAll(fore);
		v.addAll(door);
		v.addAll(balls);
		v.addAll(act);
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
		v.add(WorldMain.player);
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
				WorldMain.player.menuClose();
			}
		}
		if(Player.moveable){
			if (key == KeyEvent.VK_DOWN) {
				WorldMain.player.setPos(DOWN);
				WorldMain.player.update();
				WorldMain.player.move(DOWN);
			}
			if (key == KeyEvent.VK_LEFT) {
				WorldMain.player.setPos(LEFT);
				WorldMain.player.update();
				WorldMain.player.move(LEFT);
			}
			if (key == KeyEvent.VK_UP) {
				WorldMain.player.setPos(UP);
				WorldMain.player.update();
				WorldMain.player.move(UP);
			}
			if (key == KeyEvent.VK_RIGHT) {
				WorldMain.player.setPos(RIGHT);
				WorldMain.player.update();
				WorldMain.player.move(RIGHT);
			}
			if (key == KeyEvent.VK_ENTER) {
				WorldMain.player.act1();
			}
			if (key == KeyEvent.VK_SPACE) {
				WorldMain.player.menu();
			}
		}else{
			if (key == KeyEvent.VK_ENTER) {
				WorldMain.player.menuAct();
			}
			if (key == KeyEvent.VK_SPACE) {
				WorldMain.player.menuClose();
			}
			if (key == KeyEvent.VK_ESCAPE) {
				WorldMain.player.endText();
			}
		}
		if(Player.isChoose){
			if (key == KeyEvent.VK_1) {
				WorldMain.player.selectBall();
				WorldMain.player.endText();
			}
			if (key == KeyEvent.VK_2) {
				WorldMain.player.endText();
			}
			if (key == KeyEvent.VK_ESCAPE) {
				WorldMain.player.endText();
			}
		}
		update();
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

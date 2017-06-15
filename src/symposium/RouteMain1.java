package symposium;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import gui.Screen;
import gui.components.Button;
import gui.components.TextLabel;
import gui.components.Visible;

public class RouteMain1 extends Screen implements Runnable, KeyListener{

	private static final int DOWN = 0;
	private static final int LEFT = 1;
	private static final int UP = 2;
	private static final int RIGHT = 3;
	private static ArrayList<Background> back;
	public static ArrayList<Front> fore;
	public static ArrayList<Door> door;
	public static ArrayList<Grass> grass;
	public static TextLabel text;
	public static ArrayList<TextLabel> menuText;
	public static Button box;
	public static Button menu;
	
	public RouteMain1(int width, int height) {
		super(width, height);
		update();
	}

	@Override
	public void initObjects(ArrayList<Visible> v) {
		back = new ArrayList<Background>();
		fore = new ArrayList<Front>();
		door = new ArrayList<Door>();
		grass = new ArrayList<Grass>();
		menuText = new ArrayList<TextLabel>();
		back.add(new Background(0, 20, 576, 600, 4));
		grass.add(new Grass(288, 540, 36, 40));
		grass.add(new Grass(324, 500, 36, 40));
		grass.add(new Grass(360, 500, 36, 40));
		grass.add(new Grass(396, 500, 36, 40));
		grass.add(new Grass(432, 500, 36, 40));
		grass.add(new Grass(144, 500, 36, 40));
		grass.add(new Grass(108, 500, 36, 40));
		grass.add(new Grass(72, 500, 36, 40));
		grass.add(new Grass(36, 500, 36, 40));
		grass.add(new Grass(324, 460, 36, 40));
		grass.add(new Grass(360, 460, 36, 40));
		grass.add(new Grass(396, 460, 36, 40));
		grass.add(new Grass(432, 460, 36, 40));
		grass.add(new Grass(144, 460, 36, 40));
		grass.add(new Grass(108, 460, 36, 40));
		grass.add(new Grass(72, 460, 36, 40));
		grass.add(new Grass(36, 460, 36, 40));
		grass.add(new Grass(468, 420, 36, 40));
		grass.add(new Grass(504, 420, 36, 40));
		grass.add(new Grass(396, 420, 36, 40));
		grass.add(new Grass(432, 420, 36, 40));
		grass.add(new Grass(144, 420, 36, 40));
		grass.add(new Grass(108, 420, 36, 40));
		grass.add(new Grass(216, 420, 36, 40));
		grass.add(new Grass(180, 420, 36, 40));
		grass.add(new Grass(468, 380, 36, 40));
		grass.add(new Grass(504, 380, 36, 40));
		grass.add(new Grass(396, 380, 36, 40));
		grass.add(new Grass(432, 380, 36, 40));
		grass.add(new Grass(144, 380, 36, 40));
		grass.add(new Grass(108, 380, 36, 40));
		grass.add(new Grass(216, 380, 36, 40));
		grass.add(new Grass(180, 380, 36, 40));
		grass.add(new Grass(324, 260, 36, 40));
		grass.add(new Grass(324, 220, 36, 40));
		grass.add(new Grass(324, 180, 36, 40));
		grass.add(new Grass(324, 140, 36, 40));
		grass.add(new Grass(360, 260, 36, 40));
		grass.add(new Grass(360, 220, 36, 40));
		grass.add(new Grass(360, 180, 36, 40));
		grass.add(new Grass(360, 140, 36, 40));
		grass.add(new Grass(396, 260, 36, 40));
		grass.add(new Grass(396, 220, 36, 40));
		grass.add(new Grass(396, 180, 36, 40));
		grass.add(new Grass(396, 140, 36, 40));
		grass.add(new Grass(432, 260, 36, 40));
		grass.add(new Grass(432, 220, 36, 40));
		grass.add(new Grass(432, 180, 36, 40));
		grass.add(new Grass(432, 140, 36, 40));
		fore.add(new Front(36,540,36,40,0));
		fore.add(new Front(72,540,36,40,0));
		fore.add(new Front(108,540,36,40,0));
		fore.add(new Front(144,540,36,40,0));
		fore.add(new Front(180,540,36,40,0));
		fore.add(new Front(216,540,36,40,0));
		fore.add(new Front(252,540,36,40,0));
		fore.add(new Front(252,580,36,40,0));
		fore.add(new Front(324,580,36,40,0));
		fore.add(new Front(324,540,36,40,0));
		fore.add(new Front(360,540,36,40,0));
		fore.add(new Front(396,540,36,40,0));
		fore.add(new Front(432,540,36,40,0));
		fore.add(new Front(468,540,36,40,0));
		fore.add(new Front(504,540,36,40,0));
		fore.add(new Front(36,340,36,40,0));
		fore.add(new Front(72,340,36,40,0));
		fore.add(new Front(216,340,36,40,0));
		fore.add(new Front(252,340,36,40,0));
		fore.add(new Front(288,340,36,40,0));
		fore.add(new Front(324,340,36,40,0));
		fore.add(new Front(360,340,36,40,0));
		fore.add(new Front(396,340,36,40,0));
		fore.add(new Front(432,340,36,40,0));
		fore.add(new Front(432,340,36,40,0));
		fore.add(new Front(468,340,36,40,0));
		fore.add(new Front(504,340,36,40,0));
		fore.add(new Front(36,180,36,40,0));
		fore.add(new Front(72,180,36,40,0));
		fore.add(new Front(108,180,36,40,0));
		fore.add(new Front(144,180,36,40,0));
		fore.add(new Front(180,180,36,40,0));
		fore.add(new Front(216,180,36,40,0));
		fore.add(new Front(252,180,36,40,0));
		fore.add(new Front(288,180,36,40,0));
		fore.add(new Front(468,180,36,40,0));
		fore.add(new Front(504,180,36,40,0));
		fore.add(new Front(72,20,36,40,0));
		fore.add(new Front(216,20,36,40,0));
		door.add(new Door(288, 580, 36, 40, 3));
		v.addAll(back);
		v.addAll(grass);
		v.addAll(fore);
		v.addAll(door);
		v.add(WorldMain.player);
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

	public KeyListener getKeyListener() {
		return this;
	}
	
	@Override
	public void keyPressed(KeyEvent k) {
		int key = k.getKeyCode();
		if(Player.isMenu){
			if (key == KeyEvent.VK_1){
				MenuMain.partyUpdate();
				Symposium.game.setScreen(Symposium.infoScreen);
			}
			if (key == KeyEvent.VK_2){
				ItemMain.itemUpdate();
				Symposium.game.setScreen(Symposium.itemScreen);
			}
			if (key == KeyEvent.VK_3){
				WorldMain.player.endText();
			}
			if (key == KeyEvent.VK_ESCAPE) {
				WorldMain.player.endText();
			}
			if (key == KeyEvent.VK_SPACE) {
				WorldMain.player.endText();
			}
		}else if(Player.moveable){
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
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}

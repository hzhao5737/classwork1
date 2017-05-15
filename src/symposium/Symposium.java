package symposium;

import gui.GUIApplication;
import gui.Screen;

public class Symposium extends GUIApplication {
	
	public static Screen mainMenu;
	public static Screen worldScreen;
	public static Screen battleScreen;
	public static Symposium game;

	public Symposium(int width, int height) {
		super(width, height);
	}

	public static void main(String[] args) {
		game = new Symposium(720,760);
		Thread on = new Thread(game);
		on.start();
	}

	@Override
	public void initScreen() {
		worldScreen = new WorldMain(getWidth(),getHeight());
		battleScreen = new BattleMain(getWidth(),getHeight());
		mainMenu = new Main(getWidth(),getHeight());
		setScreen(mainMenu);
	}

}

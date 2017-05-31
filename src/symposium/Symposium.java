package symposium;

import gui.GUIApplication;
import gui.Screen;

public class Symposium extends GUIApplication {
	
	public static Screen infoScreen;
	public static Screen mainMenu;
	public static Screen worldScreen;
	public static Screen labScreen;
	public static Screen routeScreen1;
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
		battleScreen = new BattleMain(getWidth(),getHeight());
		infoScreen = new MenuMain(getWidth(),getHeight());
		worldScreen = new WorldMain(getWidth(),getHeight());
		labScreen = new LabMain(getWidth(),getHeight());
		mainMenu = new Main(getWidth(),getHeight());
		routeScreen1 = new RouteMain1(getWidth(),getHeight());
		setScreen(mainMenu);
	}

}

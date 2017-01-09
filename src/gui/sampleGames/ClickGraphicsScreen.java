package gui.sampleGames;

import gui.GUIApplication;

public class ClickGraphicsScreen extends GUIApplication{

	public ClickGraphicsScreen() {
		super(500,500);
	}

	public static void main(String[] args) {
		ClickGraphicsScreen cgg = new ClickGraphicsScreen();
		Thread app = new Thread(cgg);
		app.start();
	}

	@Override
	public void initScreen() {
		GraphicsClickScreen gcs = new GraphicsClickScreen(getWidth(), getHeight());
//		MyPracticeClickableScreen pcs = new MyPracticeClickableScreen(getWidth(), getHeight());
		setScreen(gcs);
	}
	
	
	
	
	
	
	
	
	

}
package gui.sampleGames;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import gui.Screen;
import gui.components.Action;
import gui.components.Button;
import gui.components.Graphic;
import gui.components.Visible;

public class MyScreen extends Screen implements MouseMotionListener{
	
	private Graphic bowser;
	private Button button;

	public MyScreen(int width, int height) {
		super(width, height);
	}

	@Override
	public void initObjects(ArrayList<Visible> viewObjects) {
		bowser = new Graphic(100, 30, 100, 100, "resources/sampleImages/bowser.png");
		viewObjects.add(bowser);
		button = new Button(20,100,80,40,"Button",new Color(100,100,250), new Action() {
			public void act(){
				MouseFollower.game.setScreen(MouseFollower.moveScreen);
			}
		});
		viewObjects.add(button);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}

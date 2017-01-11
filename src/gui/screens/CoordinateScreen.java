package gui.screens;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import gui.Screen;
import gui.components.Action;
import gui.components.Button;
import gui.components.Graphic;
import gui.components.MovingComponent;
import gui.components.TextArea;
import gui.components.TextLabel;
import gui.components.Visible;
import gui.sampleGames.MouseFollower;

public class CoordinateScreen extends Screen implements MouseMotionListener, MouseListener {
	
	//FIELD
	private Button button;
	private TextLabel text;
	private TextArea area;
	private Graphic bowser;

	public CoordinateScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initObjects(ArrayList<Visible> viewObjects) {
		button = new Button(20,100,80,40,"Button",new Color(100,100,250), new Action() {
			public void act(){
				MouseFollower.game.setScreen(MouseFollower.moveScreen);
			}
		});
		viewObjects.add(button);
		text = new TextLabel(20, 200, 500, 40, "Some text");
		viewObjects.add(text);
		area = new TextArea(20,300,300,100,"This is really long text. It prints over multiple lines, as you can see.");
		viewObjects.add(area);
		bowser = new Graphic(30,400,.5, "resources/sampleImages/bowser.png");
		viewObjects.add(bowser);
		MovingComponent c = new MovingComponent(20, 20,100, 100);
		viewObjects.add(c);
		c.setVy(2);
		c.setVx(1);
		c.play();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		int mx = e.getX();//get mouse X coordinate
		int my = e.getY();//get mouse Y coordinate
		text.setText("Mouse at: "+mx+", "+my);
	}
	
	public MouseListener getMouseListener(){
		return this;
	}

	@Override
	public void mouseClicked(MouseEvent m) {
		if(button.isHovered(m.getX(), m.getY())){
			button.act();
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}

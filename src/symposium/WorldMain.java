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
import gui.components.Visible;

public class WorldMain extends Screen implements Runnable, KeyListener{
	
	private Background background;
	private Background block;
	private Background block1;

	public WorldMain(int width, int height) {
		super(width, height);
		Thread play = new Thread(this);
		play.start();
	}

	@Override
	public void initObjects(ArrayList<Visible> v) {
		background = new Background(0,0,640,480,0);
		v.add(background);
		block = new Background(64,456,32,24,1);
		v.add(block);
		block1 = new Background(96,456,32,24,1);
		v.add(block1);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}

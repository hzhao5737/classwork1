package symposium;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;

import gui.Screen;
import gui.components.Visible;

public class WorldMain extends Screen {
	
	private Background img;

	public WorldMain(int width, int height) {
		super(width, height);
	}

	@Override
	public void initObjects(ArrayList<Visible> v) {
		img = new Background(0,0,640,480,0);
		v.add(img);
	}
}

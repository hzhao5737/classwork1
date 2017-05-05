package symposium;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

import gui.Screen;
import gui.components.TextLabel;
import gui.components.Visible;

public class Main extends Screen {
	
	private TextLabel intro;

	public Main(int width, int height) {
		super(width, height);
	}

	@Override
	public void initObjects(ArrayList<Visible> view) {
		intro = new TextLabel(320, 240, 50, 10, "Press Any Key To Begin");
		view.add(intro);
	}
	
	public void drawBackground(Graphics2D g){
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getImage().getWidth(), getImage().getHeight());
	}
}

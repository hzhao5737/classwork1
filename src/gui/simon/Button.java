package gui.simon;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.RenderingHints;

import gui.components.Action;
import gui.components.Component;

public class Button extends Component implements ButtonInterfaceHunter {

	private Action action;
	private Color c;
	private Color displayColor;
	private boolean isHighlighted;
	private String name;
	private int x;
	private int y;

	public Button() {
		super(0, 0, 50, 50);
	}

	@Override
	public void act() {
		action.act();
	}

	@Override
	public boolean isHovered(int x, int y) {
		double distance = Math.sqrt(Math.pow(x-(getX()+25), 2)+Math.pow(y-(getY()+25), 2));
		return distance < 25;
	}

	@Override
	public void update(Graphics2D g) {
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		if(displayColor != null){
			g.setColor(displayColor);
		}
		else g.setColor(Color.gray);
		g.fillOval(0, 0, 50, 50);
		g.setColor(Color.black);
		g.drawOval(0, 0, 49, 49);
		if(isHighlighted){
			g.setColor(Color.white);
			Polygon p = new Polygon();
			int s = (int)(31.25);
			int t = (int)(10)+4;
			p.addPoint(s-4, t-4);
			p.addPoint(s+7, t-2);
			p.addPoint(s+10, t);
			p.addPoint(s+14, t+10);
			p.addPoint(s+12, t+14);
			p.addPoint(s+8, t+3);
			g.fill(p);
		}
	}

	@Override
	public void setColor(Color color) {
		this.c = color;
		displayColor = c;
		update();
	}

	@Override
	public void highlight() {
		if(c != null){
			displayColor = c;
		}
		isHighlighted = true;
		update();
	}

	@Override
	public void dim() {
		displayColor = Color.gray;
		isHighlighted = false;
		update();
	}

	@Override
	public void setAction(Action action) {
		this.action = action;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void setX(int i) {
		this.x = i;
	}

	@Override
	public void setY(int i) {
		this.y = i;
	}
}
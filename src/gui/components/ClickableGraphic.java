package gui.components;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ClickableGraphic extends Graphic implements Clickable, MouseListener {
	
	private Action action;

	public ClickableGraphic(int x, int y, String imageLocation) {
		super(x, y, imageLocation);
		// TODO Auto-generated constructor stub
	}

	public ClickableGraphic(int x, int y, int w, int h, String imageLocation) {
		super(x, y, w, h, imageLocation);
		// TODO Auto-generated constructor stub
	}

	public ClickableGraphic(int x, int y, double scale, String imageLocation) {
		super(x, y, scale, imageLocation);
		// TODO Auto-generated constructor stub
	}
	
	public void setAction(Action a){
		this.action = a;
	}

	public boolean isHovered(int x, int y) {
		return (getX() < x && x < getX()+getWidth() && getY() < y && y < getY()+getHeight());
	}

	public void act() {
		if(action != null){
			action.act();
		}
	}

	@Override
	public void mouseClicked(MouseEvent m) {
		if(isHovered(m.getX(), m.getY())){
			act();
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

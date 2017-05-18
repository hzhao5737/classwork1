package gui.components;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public abstract class Component implements Visible {

	//FIELDS
	private int x;
	private int y;
	private int w;
	private int h;
	private BufferedImage image;
	private boolean visible;
	
	public Component(int x, int y, int w, int h) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		visible = true;
		this.image = new BufferedImage(w,h,BufferedImage.TYPE_INT_ARGB);
		update(image.createGraphics());
	}

	public BufferedImage getImage() {
		return image;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getWidth() {
		return w;
	}

	public int getHeight() {
		return h;
	}

	public boolean isAnimated() {
		return false;
	}

	public void update() {
		update(image.createGraphics());
	}
	
	public abstract void update(Graphics2D g);

	//deletes image to start over
	public Graphics2D clear(){
		image = new BufferedImage(w,h,BufferedImage.TYPE_INT_ARGB);
		return image.createGraphics();
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public boolean isVisible(){
		return visible;
	}
	
	public void setVisible(boolean b){
		visible = b;
	}
}

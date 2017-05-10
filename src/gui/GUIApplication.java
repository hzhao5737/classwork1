package gui;

import java.awt.Graphics;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;

public abstract class GUIApplication extends JFrame implements Runnable {
	
	//FIELDS
	private Screen currentScreen;
	
	/*demo purposes only
	public static void main(String[] args) {
		new GUIApplication(800,600);
	}
	*/

	public GUIApplication(int width, int height){
		super();
		//setUndecorated(true);
		setBounds(20,20,width, height);
		//terminates program when window is closed
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initScreen();
		setVisible(true);
	}

	public abstract void initScreen();
	
	public void paint(Graphics g){
		g.drawImage(currentScreen.getImage(), 0, 0, null);
	}
	
	public void setScreen(Screen s){
		//stop listening to previous screen
		if(currentScreen != null){
			MouseListener ml = currentScreen.getMouseListener();
			if(ml != null){
				removeMouseListener(ml);
			}
			MouseMotionListener mml = currentScreen.getMouseMotionListener();
			if(mml != null){
				removeMouseMotionListener(mml);
			}
			KeyListener kl = currentScreen.getKeyListener();
			if(kl != null){
				removeKeyListener(kl);
			}
		}
		currentScreen = s;
		//start listening to new screen
		if(currentScreen != null){
			addMouseListener(currentScreen.getMouseListener());
			addMouseMotionListener(currentScreen.getMouseMotionListener());
			addKeyListener(currentScreen.getKeyListener());
		}
	}
	
	public void run(){
		while(true){
			//redraws display
			currentScreen.update();
			//update window
			repaint();
			try {
				Thread.sleep(30);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

/*Abstraction
 * interface- implement as many interfaces as you want
 * 		description of methods
 * abstract class- only extend one class
 * 		descriptions of methods
 * 		methods- only useful to subclasses that inherit this class */
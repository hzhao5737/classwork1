package gui.simon;

import java.util.ArrayList;
import java.util.List;

import gui.components.TextLabel;
import gui.components.Visible;
import gui.screens.ClickableScreen;

public class SimonScreenHunter extends ClickableScreen implements Runnable {

	//private ProgressInterface progress;
	private ArrayList<MoveInterfaceHunter> moves;
	private int roundNumber;
	private boolean isUserTurn;
	private TextLabel roundLabel;
	private TextLabel label;
	
	public SimonScreenHunter(int width, int height) {
		super(width, height);
		Thread play = new Thread(this);
		play.start();
	}
	
	@Override
	public void run() {
		changeText("Your turn");
		label.setText("");
	}
	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		moves = new ArrayList<MoveInterfaceHunter>();
		label = new TextLabel(350,220,150,40,"Simon's turn");
		viewObjects.add(label);
	}
	
	private void changeText(String string) {
		label.setText(string);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

package gui.simon;

import java.util.ArrayList;
import java.util.List;

import gui.components.TextLabel;
import gui.components.Visible;
import gui.screens.ClickableScreen;

public class SimonScreenHunter extends ClickableScreen implements Runnable {

	private ProgressInterface progress;
	private ButtonInterfaceHunter[] button;
	private ArrayList<MoveInterfaceHunter> moves;
	private TextLabel label;
	private int roundNumber;
	private boolean isUserTurn;
	private int sequenceIndex;
	private int lastSelectedButton;
	
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
		addButtons();
		progress = getProgress();
		label = new TextLabel(130,230,300,40,"Let's play Simon!");
		moves = new ArrayList<MoveInterfaceHunter>();
		//add 2 moves to start
		lastSelectedButton = -1;
		moves.add(randomMove());
		moves.add(randomMove());
		roundNumber = 0;
		viewObjects.add(progress);
		viewObjects.add(label);
	}
	
	private MoveInterfaceHunter randomMove() {
		ButtonInterfaceHunter b;
		//code that randomly selects a ButtonInterfaceX
		return getMove(b);
	}

	private ProgressInterface getProgress() {
		/**
		Placeholder until partner finishes implementation of ProgressInterface
		*/
		return null;
	}

	private void addButtons() {
		// TODO Auto-generated method stub
		
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

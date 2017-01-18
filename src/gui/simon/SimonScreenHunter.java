package gui.simon;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import gui.components.Action;
import gui.components.TextLabel;
import gui.components.Visible;
import gui.screens.ClickableScreen;
import gui.screens.Progress;

public class SimonScreenHunter extends ClickableScreen implements Runnable {

	private ProgressInterfaceHunter progress;
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
		label.setText("");
	    nextRound();
	}

	private void nextRound() {
		isUserTurn = false;
		roundNumber ++;
		progress.setRound(roundNumber);
		moves.add(randomMove());
		progress.setSequenceSize(moves.size());
		changeText("Simon's turn.");
		label.setText("");
		playSequence();
		changeText("Your turn.");
		label.setText("");
		isUserTurn = true;
		sequenceIndex = 0;
	}

	private void playSequence() {
		ButtonInterfaceHunter b = null;
		for(MoveInterfaceHunter m: moves){
			if(b!=null)b.dim();
			b = m.getButton();
			b.highlight();
			try {
				Thread.sleep((long)(2000*(2.0/(roundNumber+2))));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		b.dim();
	}
	}
	
	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		Color[] colors = {Color.red, Color.blue, new Color(240,160,70), new Color(20,255,140), Color.yellow, new Color(180,90,210)};
		String[] names = {"RED", "BLUE", "ORANGE", "GREEN", "YELLOW", "PURPLE"};
		int buttonCount = 6;
		button = new ButtonInterfaceHunter[buttonCount];
		for(int i = 0; i < buttonCount; i++ ){
			button[i] = getAButton();
			button[i].setName(names[i]);
			button[i].setColor(colors[i]);
			button[i].setX(160 + (int)(100*Math.cos(i*2*Math.PI/(buttonCount))));
			button[i].setY(200 - (int)(100*Math.sin(i*2*Math.PI/(buttonCount))));
			final ButtonInterfaceHunter b = button[i];
			System.out.println(b+" has x = "+b.getX()+", y ="+b.getY());
			b.dim();
			button[i].setAction(new Action() {

				public void act() {

						Thread buttonPress = new Thread(new Runnable() {
							
							public void run() {
								b.highlight();
								try {
									Thread.sleep(500);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
								b.dim();
								
							}
						});
						buttonPress.start();
						

						if(isUserTurn && moves.get(sequenceIndex).getButton() == b){
							sequenceIndex++;
						}else if(isUserTurn){
							gameOver();
							return;
						}
						if(sequenceIndex == moves.size()){
							Thread nextRound = new Thread(SimonScreenHunter.this);
							nextRound.start();
						}
					}

			});
			viewObjects.add(button[i]);
		}
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
		int select = (int) (Math.random()*button.length);
		while(select == lastSelectedButton){
			select = (int) (Math.random()*button.length);
		}
		lastSelectedButton = select;
		return new Move(button[select]);
	}

	private ProgressInterfaceHunter getProgress() {
		return new Progress();
	}
	
	private void gameOver() {
		progress.gameOver();
	}

	private ButtonInterfaceHunter getAButton() {
		return new Button();
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

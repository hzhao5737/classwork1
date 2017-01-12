package gui.screens;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import gui.components.Component;
import gui.simon.ProgressInterfaceHunter;

public class Progress extends Component implements ProgressInterfaceHunter {

	private String round;
	private String sequence;
	private boolean isGameOver;

	public Progress() {
		super(60, 60, 120, 50);
	}

	@Override
	public void update(Graphics2D g) {
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		FontMetrics fm = g.getFontMetrics();
		if(isGameOver){
			g.setColor(new Color(255,55,90));
			g.fillRect(0, 0, 120, 50);
			g.setColor(Color.white);
			String go = "GAME OVER!";
			g.drawString(go, (120 - fm.stringWidth(go))/2, 20);
			g.drawString(sequence, (120 - fm.stringWidth(sequence))/2, 40);
		}else{
			g.setColor(new Color(220,255,230));
			g.fillRect(0, 0, 120, 45);
			g.setColor(Color.black);
			g.drawRect(0, 0, 119, 49);
			if(round !=null && sequence != null){
				g.drawString(round, (120 - fm.stringWidth(round))/2, 20);
				g.drawString(sequence, (120 - fm.stringWidth(sequence))/2, 40);
			}
		}
	}

	@Override
	public void setRound(int roundNumber) {
		round = "Round "+roundNumber;
		update();
	}

	@Override
	public void gameOver() {
		isGameOver = true;
		update();
	}

	@Override
	public void setSequenceSize(int size) {
		sequence = "Sequence length "+size;
		update();
	}
}
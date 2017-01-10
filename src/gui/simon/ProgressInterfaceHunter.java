package gui.simon;

import gui.components.Visible;

public interface ProgressInterfaceHunter extends Visible {

	void gameOver();

	void setRound(int roundNumber);

	void setSequenceSize(int size);

}

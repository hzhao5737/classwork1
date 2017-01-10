package gui.simon;

import java.awt.Color;

import gui.components.Action;
import gui.components.Clickable;

public interface ButtonInterfaceHunter extends Clickable {

	void setName(String string);

	void setColor(Color color);

	void dim();

	void setAction(Action action);

	void highlight();

	void setX(int i);

	void setY(int i);

}

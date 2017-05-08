package symposium;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import gui.components.TextLabel;

public class CustomTextLabel extends TextLabel {
	
	private Color c;

	public CustomTextLabel(int x, int y, int w, int h, String text, Color c) {
		super(x, y, w, h, text);
		this.c = c;
	}
	
	public void update(Graphics2D g) {
		g = clear();//delete previous text
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.setColor(c);

		g.setFont(new Font(getFont(), Font.PLAIN, getSize()));
		if(getText() != null){
			g.drawString(getText(), 4, (getHeight()-5));
		}	
	}
}

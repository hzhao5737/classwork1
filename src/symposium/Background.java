package symposium;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import gui.components.Component;

public class Background extends Component{

	private Image image;

	public Background(int x, int y, int w, int h, String fileName){
		super(x, y, w, h);
		this.image = Toolkit.getDefaultToolkit().createImage(fileName);
		update();
	}

	@Override
	public void update(Graphics2D g) {
		g= clear();//delete previous text
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.drawImage(image, 0, 0, null);
	}
	
	public Image getImages(){
		return image;
	}
}

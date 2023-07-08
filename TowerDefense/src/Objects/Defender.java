package Objects;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class Defender {
	private int xOffset;
	private int yOffset;
	private Image image;
	private int width;
	private int height;
	private DefenderType type;
	
	public Defender(DefenderType type) {
		this.width = type.width;
		this.height = type.height;
		this.yOffset = type.yOffset;
		this.xOffset = width/2;
		
		loadImage(type.path);
	}
	
	public void loadImage(String imagePath) {
		Toolkit t = Toolkit.getDefaultToolkit();  
        Image i = t.getImage(imagePath); 
        image = i.getScaledInstance(width, height, Image.SCALE_SMOOTH);
	}
	
	public void draw(Graphics graphics, int x, int y) {
		graphics.drawImage(image, x-xOffset, y-yOffset, null);
	}
}

package game.Objects;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import game.Main.GamePanel;

public class Defender {
	private int xOffset;
	private int yOffset;
	private Image image;
	private int width;
	private int height;
	private DefenderType type;
	
	public Defender(DefenderType type) {
		this.width = (int)(type.width*GamePanel.SCALING_FACTOR);
		this.height = (int)(type.height*GamePanel.SCALING_FACTOR);
		this.yOffset = (int)(type.yOffset*GamePanel.SCALING_FACTOR);
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

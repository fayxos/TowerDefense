package game.Structures;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import game.Main.GamePanel;

abstract public class Obstacle extends Structure {

	int removingCost;
	
	boolean isRemovable;
	
	StructureType type;
	Image sprite;
	int xOffset, yOffset;
	
	protected Obstacle() {
		super();
	}
	
	@Override
	protected void loadStructure() {
		xOffset = (int)(type.width*GamePanel.SCALING_FACTOR)/2;
		yOffset = (int)(type.yOffset*GamePanel.SCALING_FACTOR);
		loadImage(type.path, (int)(type.width*GamePanel.SCALING_FACTOR), (int)(type.height*GamePanel.SCALING_FACTOR));
	}
	
	public void loadImage(String imagePath, int width, int height) {
		Toolkit t = Toolkit.getDefaultToolkit();  
        Image i = t.getImage(imagePath); 
        sprite = i.getScaledInstance(width, height, Image.SCALE_SMOOTH);
	}
	
	@Override
	public void draw(Graphics graphics, int x, int y) {		
		graphics.drawImage(sprite, x-xOffset, y-yOffset, null);
	}

}

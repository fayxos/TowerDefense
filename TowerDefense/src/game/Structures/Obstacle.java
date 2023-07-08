package game.Structures;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

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
		xOffset = type.width/2;
		yOffset = type.yOffset;
		loadImage(type.path, type.width, type.height);
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

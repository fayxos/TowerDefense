package game.Objects;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public abstract class Obstacle extends Structure {

	int removingCost;
	
	boolean isRemovable;
	
	Image sprite;
	
	protected Obstacle() {
		super();
	}
	
	public void loadImage(String imagePath) {
		Toolkit t = Toolkit.getDefaultToolkit();  
        Image i = t.getImage(imagePath); 
        sprite = i.getScaledInstance((int)(i.getWidth(null)*scalingFactor), (int)(i.getHeight(null)*scalingFactor), Image.SCALE_SMOOTH);
	}
	
	@Override
	public void draw(Graphics graphics, int x, int y) {
		graphics.drawImage(sprite, x-xOffset, y-yOffset, null);
	}

}

package game.Objects;

import java.awt.Graphics;
import java.awt.Image;

public abstract class Obstacle extends Structure {

	int removingCost;
	
	boolean isRemovable;
	//test 3
	Image visibleSprite;
	
	protected Obstacle() {
		super();
	}
	
	@Override
	public void draw(Graphics graphics) {
		graphics.drawImage(visibleSprite, x-xOffset, y-yOffset, null);
	}

}

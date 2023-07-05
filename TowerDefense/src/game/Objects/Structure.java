package game.Objects;

import java.awt.Image;

public abstract class Structure {
	
	private static int IDCounter = 0;
	final int ID;
	
	int x,y, xOffset, yOffset;
	
	Image visibleSprite;
	
	protected Structure() {
		ID = IDCounter++;
	}
	
	public void paint() {
		
	}

}

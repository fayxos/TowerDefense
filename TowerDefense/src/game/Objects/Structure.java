package game.Objects;

import java.awt.Graphics;
import java.awt.Image;

public abstract class Structure {
	
	private static int IDCounter = 0;
	final int ID;
	
	int x,y, xOffset, yOffset;
	
	protected Structure() {
		ID = IDCounter++;
	}
	
	abstract public void paint(Graphics graphics);
	
}

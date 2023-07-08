package game.Structures;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

abstract public class Structure {
	
	private static int IDCounter = 0;
	final int ID;
	
	protected Structure() {
		ID = IDCounter++;
	}
	
	abstract public void draw(Graphics graphics, int x, int y);
	
}

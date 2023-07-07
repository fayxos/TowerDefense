package game.Objects;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

public class ArcherTower extends ActiveBuilding {
	
	private ArrayList<Image> sprites;
	
	public ArcherTower(int x, int y) {
		super();
		
		xOffset = 0;
		yOffset = 0;
		
		attackRange = 0;
		attackSpeed = 0;
		attackDamage = 0;
		
	}

}

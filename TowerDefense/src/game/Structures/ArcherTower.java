package game.Structures;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

public class ArcherTower extends ActiveBuilding {
	
	public ArcherTower() {
		super();
		bottomType = StructureType.GREEN_TOWER_BOTTOM_1;
		topType = StructureType.GREEN_TOWER_TOP_2;
		spriteYOffset = 26;
		loadStructure();
		
		attackRange = 250;
		attackSpeed = 0;
		attackDamage = 0;
	}

}

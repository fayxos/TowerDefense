package game.Structures;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

public class ArcherTower extends ActiveBuilding {
	
	public ArcherTower() {
		super();
		StructureType bottomType = StructureType.GREEN_TOWER_BOTTOM_1;
		StructureType topType = StructureType.GREEN_TOWER_TOP_2;
		xOffsetBottom = bottomType.width/2;
		yOffsetBottom = bottomType.yOffset;
		xOffsetTop = topType.width/2;
		yOffsetTop = topType.yOffset;
		spriteYOffset = 26;

		loadImageBottom(bottomType.path, bottomType.width, bottomType.height);
		loadImageTop(topType.path, topType.width, topType.height);
		
		attackRange = 250;
		attackSpeed = 0;
		attackDamage = 0;
	}

}

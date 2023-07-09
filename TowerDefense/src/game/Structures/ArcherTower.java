package game.Structures;

import java.awt.Graphics;
import java.util.ArrayList;

import game.Main.GamePanel;
import game.Objects.Arrow;
import game.Objects.Defender;
import game.Objects.DefenderType;

public class ArcherTower extends ActiveBuilding {
	
	public ArcherTower() {
		super();
		bottomType = StructureType.GREEN_TOWER_BOTTOM_1;
		topType = StructureType.GREEN_TOWER_TOP_2;
		spriteYOffset = (int)(26*GamePanel.SCALING_FACTOR);
		loadStructure();
		
		attackRange = 125;
		attackSpeed = 1;
		attackDamage = 20;
		defender = new Defender(DefenderType.ARCHER);
	}

}

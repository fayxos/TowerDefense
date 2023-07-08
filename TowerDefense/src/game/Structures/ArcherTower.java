package game.Structures;

import java.awt.Graphics;

import game.Main.GamePanel;
import game.Objects.Defender;
import game.Objects.DefenderType;

public class ArcherTower extends ActiveBuilding {
	public Defender defender;
	
	public ArcherTower() {
		super();
		bottomType = StructureType.GREEN_TOWER_BOTTOM_1;
		topType = StructureType.GREEN_TOWER_TOP_2;
		spriteYOffset = (int)(26*GamePanel.SCALING_FACTOR);
		loadStructure();
		
		attackRange = 250;
		attackSpeed = 0;
		attackDamage = 0;
		defender = new Defender(DefenderType.ARCHER);
	}
	
	public void draw(Graphics graphics, int x, int y) {
		super.draw(graphics, x, y);
		defender.draw(graphics, x, y);

	}
	
	public void draw(Graphics graphics, int x, int y, boolean selected) {
		super.draw(graphics, x, y, selected);
		
		if(defender != null) {
			defender.draw(graphics, x, y);
		}
	}

}

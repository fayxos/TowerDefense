package game.Structures;

public class TestBuilding extends Building {

	public TestBuilding() {
		super();
		
		level = 1;
		maxLevel = level;
		
		bottomType = new StructureType[2];
		topType = new StructureType[2];
		bottomType[0] = StructureType.GREEN_TOWER_BOTTOM_3;
		topType[0] = StructureType.GREEN_TOWER_TOP_2;
		spriteYOffset = 30;
		loadStructure();
	}

}

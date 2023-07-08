package game.Structures;

public class Stone extends Obstacle{
	
	public Stone() {
		this(StructureType.GREY_STONE_S);
	}
	
	public Stone(StructureType type) {
		super();
		this.type = type;
		loadStructure();
	}

}

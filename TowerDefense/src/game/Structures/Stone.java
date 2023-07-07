package game.Structures;

public class Stone extends Obstacle{
	
	public Stone() {
		this(StructureType.GREY_STONE_S);
	}
	
	public Stone(StructureType type) {
		super();
		xOffset = type.width/2;
		yOffset = type.yOffset;

		loadImage(type.path, type.width, type.height);
	}

}

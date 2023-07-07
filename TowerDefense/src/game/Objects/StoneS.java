package game.Objects;

public class StoneS extends Obstacle{
	
	public StoneS() {
		this(StructureType.GREY_STONE_S);
	}
	
	public StoneS(StructureType type) {
		super();
		xOffset = 12;
		yOffset = 13;
		int width = 25;
		int height = 22;
		loadImage(type.path, width, height);
	}

}

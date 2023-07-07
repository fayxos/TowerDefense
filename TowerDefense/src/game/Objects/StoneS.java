package game.Objects;

public class StoneS extends Obstacle{
	
	public StoneS() {
		this(StructureType.GREY_STONE_S);
	}
	
	public StoneS(StructureType type) {
		super();
		xOffset = 50;
		yOffset = 30;
		int width = 100;
		int height = 100;
		loadImage(type.path, width, height);
	}

}

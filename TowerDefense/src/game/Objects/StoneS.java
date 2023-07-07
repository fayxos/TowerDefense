package game.Objects;

public class StoneS extends Obstacle{
	
	public StoneS() {
		xOffset = 50;
		yOffset = 30;
		width = 100;
		height = 100;
	}
	
	public StoneS(StructureType type) {
		super();
		loadImage(type.path);
	}

}

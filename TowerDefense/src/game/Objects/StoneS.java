package game.Objects;

public class StoneS extends Obstacle{
	
	public StoneS() {
		xOffset = 50;
		yOffset = 30;
	}
	
	public StoneS(StructureType type) {
		loadImage(type.path);
	}

}

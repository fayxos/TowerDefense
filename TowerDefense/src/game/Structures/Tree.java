package game.Structures;

public class Tree extends Obstacle {
	
	public Tree() {
		this(StructureType.STRAIGHT_TREE_S);
	}
	
	public Tree(StructureType type) {
		super();
		xOffset = type.width/2;
		yOffset = type.yOffset;

		loadImage(type.path, type.width, type.height);
	}

}

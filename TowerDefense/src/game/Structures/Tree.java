package game.Structures;

public class Tree extends Obstacle {
	
	public Tree() {
		this(StructureType.STRAIGHT_TREE_S);
	}
	
	public Tree(StructureType type) {
		super();
		this.type = type;
		loadStructure();
	}

}

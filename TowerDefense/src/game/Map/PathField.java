package game.Map;

public class PathField extends Field {
	PathFieldType type;
	
	public PathField(PathFieldType type) {
		super();
		this.type = type;
		loadImage(type.label);
	}
}

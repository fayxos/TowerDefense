package game.Map;

public class PathField extends Field {
	PathFieldType type;
	
	public PathField(PathFieldType type) {
		this.type = type;
		loadImage(type.label);
	}
}

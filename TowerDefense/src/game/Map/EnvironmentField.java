package game.Map;

public class EnvironmentField extends Field {
	EnvironmentFieldType type;
	
	public EnvironmentField(EnvironmentFieldType type) {
		this.type = type;
		loadImage(type.path);
	}

}

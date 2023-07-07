package game.Map;

public class EnvironmentField extends Field {
	EnvironmentFieldType type;
	
	public EnvironmentField(EnvironmentFieldType type) {
		super();
		this.type = type;
		loadImage(type.path);
	}

}

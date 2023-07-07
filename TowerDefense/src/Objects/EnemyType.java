package Objects;

public enum EnemyType {
	GREEN_UFO("assets/Sprites/UFO/green ufo.png"),
	GREY_UFO("assets/Sprites/UFO/grey ufo.png"),
	PRUPLE_UFO("assets/Sprites/UFO/purple ufo.png"),
	RED_UFO("assets/Sprites/UFO/red ufo.png"),
	YELLOW_UFO("assets/Sprites/UFO/yellow ufo.png");
	
	public final String label;

    private EnemyType(String label) {
        this.label = label;
    }
}

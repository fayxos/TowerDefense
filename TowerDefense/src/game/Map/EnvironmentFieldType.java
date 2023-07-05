package game.Map;

public enum EnvironmentFieldType {
	CROSSING("assets/Sprites/River tiles/river(1).png"),
	BOTTOM_LEFT_TO_TOP_RIGHT_END("assets/Sprites/River tiles/river(2).png"),
	BOTTOM_RIGHT_TO_TOP_LEFT_END("assets/Sprites/River tiles/river(3).png"),
	TOP_LEFT_TO_BOTTOM_RIGHT_END("assets/Sprites/River tiles/river(4).png"),
	TOP_RIGHT_TO_BOTTOM_LEFT_END("assets/Sprites/River tiles/river(5).png"),
	TOP_LEFT_TO_TOP_RIGHT_CURVE("assets/Sprites/River tiles/river(6).png"),
	BOTTOM_LEFT_TO_BOTTOM_RIGHT_CURVE("assets/Sprites/River tiles/river(7).png"),
	BOTTOM_LEFT_TO_TOP_LEFT_CURVE("assets/Sprites/River tiles/river(8).png"),
	BOTTOM_RIGHT_TO_TOP_RIGHT_CURVE("assets/Sprites/River tiles/river(9).png"),
	TOP_LEFT_TO_BOTTOM_RIGHT_PATH("assets/Sprites/River tiles/river(10).png"),
	BOTTOM_LEFT_TO_TOP_RIGHT_PATH("assets/Sprites/River tiles/river(11).png");
	
	public final String label;

    private EnvironmentFieldType(String label) {
        this.label = label;
    }
}

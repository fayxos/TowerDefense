package game.Map;

public enum PathFieldType {
	CROSSING("assets/Sprites/Road tiles/road(1).png"),
	BOTTOM_LEFT_TO_BOTTOM_RIGHT_CURVE("assets/Sprites/Road tiles/road(2).png"),
	BOTTOM_RIGHT_TO_TOP_RIGHT_CURVE("assets/Sprites/Road tiles/road(3).png"),
	BOTTOM_LEFT_TO_TOP_LEFT_CURVE("assets/Sprites/Road tiles/road(4).png"),
	TOP_LEFT_TO_TOP_RIGHT_CURVE("assets/Sprites/Road tiles/road(5).png"),
	TOP_LEFT_TO_TOP_RIGHT_AND_BOTTOM_RIGHT_CROSSING("assets/Sprites/Road tiles/road(6).png"),
	BOTTOM_LEFT_TO_TOP_LEFT_AND_TOP_RIGHT_CROSSING("assets/Sprites/Road tiles/road(7).png"),
	BOTTOM_LEFT_TO_TOP_LEFT_AND_BOTTOM_RIGHT_CROSSING("assets/Sprites/Road tiles/road(8).png"),
	BOTTOM_LEFT_TO_BOTTOM_RIGHT_AND_TOP_RIGHT_CROSSING("assets/Sprites/Road tiles/road(9).png"),
	TOP_LEFT_TO_BOTTOM_RIGHT_END("assets/Sprites/Road tiles/road(10).png"),
	TOP_RIGHT_TO_BOTTOM_LEFT_END("assets/Sprites/Road tiles/road(11).png"),
	BOTTOM_RIGHT_TO_TOP_LEFT_END("assets/Sprites/Road tiles/road(12).png"),
	BOTTOM_LEFT_TO_TOP_RIGHT_END("assets/Sprites/Road tiles/road(13).png"),
	TOP_LEFT_TO_BOTTOM_RIGHT_PATH("assets/Sprites/Road tiles/road(14).png"),
	BOTTOM_LEFT_TO_TOP_RIGHT_PATH("assets/Sprites/Road tiles/road(15).png"),
	
	BOTTOM_LEFT_TO_TOP_RIGHT_BRIDGE_TILE("assets/Sprites/Road tiles/roads on water/road(1).png"),
	TOP_LEFT_TO_BOTTOM_RIGHT_BRIDGE_TILE("assets/Sprites/Road tiles/roads on water/road(2).png"),
	BOTTOM_LEFT_TO_TOP_RIGHT_BRIDGE("assets/Sprites/Road tiles/roads on water/road(3).png"),
	TOP_LEFT_TO_BOTTOM_RIGHT_BRIDGE("assets/Sprites/Road tiles/roads on water/road(4).png"),
	BOTTOM_LEFT_TO_TOP_RIGHT_BRIDGE_START("assets/Sprites/Road tiles/roads on water/road(5).png"),
	TOP_LEFT_TO_BOTTOM_RIGHT_BRIDGE_START("assets/Sprites/Road tiles/roads on water/road(6).png"),
	BOTTOM_LEFT_TO_TOP_RIGHT_BRIDGE_END("assets/Sprites/Road tiles/roads on water/road(7).png"),
	TOP_LEFT_TO_BOTTOM_RIGHT_BRIDGE_END("assets/Sprites/Road tiles/roads on water/road(8).png");
	
	public final String path;

    private PathFieldType(String path) {
        this.path = path;
    }
}

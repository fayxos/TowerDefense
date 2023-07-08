package game.Structures;

public enum StructureType {
	GREEN_TOWER_BOTTOM_1("assets/Sprites/Tower tiles/Green tower/block(1).png", 63, 64, 44),
	GREEN_TOWER_BOTTOM_2("assets/Sprites/Tower tiles/Green tower/block(2).png", 63, 64, 44), // adjusted last
	GREEN_TOWER_BOTTOM_3("assets/Sprites/Tower tiles/Green tower/block(3).png", 75, 71, 48),
	GREEN_TOWER_BOTTOM_4("assets/Sprites/Tower tiles/Green tower/block(4).png", 63, 64, 44),
	GREEN_TOWER_BOTTOM_5("assets/Sprites/Tower tiles/Green tower/block(5).png", 63, 64, 44),
	GREEN_TOWER_TOP_1("assets/Sprites/Tower tiles/Green tower/block(6).png", 75, 70, 50),
	GREEN_TOWER_TOP_2("assets/Sprites/Tower tiles/Green tower/block(7).png", 75, 70, 50),
	GREEN_TOWER_TOP_3("assets/Sprites/Tower tiles/Green tower/block(8).png"),
	GREEN_TOWER_TOP_4("assets/Sprites/Tower tiles/Green tower/block(9).png"),
	GREEN_TOWER_TOP_5("assets/Sprites/Tower tiles/Green tower/block(10).png"),
	GREEN_TOWER_TOP_6("assets/Sprites/Tower tiles/Green tower/block(11).png"),
	YELLOW_TOWER_BOTTOM_1("assets/Sprites/Tower tiles/Yellow tower/block(1).png"),
	YELLOW_TOWER_BOTTOM_2("assets/Sprites/Tower tiles/Yellow tower/block(2).png"),
	YELLOW_TOWER_BOTTOM_3("assets/Sprites/Tower tiles/Yellow tower/block(3).png"),
	YELLOW_TOWER_BOTTOM_4("assets/Sprites/Tower tiles/Yellow tower/block(4).png"),
	//YELLOW_TOWER_BOTTOM_5: sprite is not in asset folder
	YELLOW_TOWER_TOP_1("assets/Sprites/Tower tiles/Yellow tower/block(5).png"),
	YELLOW_TOWER_TOP_2("assets/Sprites/Tower tiles/Yellow tower/block(6).png"),
	YELLOW_TOWER_TOP_3("assets/Sprites/Tower tiles/Yellow tower/block(7).png"),
	YELLOW_TOWER_TOP_4("assets/Sprites/Tower tiles/Yellow tower/block(8).png"),
	YELLOW_TOWER_TOP_5("assets/Sprites/Tower tiles/Yellow tower/block(9).png"),
	YELLOW_TOWER_TOP_6("assets/Sprites/Tower tiles/Yellow tower/block(10).png"),
	RED_TOWER_BOTTOM_1("assets/Sprites/Tower tiles/Red tower/block(1).png"),
	RED_TOWER_BOTTOM_2("assets/Sprites/Tower tiles/Red tower/block(2).png"),
	RED_TOWER_BOTTOM_3("assets/Sprites/Tower tiles/Red tower/block(3).png"),
	RED_TOWER_BOTTOM_4("assets/Sprites/Tower tiles/Red tower/block(4).png"),
	RED_TOWER_BOTTOM_5("assets/Sprites/Tower tiles/Red tower/block(5).png"),
	RED_TOWER_TOP_1("assets/Sprites/Tower tiles/Red tower/block(6).png"),
	RED_TOWER_TOP_2("assets/Sprites/Tower tiles/Red tower/block(7).png"),
	RED_TOWER_TOP_3("assets/Sprites/Tower tiles/Red tower/block(8).png"),
	RED_TOWER_TOP_4("assets/Sprites/Tower tiles/Red tower/block(9).png"),
	RED_TOWER_TOP_5("assets/Sprites/Tower tiles/Red tower/block(10).png"),
	RED_TOWER_TOP_6("assets/Sprites/Tower tiles/Red tower/block(11).png"),
	PURPLE_TOWER_BOTTOM_1("assets/Sprites/Tower tiles/Purple tower/block(1).png"),
	PURPLE_TOWER_BOTTOM_2("assets/Sprites/Tower tiles/Purple tower/block(2).png"),
	PURPLE_TOWER_BOTTOM_3("assets/Sprites/Tower tiles/Purple tower/block(3).png"),
	PURPLE_TOWER_BOTTOM_4("assets/Sprites/Tower tiles/Purple tower/block(4).png"),
	PURPLE_TOWER_BOTTOM_5("assets/Sprites/Tower tiles/Purple tower/block(5).png"),
	PURPLE_TOWER_TOP_1("assets/Sprites/Tower tiles/Purple tower/block(6).png"),
	PURPLE_TOWER_TOP_2("assets/Sprites/Tower tiles/Purple tower/block(7).png"),
	PURPLE_TOWER_TOP_3("assets/Sprites/Tower tiles/Purple tower/block(8).png"),
	PURPLE_TOWER_TOP_4("assets/Sprites/Tower tiles/Purple tower/block(9).png"),
	PURPLE_TOWER_TOP_5("assets/Sprites/Tower tiles/Purple tower/block(10).png"),
	PURPLE_TOWER_TOP_6("assets/Sprites/Tower tiles/Purple tower/block(11).png"),
	
	BROWN_STONE_S("assets/Sprites/Environment tiles/Ground stones/ground stone(1).png", 25, 22, 13),
	BROWN_STONE_L("assets/Sprites/Environment tiles/Ground stones/ground stone(2).png", 48, 41, 28),
	BROWN_STONE_SL("assets/Sprites/Environment tiles/Ground stones/ground stone(3).png", 57, 48, 33),
	BROWN_STONE_SLS("assets/Sprites/Environment tiles/Ground stones/ground stone(4).png", 58, 53, 36),
	GREY_STONE_S("assets/Sprites/Environment tiles/Stones/stone(1).png", 25, 22, 13),
	GREY_STONE_L("assets/Sprites/Environment tiles/Stones/stone(2).png", 48, 41, 28),
	GREY_STONE_SL("assets/Sprites/Environment tiles/Stones/stone(3).png", 57, 48, 33),
	GREY_STONE_SLS("assets/Sprites/Environment tiles/Stones/stone(4).png", 58, 53, 36),
	STRAIGHT_TREE_S("assets/Sprites/Environment tiles/trees/tree(1).png", 22, 58, 50),
	STRAIGHT_TREE_L("assets/Sprites/Environment tiles/trees/tree(2).png", 30, 84, 75),
	LAYERED_TREE_S("assets/Sprites/Environment tiles/trees/tree(3).png", 35, 64, 55),
	LAYERED_TREE_L("assets/Sprites/Environment tiles/trees/tree(4).png", 46, 89, 80);
	
	public final String path;
	public int width = 0;
	public int height = 0;
	public int yOffset = 0;
	
	StructureType(String path) {
		this.path = path;
	}
	
	StructureType(String path, int width, int height, int yOffset) {
		this.path = path;
		this.width = width;
		this.height = height;
		this.yOffset = yOffset;
	}
}

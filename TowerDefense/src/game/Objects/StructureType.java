package game.Objects;

public enum StructureType {
	GREEN_TOWER_BOTTOM_1("assets/Sprites/Tower tiles/Green tower/block(1).png"),
	GREEN_TOWER_BOTTOM_2("assets/Sprites/Tower tiles/Green tower/block(2).png"),
	GREEN_TOWER_BOTTOM_3("assets/Sprites/Tower tiles/Green tower/block(3).png"),
	GREEN_TOWER_BOTTOM_4("assets/Sprites/Tower tiles/Green tower/block(4).png"),
	GREEN_TOWER_BOTTOM_5("assets/Sprites/Tower tiles/Green tower/block(5).png"),
	GREEN_TOWER_TOP_1("assets/Sprites/Tower tiles/Green tower/block(6).png"),
	GREEN_TOWER_TOP_2("assets/Sprites/Tower tiles/Green tower/block(7).png"),
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
	
	BROWN_STONE_S("assets/Sprites/Environment tiles/Ground stones/ground stone(1).png"),
	BROWN_STONE_L("assets/Sprites/Environment tiles/Ground stones/ground stone(2).png"),
	BROWN_STONE_SL("assets/Sprites/Environment tiles/Ground stones/ground stone(3).png"),
	BROWN_STONE_SLS("assets/Sprites/Environment tiles/Ground stones/ground stone(4).png"),
	GREY_STONE_S("assets/Sprites/Environment tiles/Stones/stone(1).png"),
	GREY_STONE_L("assets/Sprites/Environment tiles/Stones/stone(2).png"),
	GREY_STONE_SL("assets/Sprites/Environment tiles/Stones/stone(3).png"),
	GREY_STONE_SLS("assets/Sprites/Environment tiles/Stones/stone(4).png"),
	STRAIGHT_TREE_S("assets/Sprites/Environment tiles/trees/tree(1).png"),
	STRAIGHT_TREE_L("assets/Sprites/Environment tiles/trees/tree(2).png"),
	LAYERED_TREE_S("assets/Sprites/Environment tiles/trees/tree(3).png"),
	LAYERED_TREE_L("assets/Sprites/Environment tiles/trees/tree(4).png");

	public final String path;
	
	StructureType(String path) {
		this.path = path;
	}
}

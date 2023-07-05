package game.Objects;

public abstract class Building extends Structure {

	int buildingCost, upgradeCost[];
	
	int level, maxLevel;
	
	protected Building() {
		super();
	}
	
	public boolean isUpgradeable( ) {
		return level < maxLevel;
	}

}

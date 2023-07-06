package game.Objects;

import java.awt.Image;

public abstract class Building extends Structure {

	int buildingCost, upgradeCost[];
	
	int level, maxLevel;
	
	Image visibleBottomSprite, visibleTopSprite;
	
	protected Building() {
		super();
	}
	
	public boolean isUpgradeable( ) {
		return level < maxLevel;
	}

}

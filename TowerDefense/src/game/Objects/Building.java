package game.Objects;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public abstract class Building extends Structure {
	
	Image bottomSprite, topSprite;
	
	int spriteXOffset, spriteYOffset;
	
	int buildingCost, upgradeCost[];
	
	int level, maxLevel;
	
	
	
	protected Building() {
		super();
	}
	
	public boolean isUpgradeable( ) {
		return level < maxLevel;
	}
	
	public void loadImage(String imagePath) {
		Toolkit t = Toolkit.getDefaultToolkit();  
        Image i = t.getImage(imagePath); 
        bottomSprite = i.getScaledInstance((int)(i.getWidth(null)*scalingFactor), (int)(i.getHeight(null)*scalingFactor), Image.SCALE_SMOOTH);
	}
	
	@Override
	public void draw(Graphics graphics, int x, int y) {
		graphics.drawImage(bottomSprite, x-xOffset, y-yOffset, null);
		graphics.drawImage(bottomSprite, x-xOffset-spriteXOffset, y-yOffset-spriteYOffset, null);
	}

}

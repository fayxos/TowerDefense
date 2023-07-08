package game.Structures;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

abstract public class Building extends Structure {
	
	int buildingCost, upgradeCost[];
	
	int level, maxLevel;
	
	Image bottomSprite, topSprite;
	int xOffsetBottom, yOffsetBottom, 
		xOffsetTop, yOffsetTop,
		spriteYOffset;
	
	protected Building() {
		super();
	}
	
	public boolean isUpgradeable( ) {
		return level < maxLevel;
	}
	
	public void loadImageBottom(String imagePath, int width, int height) {
		Image i = loadImage(imagePath, width, height);
        bottomSprite = i;
	}
	
	public void loadImageTop(String imagePath, int width, int height) {
		Image i = loadImage(imagePath, width, height);
        topSprite = i;
	}
	
	private Image loadImage(String imagePath, int width, int height) {
		Toolkit t = Toolkit.getDefaultToolkit();  
        Image i = t.getImage(imagePath); 
        return i.getScaledInstance(width, height, Image.SCALE_SMOOTH);
	}
	
	@Override
	public void draw(Graphics graphics, int x, int y) {
		graphics.drawImage(bottomSprite, x-xOffsetBottom, y-yOffsetBottom, null);
		graphics.drawImage(topSprite, x-xOffsetTop, y-yOffsetTop-spriteYOffset, null);
	}

}

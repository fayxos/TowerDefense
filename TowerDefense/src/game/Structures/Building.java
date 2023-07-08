package game.Structures;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Optional;

abstract public class Building extends Structure {
	
	int buildingCost, upgradeCost[];
	
	int level, maxLevel;
	
	StructureType bottomType, topType;
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
	
	@Override
	protected void loadStructure() {
		xOffsetBottom = bottomType.width/2;
		yOffsetBottom = bottomType.yOffset;
		loadImageBottom(bottomType.path, bottomType.width, bottomType.height);
		
		if(topType!=null) {
			xOffsetTop = topType.width/2;
			yOffsetTop = topType.yOffset;	
			loadImageTop(topType.path, topType.width, topType.height);
		}
	}
	
	protected void loadImageBottom(String imagePath, int width, int height) {
		Image i = loadImage(imagePath, width, height);
        bottomSprite = i;
	}
	
	protected void loadImageTop(String imagePath, int width, int height) {
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
		if(topType!=null) graphics.drawImage(topSprite, x-xOffsetTop, y-yOffsetTop-spriteYOffset, null);
	}

}

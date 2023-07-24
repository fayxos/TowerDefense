package game.Structures;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Optional;

import game.Main.GamePanel;

abstract public class Building extends Structure {
	
	int buildingCost, upgradeCost[];
	
	int level, maxLevel;
	
	StructureType bottomType[], topType[];
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
	
	public void upgrade() {
		level++;
		loadStructure();
	}
	
	@Override
	protected void loadStructure() {
		xOffsetBottom = (int)(bottomType[level-1].width*GamePanel.SCALING_FACTOR)/2;
		yOffsetBottom = (int)(bottomType[level-1].yOffset*GamePanel.SCALING_FACTOR);
		loadImageBottom(bottomType[level-1].path, (int)(bottomType[level-1].width*GamePanel.SCALING_FACTOR), (int)(bottomType[level-1].height*GamePanel.SCALING_FACTOR));
		
		if(topType!=null) {
			xOffsetTop = (int)(topType[level-1].width*GamePanel.SCALING_FACTOR)/2;
			yOffsetTop = (int)(topType[level-1].yOffset*GamePanel.SCALING_FACTOR);	
			loadImageTop(topType[level-1].path, (int)(topType[level-1].width*GamePanel.SCALING_FACTOR), (int)(topType[level-1].height*GamePanel.SCALING_FACTOR));
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

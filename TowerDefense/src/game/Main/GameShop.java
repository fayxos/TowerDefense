package game.Main;

import java.awt.*;
import java.awt.geom.AffineTransform;

import game.Structures.ActiveBuilding;
import game.Structures.ArcherTower;
import game.Structures.Building;

public class GameShop {

	static Image shopCardImage;
	static Building archerTower;
	
	static final int width = 226;
	static final int height = 158;
	
	static final int xStart = 15;
	static final int yStart = 660;
	static final int xCardOffset = 15 + height;
	
    public static void start() {
		shopCardImage = loadImage("assets/FantasyWoodenPack/UI board Medium  parchment.png", width, height);
		archerTower = new ArcherTower();
	}
	
	public static Image loadImage(String imagePath, int width, int height) {
		Toolkit t = Toolkit.getDefaultToolkit();
        Image i = t.getImage(imagePath);
        return i.getScaledInstance(width, height, Image.SCALE_SMOOTH);
	}
	
	public static void draw(Graphics graphics) {
		AffineTransform trans = new AffineTransform();
		trans.rotate(Math.PI/2);

		trans.translate(yStart,-(xStart+height));
		((Graphics2D)graphics).drawImage(shopCardImage, trans, null);
		archerTower.draw(graphics, xStart + height/2, yStart + width/2);
		trans.translate(0,-xCardOffset);
		((Graphics2D)graphics).drawImage(shopCardImage, trans, null);
		archerTower.draw(graphics, xStart + height/2 + xCardOffset, yStart + width/2);
		trans.translate(0,-xCardOffset);
		((Graphics2D)graphics).drawImage(shopCardImage, trans, null);
		archerTower.draw(graphics, xStart + height/2 + xCardOffset*2, yStart + width/2);
		trans.translate(0,-xCardOffset);
		((Graphics2D)graphics).drawImage(shopCardImage, trans, null);
		archerTower.draw(graphics, xStart + height/2 + xCardOffset*3, yStart + width/2);
	}

}

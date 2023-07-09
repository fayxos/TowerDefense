package game.Main;

import java.awt.*;
import java.awt.geom.AffineTransform;

public class GameShop {

	static Image shopCardImage;
	
	static final int width = 226;
	static final int height = 158;
	
	static final int xStart = 180;
	static final int yStart = 650;
	
    public static void start() {
		shopCardImage = loadImage("assets/FantasyWoodenPack/UI board Medium  parchment.png", width, height);
	}
	
	public static Image loadImage(String imagePath, int width, int height) {
		Toolkit t = Toolkit.getDefaultToolkit();
        Image i = t.getImage(imagePath);
        return i.getScaledInstance(width, height, Image.SCALE_SMOOTH);
	}
	
	public static void draw(Graphics graphics) {
		AffineTransform trans = new AffineTransform();
		trans.rotate(Math.PI/2);

		trans.translate(660,-(15 + height));
		((Graphics2D)graphics).drawImage(shopCardImage, trans, null);
		trans.translate(0,-(15 + height));
		((Graphics2D)graphics).drawImage(shopCardImage, trans, null);
		trans.translate(0,-(15 + height));
		((Graphics2D)graphics).drawImage(shopCardImage, trans, null);
		trans.translate(0,-(15 + height));
		((Graphics2D)graphics).drawImage(shopCardImage, trans, null);
	}

}

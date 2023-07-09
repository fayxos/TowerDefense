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
		trans.translate(15 + height,660);
		trans.rotate(Math.toRadians(90));
		((Graphics2D)graphics).drawImage(shopCardImage, trans, null);
		trans.translate(15 + height,660);
		trans.rotate(Math.toRadians(90));
		((Graphics2D)graphics).drawImage(shopCardImage, trans, null);
	}

}

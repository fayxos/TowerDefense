package game.Main;

import java.awt.*;
import java.awt.geom.AffineTransform;

import game.Structures.ActiveBuilding;
import game.Structures.ArcherTower;
import game.Structures.Building;
import game.Structures.Structure;

public class GameShop {

	static Image shopCardImage, goldImage;
	
	static final int xStart = 15;
	static final int yStart = 660;
	
    public static void start() {
		shopCardImage = loadImage("assets/FantasyWoodenPack/UI board Medium  parchment.png", width, height);
		goldImage = GameState.loadImage("assets/gold.png", 40, 40);
	}
	
	public static Image loadImage(String imagePath, int width, int height) {
		Toolkit t = Toolkit.getDefaultToolkit();
        Image i = t.getImage(imagePath);
        return i.getScaledInstance(width, height, Image.SCALE_SMOOTH);
	}
	
	public void draw(Graphics graphics) {
		
		trans.translate(yStart,-(xStart+height));
		((Graphics2D)graphics).drawImage(shopCardImage, trans, null);
		archerTower.draw(graphics, xStart + height/2, yStart + width/2);
		graphics.drawImage(goldImage, xStart + (int)(height*0.3) - 20, yStart + (int)(width*0.8) - 30, null);
		graphics.drawString(Integer.toString(20), xStart + (int)(height*0.45), yStart + (int)(width*0.8));
		
		trans.translate(0,-xCardOffset);
		((Graphics2D)graphics).drawImage(shopCardImage, trans, null);
		archerTower.draw(graphics, xStart + height/2 + xCardOffset, yStart + width/2);
		graphics.drawImage(goldImage, xStart + (int)(height*0.3) - 20 + xCardOffset, yStart + (int)(width*0.8) - 30, null);
		graphics.drawString(Integer.toString(50), xStart + (int)(height*0.45) + xCardOffset, yStart + (int)(width*0.8));
		
		trans.translate(0,-xCardOffset);
		((Graphics2D)graphics).drawImage(shopCardImage, trans, null);
		archerTower.draw(graphics, xStart + height/2 + xCardOffset*2, yStart + width/2);
		graphics.drawImage(goldImage, xStart + (int)(height*0.3) - 20 + xCardOffset*2, yStart + (int)(width*0.8) - 30, null);
		graphics.drawString(Integer.toString(300), xStart + (int)(height*0.45) + xCardOffset*2, yStart + (int)(width*0.8));
		
		trans.translate(0,-xCardOffset);
		((Graphics2D)graphics).drawImage(shopCardImage, trans, null);
		archerTower.draw(graphics, xStart + height/2 + xCardOffset*3, yStart + width/2);
		graphics.drawImage(goldImage, xStart + (int)(height*0.3) - 20 + xCardOffset*3, yStart + (int)(width*0.8) - 30, null);
		graphics.drawString(Integer.toString(1000), xStart + (int)(height*0.45) + xCardOffset*3, yStart + (int)(width*0.8));
	}
	
	private class ShopCard extends GameShop {
		
		Structure structure;
		int x, y;
		String label;
		static final int width = 226;
		static final int height = 158;
		static final int xCardOffset = 15 + height;
		private AffineTransform trans;
		private Font font;
		
		ShopCard(int x, int y, Structure structure, int cost) {
			this(x,y,structure,String.valueOf(cost));
		}
		
		ShopCard(int x, int y, Structure structure, String label) {
			this.x = x; 
			this.y = y;
			this.structure = structure;
			this.label = label;
			font = new Font("TimesRoman", Font.BOLD, 30);
			trans = new AffineTransform();
			trans.rotate(Math.PI/2);
		}
		
		public void draw(Graphics graphics) {
			graphics.setFont(font);
			
			trans.translate(y,-(x+height));
			((Graphics2D)graphics).drawImage(shopCardImage, trans, null);
			structure.draw(graphics, x + height/2, y + width/2);
			graphics.drawImage(goldImage, x + (int)(height*0.3) - 20, y + (int)(width*0.8) - 30, null);
			graphics.drawString(Integer.toString(20), x + (int)(height*0.45), y + (int)(width*0.8));
			
		}
	}

}

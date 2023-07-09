package game.Map;
import java.awt.*;
import java.util.ArrayList;

import game.Main.GamePanel;
import game.Objects.Arrow;
import game.Objects.Bullet;
import game.Objects.Enemy;


public abstract class Field {
	private static int IDCounter = 0;
	public static Field HighlightedField = null;
	public int ID;
	int x;
	int y;
	public static final int xOffset = (int)(50*GamePanel.SCALING_FACTOR);
	public static final int yOffset = (int)(30*GamePanel.SCALING_FACTOR);
	static final int width = (int)(103*GamePanel.SCALING_FACTOR);
	static final int height = (int)(100*GamePanel.SCALING_FACTOR);
	Image image;
	
	public ArrayList<Bullet> bullets = new ArrayList<Bullet>();
	
	public Field() {
		this.ID = IDCounter++;
	}
		
	public void place(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void loadImage(String imagePath) {
		Toolkit t = Toolkit.getDefaultToolkit();  
        Image i = t.getImage(imagePath); 
        image = i.getScaledInstance(width, height, Image.SCALE_SMOOTH);
	}
	
	public void draw(Graphics graphics) {
		graphics.drawImage(image, x-xOffset, y-yOffset, null);
		
		for(Bullet bullet : bullets) {
			
			if(bullet instanceof Arrow) {
				Arrow arrow = (Arrow)bullet;
				arrow.draw(graphics);
			} else {
				bullet.draw(graphics);
			}
		}
	}
	
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
}

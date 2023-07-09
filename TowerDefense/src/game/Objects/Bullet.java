package game.Objects;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import game.Main.GamePanel;
import game.Map.Field;
import game.Map.Map;

public class Bullet {
	public double x;	
	public double y;
	public double speed; 
	
	public int xOffset;
	public int yOffset;
	
	public int damage;
	
	public String imagePath;
	
	public Enemy enemy;
	public Image image;

	public static Map map;
	
	public boolean shouldRemove = false;
	
	public Bullet(Enemy enemy, int damage) {
		this.enemy = enemy;
		this.damage = damage;
	}
	
	public void place(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void move() {
		double[] vec = getNextVec(); 
		x += speed * vec[0];
		y += speed * vec[1];

		Field field = map.getFieldFromPosition((int)x, (int)y);
		if(field != null) {
			field.bullets.add(this);
		}
	}
	
	private double[] getNextVec() {
		double[] vec = new double[2];
		
		double vecX = enemy.x-x;		
		double vecY = enemy.y-y;
		
		double len = Math.sqrt(Math.pow(vecX, 2) + Math.pow(vecY, 2));
		
		vec[0] = (vecX / len);
		vec[1] = (vecY / len);
		return vec;
	}
	
	public void loadImage(String imagePath, int width, int height) {
		Toolkit t = Toolkit.getDefaultToolkit();  
        Image i = t.getImage(imagePath); 
        image = i.getScaledInstance(width, height, Image.SCALE_SMOOTH);
	}
	
	public void draw(Graphics graphics) {		
		graphics.drawImage(image, (int)x-xOffset, (int)y-yOffset, null);
	}

	
	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getSpeed() {
		return speed;
	}
	
	

}

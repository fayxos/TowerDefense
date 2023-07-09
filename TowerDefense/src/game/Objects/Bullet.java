package game.Objects;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class Bullet {
	public double x;	
	public double y;
	public double vDirX;
	public double vDirY;
	public double speed; 
	
	public int xOffset;
	public int yOffset;
	
	public int damage;
	
	public String imagePath;
	
	public Enemy enemy;
	public Image image;

	
	public Bullet(Enemy enemy, int damage) {
		this.enemy = enemy;
		this.damage = damage;
	}
	
	public void move() {
		x = speed * calcDirecX(enemy.x, enemy.y);
		y = speed * calcDirY(enemy.x, enemy.y);
	}
	
	private double calcDirecX(double enemyx, double enemyy) {
		return (enemyx - x)/Math.sqrt(Math.pow(enemyy - y, 2) + Math.pow(enemyx-x, 2)) ;
		
	}
	private double calcDirY(double enemyy, double enemyx) {
		return (enemyy - y)/Math.sqrt(Math.pow(enemyy - y, 2) + Math.pow(enemyx-x, 2)) ;
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

	public double getvDirX() {
		return vDirX;
	}

	public double getvDirY() {
		return vDirY;
	}

	public double getSpeed() {
		return speed;
	}
	
	

}

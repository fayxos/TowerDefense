package game.Objects;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import game.Map.Field;
import game.Map.Map;

public class Enemy {
	private static int IDCounter = 0;
	public int ID;
	double x;
	double y;
	Field[] path;
	int currentField = 0;
	
	int delay = 0;
	boolean start = true;
	
	int speed = 5;
	double xVec;
	double yVec;
	
	boolean dead = false;
	
	public static final int xOffset = 16;
	public static final int yOffset = 20;
	static final int width = 32;
	static final int height = 24;
	Image image;
	EnemyType type;
	
	public Enemy(EnemyType type, Field[] path) {
		this.ID = IDCounter++;
		this.type = type;
		this.path = path;
		loadImage(type.label);
		place(path[0].getX(), path[0].getY());
		
		double[] vec = getNextVec();
		xVec = vec[0];
		yVec = vec[1];
	}
	
	public Enemy(EnemyType type, Field[] path, int delay) {
		this.ID = IDCounter++;
		this.type = type;
		this.path = path;
		this.delay = delay;
		loadImage(type.label);
		
		double[] vec = getNextVec();
		xVec = vec[0];
		yVec = vec[1];
	}
		
	public void place(double x, double y) {		
		this.x = x;
		this.y = y;
	}
	
	public void move() {
		if(dead) return;
		
		if(delay > 0) {
			start = false;
			delay--;
			return;
		} else if(!start) {
			start = true;
			place(path[0].getX(), path[0].getY());
			return;
		}
		
		this.x += speed * this.xVec;
		this.y += speed * this.yVec;
		
		if(Map.calculateDistanceToField((int)this.x, (int)this.y, path[currentField+1]) < 5) {
			currentField++;
			
			if(currentField == path.length-1) {
				dead = true;
				return;
			}
			
			double[] vec = getNextVec();
			xVec = vec[0];
			yVec = vec[1];
		}
	}
	
	public void loadImage(String imagePath) {
		Toolkit t = Toolkit.getDefaultToolkit();  
        Image i = t.getImage(imagePath); 
        image = i.getScaledInstance(width, height, Image.SCALE_SMOOTH);
	}
	
	public void draw(Graphics graphics) {
		if(!start) return;
		
		graphics.drawImage(image, (int)x-xOffset, (int)y-yOffset, null);
	}
	
	private double[] getNextVec() {
		double[] vec = new double[2];
		
		int vecX = path[currentField+1].getX()-path[currentField].getX();		
		int vecY = path[currentField+1].getY()-path[currentField].getY();
		
		double len = Math.sqrt(Math.pow(vecX, 2) + Math.pow(vecY, 2));
		
		vec[0] = (vecX / len);
		vec[1] = (vecY / len);
		return vec;
	}
	
	public boolean isDead() {
		return dead;
	}
}

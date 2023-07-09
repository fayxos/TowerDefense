package game.Objects;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import game.Main.GamePanel;
import game.Map.Field;
import game.Map.Map;
import game.Map.PathField;

public class Enemy {
	private static int IDCounter = 0;
	public int ID;
	double x;
	double y;
	public static PathField[] path;
	public static GamePanel gamePanel;
	int currentField = 0;
	
	int delay = 0;
	boolean start = true;
	
	int speed = 3;
	double xVec;
	double yVec;
	
	public int lives = 100;
	public boolean dead = false;
	
	public static final int xOffset = (int)(16*GamePanel.SCALING_FACTOR);
	public static final int yOffset = (int)(20*GamePanel.SCALING_FACTOR);
	static final int width = (int)(32*GamePanel.SCALING_FACTOR);
	static final int height = (int)(24*GamePanel.SCALING_FACTOR);
	Image image;
	EnemyType type;
	
	public static void spawnEnemy(EnemyType type) {
		Enemy enemy = new Enemy(type);
		gamePanel.enemies.add(enemy);
		path[1].enemies.add(enemy);
	}
	
	public static void spawnEnemy(EnemyType type, int delay) {
		Enemy enemy = new Enemy(type, delay);
		gamePanel.enemies.add(enemy);
		path[1].enemies.add(enemy);
	}
	
	private Enemy(EnemyType type) {
		this.ID = IDCounter++;
		this.type = type;
		loadImage(type.label);
		place(path[0].getX(), path[0].getY());
		
		double[] vec = getNextVec();
		xVec = vec[0];
		yVec = vec[1];
	}
	
	private Enemy(EnemyType type, int delay) {
		this.ID = IDCounter++;
		this.type = type;
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
			
			if(!(path[currentField].getY()>path[currentField+1].getY())) {
				path[currentField].enemies.remove(this);
				path[currentField+1].enemies.add(this);
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
	
	public static Enemy getClosestEnemy(int x, int y) {
		Enemy nearestEnemy = null;
		double smallestDistance = 1000;
		
		for(Enemy enemy : gamePanel.enemies) {
			double distanceToEnemy = calculateDistanceToEnemy(x, y, enemy);
			if(distanceToEnemy < smallestDistance) {
				nearestEnemy = enemy;
				smallestDistance = distanceToEnemy;
			}
		}
		
		return nearestEnemy;
		
	}
	
	public static double calculateDistanceToEnemy(int x, int y, Enemy enemy) {
		int xVec = (int)enemy.x - x;
		int yVec = (int)((enemy.y - y)*GamePanel.SCALING_3D_HEIGHT_FACTOR)*2;
		
		double distance = Math.sqrt(Math.pow(xVec, 2) + Math.pow(yVec, 2));
		
		return distance;
	}
}

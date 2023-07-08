package game.Map;

import java.awt.Graphics;
import java.util.ArrayList;

import Objects.Enemy;

public class PathField extends Field {
	PathFieldType type;
	public ArrayList<Enemy> enemies = new ArrayList<Enemy>();
	
	public PathField(PathFieldType type) {
		super();
		this.type = type;
		loadImage(type.path);
	}
	
	@Override
	public void draw(Graphics graphics) {
		super.draw(graphics);
		
		drawEnemies(graphics);
	}
	
	public void drawEnemies(Graphics graphics) {
		for(Enemy enemy : enemies) {
			enemy.draw(graphics);
		}
	}
}

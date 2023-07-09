package game.Objects;

import java.awt.Graphics;

import game.Main.GamePanel;

public class Arrow extends Bullet {

	public Arrow(Enemy enemy, int damage) {
		super(enemy, damage);
		this.imagePath = "assets/Sprites/Tower defender/Archer/arrow.png";
		this.speed = 1;
		loadImage(imagePath, (int)(11*GamePanel.SCALING_FACTOR), (int)(27*GamePanel.SCALING_FACTOR));
	}
	
	@Override
	public void draw(Graphics graphics) {	
		turnImage();
		
		super.draw(graphics);
	}
	
	public void turnImage() {
		
	}

}

package game.Objects;

import java.awt.Graphics;

import game.Main.GamePanel;

public class Arrow extends Bullet {

	public Arrow(Enemy enemy, int damage) {
		super(enemy, damage);
		this.imagePath = "assets/Sprites/Tower defender/Archer/arrow.png";
		this.speed = 20;
		
		loadImage(imagePath, (int)(13*GamePanel.SCALING_FACTOR), (int)(5*GamePanel.SCALING_FACTOR));
		
		xOffset = (int)(13*GamePanel.SCALING_FACTOR/2);
		yOffset = 2;
	}
	
	@Override
	public void draw(Graphics graphics) {	
		turnImage();
		
		super.draw(graphics);
	}
	
	public void turnImage() {
		
	}

}

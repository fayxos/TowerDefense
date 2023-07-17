package game.Objects;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

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
		AffineTransform trans = new AffineTransform();
		double vecX = enemy.x-x;		
		double vecY = enemy.y-y;
		double hypotenuse = Math.sqrt(Math.pow(vecX, 2) + Math.pow(vecY, 2));
		double rotation = Math.asin(vecY/hypotenuse);
		System.out.println(rotation*180/Math.PI);
		trans.translate((int)x-xOffset,(int)y-yOffset);
//		if(vecX<0) rotation += Math.PI/2;
		trans.rotate(rotation);
		((Graphics2D)graphics).drawImage(image, trans, null);
	}

}

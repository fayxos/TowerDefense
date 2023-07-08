package game.Structures;

import java.awt.Color;
import java.awt.Graphics;

import game.Main.GamePanel;

public abstract class ActiveBuilding extends Building {

	int attackRange, attackSpeed, attackDamage;
	
	protected ActiveBuilding() {
		super();
	}
	
	public void draw(Graphics graphics, int x, int y, boolean selected) {
		if(selected) {
			graphics.setColor(new Color(255, 255, 255, 180));
			graphics.fillOval(x-attackRange/2, y-(int)(attackRange*GamePanel.SCALING_3D_HEIGHT_FACTOR)/2, attackRange, (int)(attackRange*GamePanel.SCALING_3D_HEIGHT_FACTOR));
			graphics.setColor(Color.BLACK);
		}

		super.draw(graphics, x, y);
	}

}

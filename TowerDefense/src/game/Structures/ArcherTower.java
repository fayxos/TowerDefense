package game.Structures;

import java.awt.Graphics;
import java.util.ArrayList;

import game.Main.GamePanel;
import game.Map.Field;
import game.Objects.Arrow;
import game.Objects.Bullet;
import game.Objects.Defender;
import game.Objects.DefenderType;
import game.Objects.Enemy;

public class ArcherTower extends ActiveBuilding {
	
	public ArcherTower() {
		super();
		bottomType = StructureType.GREEN_TOWER_BOTTOM_1;
		topType = StructureType.GREEN_TOWER_TOP_2;
		spriteYOffset = (int)(26*GamePanel.SCALING_FACTOR);
		loadStructure();
		
		attackRange = 250;
		attackSpeed = 20;
		attackDamage = 20;
		defender = new Defender(DefenderType.ARCHER);
	}
	
	public void draw(Graphics graphics, int x, int y) {
		super.draw(graphics, x, y);
		defender.draw(graphics, x, y);

	}
	
	public void draw(Graphics graphics, int x, int y, boolean selected) {
		super.draw(graphics, x, y, selected);
		
		if(defender != null) {
			defender.draw(graphics, x, y);
		}
	}
	
	public void updateBullets(Field field) {
		if(attackedEnemy == null) {
			Enemy enemy = Enemy.getClosestEnemy(field.getX(), field.getY());
			
			if(enemy == null) return;
			if(Enemy.calculateDistanceToEnemy(field.getX(), field.getY(), enemy) > attackRange) return;
			
			attackedEnemy = enemy;
			System.out.println("Ein");
		}
		else if(Enemy.calculateDistanceToEnemy(field.getX(), field.getY(), attackedEnemy) > attackRange) {
			attackedEnemy = null;
			System.out.println("Aus");
		}
		else {
			
			if(attackTick % attackSpeed == 0) {
				
				Arrow arrow = new Arrow(attackedEnemy, attackDamage);
				arrow.place(field.getX(), field.getY());
				bullets.add(arrow);
				field.bullets.add(arrow);	
				
			}
			
			attackTick++;
			
			moveBullets();
		}
	}

}

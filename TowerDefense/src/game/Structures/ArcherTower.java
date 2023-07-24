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
		
		level = 1;
		maxLevel = 3;
		
		bottomType = new StructureType[maxLevel];
		bottomType[0] = StructureType.GREEN_TOWER_BOTTOM_1;
		bottomType[1] = StructureType.YELLOW_TOWER_BOTTOM_1;
		bottomType[2] = StructureType.RED_TOWER_BOTTOM_1;
		topType = new StructureType[maxLevel];
		topType[0] = StructureType.GREEN_TOWER_TOP_2;
		topType[1] = StructureType.YELLOW_TOWER_TOP_2;
		topType[2] = StructureType.RED_TOWER_TOP_2;
		
		spriteYOffset = (int)(26*GamePanel.SCALING_FACTOR);
		loadStructure();
		assignStats();
		
		defender = new Defender(DefenderType.ARCHER);
	}
	
	@Override
	protected void assignStats() {
		switch (level) {
		case 1:
			attackRange = 250;
			attackSpeed = 20;
			attackDamage = 20;
			break;
		case 2:
			attackRange = 300;
			attackSpeed = 18;
			attackDamage = 22;
			break;
		case 3:
			attackRange = 350;
			attackSpeed = 16;
			attackDamage = 24;
			break;
		}
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
		}
		else if(attackedEnemy.isDead()) {
			attackedEnemy = null;
		}
		else if(Enemy.calculateDistanceToEnemy(field.getX(), field.getY(), attackedEnemy) > attackRange) {
			attackedEnemy = null;
		}
		else {
			
			if(attackTick % attackSpeed == 0) {
				
				Arrow arrow = new Arrow(attackedEnemy, attackDamage);
				arrow.place(field.getX(), field.getY()-80);
				bullets.add(arrow);
				field.bullets.add(arrow);	
				
			}
			
			attackTick++;
			
			moveBullets();
		}
	}

}

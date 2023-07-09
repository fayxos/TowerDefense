package game.Structures;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import game.Main.GamePanel;
import game.Map.Field;
import game.Objects.Arrow;
import game.Objects.Bullet;
import game.Objects.Defender;
import game.Objects.Enemy;

public abstract class ActiveBuilding extends Building {

	public Defender defender;
	
	public Enemy attackedEnemy;
	public ArrayList<Bullet> bullets = new ArrayList<Bullet>(); 
	
	int attackRange, attackSpeed, attackDamage;
	int attackTick = 0;
	
	protected ActiveBuilding() {
		super();
	}
	
	public void draw(Graphics graphics, int x, int y) {
		this.draw(graphics, x, y, false);
	}
	
	public void draw(Graphics graphics, int x, int y, boolean selected) {
		if(selected) {
			graphics.setColor(new Color(255, 255, 255, 180));
			graphics.fillOval(x-attackRange, y-(int)(attackRange*GamePanel.SCALING_3D_HEIGHT_FACTOR), attackRange*2, (int)(attackRange*2*GamePanel.SCALING_3D_HEIGHT_FACTOR));
			graphics.setColor(Color.BLACK);
		}

		super.draw(graphics, x, y);
		
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
			if(attackedEnemy.isDead()) {
				attackedEnemy = null;
			}	
			else if(attackTick % attackSpeed == 0) {
				
				Bullet bullet = new Bullet(attackedEnemy, attackDamage);
				bullet.place(field.getX(), field.getY());
				bullets.add(bullet);
				field.bullets.add(bullet);	
				
			}
			
			attackTick++;
			
			moveBullets();
			
		}
	}
	
	public void moveBullets() {
		ArrayList<Bullet> newBullets = new ArrayList<Bullet>();
				
		for(Bullet bullet : bullets) {
			bullet.move();
			
			if(bullet.enemy.isDead()) {
				bullet.enemy = null;
				bullet.shouldRemove = true;
			}
			else if(Enemy.calculateDistanceToEnemy((int)bullet.getX(), (int)bullet.getY(), bullet.enemy) < 10) {
				bullet.enemy.lives -= bullet.damage;
					
				bullet.shouldRemove = true;
				
				if(bullet.enemy.lives <= 0) bullet.enemy.dead = true;
			} else {
				newBullets.add(bullet);
			}
			
		}
		
		bullets = newBullets;
	}

}

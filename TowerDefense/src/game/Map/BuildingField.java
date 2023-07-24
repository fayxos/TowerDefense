package game.Map;

import java.awt.Graphics;

import javax.swing.JButton;

import game.Structures.Structure;
import game.Main.GameState;
import game.Objects.Arrow;
import game.Objects.Bullet;
import game.Structures.ActiveBuilding;
import game.Structures.ArcherTower;
import game.Structures.Building;
import game.Structures.Obstacle;

public class BuildingField extends Field {
	private Structure structure;
	final String imagePath = "assets/Sprites/Environment tiles/ground.png";
	
	public BuildingField() {
		super();
		loadImage(imagePath);
	}
	
	public BuildingField(Structure structure) {
		this();
		this.structure = structure;
	}
	
	public void setStructure(Structure structure) {
		this.structure = structure;
	}
	
	public void update() {
		if(structure == null) return;
		if(!(structure instanceof ActiveBuilding)) return;
		
		
		ActiveBuilding building = (ActiveBuilding)structure;
		
		if(building instanceof ArcherTower) {
			ArcherTower tower = (ArcherTower)building;
			tower.updateBullets(this);
		} else {
			building.updateBullets(this);
		}
	}
	
	@Override
	public void draw(Graphics graphics) {
		int move = 0;
		if(Field.SelectedField != null) {
			if(Field.SelectedField.ID == ID) {
				move = 5;
			}
		}
		else if(Field.HighlightedField != null) {
			if(Field.HighlightedField.ID == ID) {
				move = 5;
			}
		}

		graphics.drawImage(image, x-xOffset, y-yOffset-move, null);
		
		for(Bullet bullet : bullets) {
			
			if(bullet instanceof Arrow) {
				Arrow arrow = (Arrow)bullet;
				arrow.draw(graphics);
			} else {
				bullet.draw(graphics);
			}
		}
		
		bullets.clear();
		
		if(structure != null) {
			
			if(move != 0 && structure instanceof ActiveBuilding) return;
				
			structure.draw(graphics, x, y-move);
		} 			
	}
	
	public void drawBuilding(Graphics graphics) {
		if(structure == null) return;
		if(!(structure instanceof ActiveBuilding)) return;
		
		int move = 0;
		if(Field.SelectedField != null) {
			if(Field.SelectedField.ID == ID) {
				move = 5;
			}
		}
		else if(Field.HighlightedField != null) {
			if(Field.HighlightedField.ID == ID) {
				move = 5;
			}
		}
		
		ActiveBuilding building = (ActiveBuilding)structure;
		building.draw(graphics, x, y-move, true);
	}
	
	public boolean configureActionButton(JButton button) {		
		if(structure instanceof Obstacle) {
			Obstacle obstacle = (Obstacle)structure;
			
			button.setText("Remove " + obstacle.removingCost + " Gold");
			button.setBounds(x+20, y-100, 150, 40);
			
			return true;
		} 
		else if(structure instanceof Building) {
			Building building = (Building)structure;
			
			if(!building.isUpgradeable()) {
				return false;
			}
			
			if(building.upgradeCost == null) return false;
			
			button.setText("Upgrade " + building.upgradeCost[building.level+1] + " Gold");
			button.setBounds(x+20, y-150, 160, 40);
			
			return true;
		}
			
		return false;
	}
	
	public boolean performAction() {
		if(structure instanceof Obstacle) {
			Obstacle obstacle = (Obstacle)structure;
			
			if(obstacle.removingCost <= GameState.gold) {
				GameState.gold -= obstacle.removingCost;
				structure = null;
			}
			
			return true;
		} 
		else if(structure instanceof Building) {
			Building building = (Building)structure;
			
			if(building.isUpgradeable() || building.upgradeCost[building.level] <= GameState.gold) {
				GameState.gold -= building.upgradeCost[building.level];
				building.upgrade();
			}
			
			return false;
		}
			
		return true;
	}
	
	public boolean hasStructure() {
		return structure != null;
	}
	
	public Structure getStructure() {
		return structure;
	}
}

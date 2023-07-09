package game.Map;

import java.awt.Graphics;

import game.Structures.Structure;
import game.Objects.Arrow;
import game.Objects.Bullet;
import game.Structures.ActiveBuilding;
import game.Structures.ArcherTower;

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
		building.updateBullets(this);
	}
	
	@Override
	public void draw(Graphics graphics) {
		int move = 0;
		if(Field.HighlightedField != null) {
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
		
		if(structure != null) {
			
			if(move != 0 && structure instanceof ActiveBuilding) return;
				
			structure.draw(graphics, x, y-move);
		} 			
	}
	
	public void drawBuilding(Graphics graphics) {
		if(structure == null) return;
		if(!(structure instanceof ActiveBuilding)) return;
		
		int move = 0;
		if(Field.HighlightedField != null) {
			if(Field.HighlightedField.ID == ID) {
				move = 5;
			}
		}
		
		ActiveBuilding building = (ActiveBuilding)structure;
		building.draw(graphics, x, y-move, true);
	}
	
	public boolean hasStructure() {
		return structure != null;
	}
}

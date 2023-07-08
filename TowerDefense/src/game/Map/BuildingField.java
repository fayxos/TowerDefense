package game.Map;

import java.awt.Graphics;

import game.Structures.Structure;
import game.Structures.ActiveBuilding;

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
	
	@Override
	public void draw(Graphics graphics) {
		int move = 0;
		if(Field.HighlightedField != null) {
			if(Field.HighlightedField.ID == ID) {
				move = 5;
			}
		}


		graphics.drawImage(image, x-xOffset, y-yOffset-move, null);
		
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

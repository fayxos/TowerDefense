package game.Map;

import java.awt.Graphics;

import game.Main.GameFrame;
import game.Structures.Building;
import game.Structures.Obstacle;
import game.Structures.Structure;

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
		if(Field.HighlightedID == ID) {
			move = 5;
		}

		graphics.drawImage(image, x-xOffset, y-yOffset-move, null);
		
		if(structure != null) {
			structure.draw(graphics, x, y-move);
		} 
				
	}
}

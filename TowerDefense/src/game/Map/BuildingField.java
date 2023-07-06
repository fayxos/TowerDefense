package game.Map;

import java.awt.Graphics;

import game.Main.GameFrame;
import game.Objects.Building;
import game.Objects.Obstacle;

public class BuildingField extends Field {
	Building building;
	final String imagePath = "assets/Sprites/Environment tiles/ground.png";
	
	public BuildingField() {
		loadImage(imagePath);
	}
	
	@Override
	public void draw(Graphics graphics) {
		int move = 0;
		if(Field.HighlightedID == ID) {
			move = 5;
		}

		graphics.drawImage(image, x-xOffset, y-yOffset-move, null);
		
		if(building != null) {
			//building.draw(graphics, canvas)
		} 
				
	}
}

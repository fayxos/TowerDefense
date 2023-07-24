package game.Map;

import java.awt.Graphics;

import game.Main.GamePanel;
import game.Objects.Bullet;
import game.Structures.*;

public class Map {
	public Field[][] fields = new Field[7][7];
	int xStart;
	int yStart;
	
	public Map(int xStart, int yStart) {
		this.xStart = xStart;
		this.yStart = yStart;
		build();
	}
	
	private void build() {
		fields[0][0] = new BuildingField(new Stone(StructureType.GREY_STONE_S));
		fields[0][1] = new BuildingField(new Tree(StructureType.LAYERED_TREE_L));
		fields[0][2] = new EnvironmentField(EnvironmentFieldType.BOTTOM_LEFT_TO_BOTTOM_RIGHT_CURVE);
		fields[0][3] = new EnvironmentField(EnvironmentFieldType.BOTTOM_LEFT_TO_TOP_RIGHT_PATH);
		fields[0][4] = new EnvironmentField(EnvironmentFieldType.BOTTOM_RIGHT_TO_TOP_RIGHT_CURVE);
		fields[0][5] = new BuildingField();
		fields[0][6] = new BuildingField();
		
		fields[1][0] = new BuildingField(new Stone(StructureType.BROWN_STONE_SL));
		fields[1][1] = new BuildingField();
		fields[1][2] = new EnvironmentField(EnvironmentFieldType.TOP_LEFT_TO_BOTTOM_RIGHT_PATH);
		fields[1][3] = new PathField(PathFieldType.BOTTOM_RIGHT_TO_TOP_LEFT_END);
		fields[1][4] = new EnvironmentField(EnvironmentFieldType.TOP_LEFT_TO_BOTTOM_RIGHT_PATH);
		fields[1][5] = new BuildingField(new Tree(StructureType.STRAIGHT_TREE_S));
		fields[1][6] = new BuildingField();
		
		fields[2][0] = new BuildingField();
		fields[2][1] = new BuildingField();
		fields[2][2] = new EnvironmentField(EnvironmentFieldType.TOP_LEFT_TO_BOTTOM_RIGHT_PATH);
		fields[2][3] = new PathField(PathFieldType.TOP_LEFT_TO_BOTTOM_RIGHT_PATH);
		fields[2][4] = new EnvironmentField(EnvironmentFieldType.TOP_LEFT_TO_BOTTOM_RIGHT_PATH);
		fields[2][5] = new BuildingField();
		fields[2][6] = new BuildingField(new Stone(StructureType.GREY_STONE_L));
		
		fields[3][0] = new PathField(PathFieldType.BOTTOM_LEFT_TO_TOP_RIGHT_END);
		fields[3][1] = new PathField(PathFieldType.BOTTOM_LEFT_TO_TOP_RIGHT_PATH);
		fields[3][2] = new PathField(PathFieldType.BOTTOM_LEFT_TO_TOP_RIGHT_BRIDGE);
		fields[3][3] = new PathField(PathFieldType.TOP_LEFT_TO_TOP_RIGHT_AND_BOTTOM_RIGHT_CROSSING);
		fields[3][4] = new EnvironmentField(EnvironmentFieldType.TOP_LEFT_TO_BOTTOM_RIGHT_PATH);
		fields[3][5] = new BuildingField(new ArcherTower());
		fields[3][6] = new BuildingField();
		
		fields[4][0] = new BuildingField();
		fields[4][1] = new BuildingField();
		fields[4][2] = new EnvironmentField(EnvironmentFieldType.TOP_LEFT_TO_BOTTOM_RIGHT_END);
		fields[4][3] = new PathField(PathFieldType.BOTTOM_LEFT_TO_TOP_LEFT_CURVE);
		fields[4][4] = new PathField(PathFieldType.BOTTOM_LEFT_TO_TOP_RIGHT_BRIDGE);
		fields[4][5] = new PathField(PathFieldType.BOTTOM_RIGHT_TO_TOP_RIGHT_CURVE);
		fields[4][6] = new BuildingField(new Tree(StructureType.STRAIGHT_TREE_L));
		
		fields[5][0] = new BuildingField(new Tree(StructureType.STRAIGHT_TREE_L));
		fields[5][1] = new BuildingField();
		fields[5][2] = new BuildingField(new Stone(StructureType.GREY_STONE_SLS));
		fields[5][3] = new BuildingField();
		fields[5][4] = new EnvironmentField(EnvironmentFieldType.TOP_LEFT_TO_BOTTOM_RIGHT_END);
		fields[5][5] = new PathField(PathFieldType.TOP_LEFT_TO_BOTTOM_RIGHT_PATH);
		fields[5][6] = new BuildingField();
		
		fields[6][0] = new BuildingField();
		fields[6][1] = new BuildingField();
		fields[6][2] = new BuildingField();
		fields[6][3] = new BuildingField();
		fields[6][4] = new BuildingField(new Tree(StructureType.LAYERED_TREE_S));
		fields[6][5] = new PathField(PathFieldType.TOP_LEFT_TO_BOTTOM_RIGHT_END);
		fields[6][6] = new BuildingField();
		
		int xCurrent = xStart;
		int yCurrent = yStart;
		for(int row=0; row<fields.length; row++) {
			for(int column=0; column<fields[row].length; column++) {
				if (fields[row][column] == null) return;
				fields[row][column].place(xCurrent-(column*(Field.xOffset)), yCurrent+(column*(Field.yOffset-1)));
			}
			xCurrent += (Field.xOffset);
			yCurrent += (Field.yOffset-1);
		}
	}
	
	public void draw(Graphics graphics) {
		for(int row=0; row<fields.length; row++) {
			for(int column=0; column<fields[row].length; column++) {
				if (fields[row][column] == null) return;
				fields[row][column].draw(graphics);
			}
		}
		
		if(Field.SelectedField != null) {
			Field.SelectedField.drawBuilding(graphics);
		}
		else if(Field.HighlightedField instanceof BuildingField) {
			BuildingField highlightedField = (BuildingField)Field.HighlightedField;
			highlightedField.drawBuilding(graphics);
		} 
	}
	
	public Field getFieldFromPosition(int x, int y) {
		Field nearestField = null;
		double smallestDistance = 1000;
		
		for(int row=0; row<fields.length; row++) {
			for(int column=0; column<fields[row].length; column++) {
				if (fields[row][column] == null) return null;
				double distanceToField = calculateDistanceToField(x, y, fields[row][column]);
				if(distanceToField <= Field.xOffset) {
					if(nearestField == null) {
						nearestField = fields[row][column];
						smallestDistance = distanceToField;
					} 
					else if(distanceToField < smallestDistance) {
						nearestField = fields[row][column];
						smallestDistance = distanceToField;
					}
				}
			}
		}
		
		return nearestField;
	}
	
	public static double calculateDistanceToField(int x, int y, Field field) {
		int xVec = field.x - x;
		int yVec = (int)((field.y - y)*GamePanel.SCALING_3D_HEIGHT_FACTOR)*2;
		
		double distance = Math.sqrt(Math.pow(xVec, 2) + Math.pow(yVec, 2));
		
		return distance;
	}
	
}

package game.Map;
import java.awt.*;


public class Field {
	private static int IDCounter = 0;
	public static int HighlightedID = -1;
	public int ID;
	int x;
	int y;
	public static final int xOffset = 50;
	public static final int yOffset = 30;
	static final int width = 103;
	static final int height = 100;
	Image image;
		
	public void place(int x, int y) {
		this.ID = IDCounter++;
		this.x = x;
		this.y = y;
	}
	
	public void loadImage(String imagePath) {
		Toolkit t = Toolkit.getDefaultToolkit();  
        Image i = t.getImage(imagePath); 
        image = i.getScaledInstance(width, height, Image.SCALE_SMOOTH);
	}
	
	public void draw(Graphics graphics) {
		graphics.drawImage(image, x-xOffset, y-yOffset-move, null);
	}
	
}

package game.Map;
import java.awt.*;


public class Field {
	private static int IDCounter = 0;
	public static Field HighlightedField = null;
	public int ID;
	int x;
	int y;
	public static final int xOffset = 50;
	public static final int yOffset = 30;
	static final int width = 103;
	static final int height = 100;
	Image image;
	
	public Field() {
		this.ID = IDCounter++;
	}
		
	public void place(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void loadImage(String imagePath) {
		Toolkit t = Toolkit.getDefaultToolkit();  
        Image i = t.getImage(imagePath); 
        image = i.getScaledInstance(width, height, Image.SCALE_SMOOTH);
	}
	
	public void draw(Graphics graphics) {
		graphics.drawImage(image, x-xOffset, y-yOffset, null);
	}
	
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
}

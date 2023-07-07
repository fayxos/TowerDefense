package game.Main;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class GameState {
    static int lives = 100;
    static int gold = 100;
    static boolean gameOver = false;

    static Image heartImage;
    static Image goldImage;
    
    static Image gameOverImage;
    
    static int xOffset = 20;
    static int yOffset = 30;
    
    public static void start() {
    	heartImage = GameState.loadImage("assets/heart.png", 40, 40);
    	goldImage = GameState.loadImage("assets/gold.png", 40, 40);
    	gameOverImage = GameState.loadImage("assets/game_over.png", GamePanel.PANEL_SIZE.height, GamePanel.PANEL_SIZE.height);

    	lives = 100;
        gold = 100;
        gameOver = false;
    }
    
	public static Image loadImage(String imagePath, int width, int height) {
		Toolkit t = Toolkit.getDefaultToolkit();  
        Image i = t.getImage(imagePath); 
        return i.getScaledInstance(width, height, Image.SCALE_SMOOTH);
	}
	
	public static void draw(Graphics graphics) {
		graphics.setFont(new Font("TimesRoman", Font.BOLD, 30));
		
		graphics.drawImage(heartImage, 60-xOffset, 60-yOffset, null);
		graphics.drawString(Integer.toString(lives), 90, 60);
		
		graphics.drawImage(goldImage, 60-xOffset, 110-yOffset, null);
		graphics.drawString(Integer.toString(gold), 90, 110);
				
		if(gameOver) {
			graphics.drawImage(gameOverImage, (GamePanel.PANEL_SIZE.width-GamePanel.PANEL_SIZE.height)/2, 0, null);
		}
	}
}

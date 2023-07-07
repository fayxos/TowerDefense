package game.Main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.Timer;

import game.Map.Field;
import game.Map.Map;
import game.Objects.Enemy;
import game.Objects.EnemyType;

class GamePanel extends JPanel implements ActionListener, KeyListener, MouseMotionListener {
    private static final long serialVersionUID = 1L;
    public static final Dimension PANEL_SIZE = new Dimension(1500, 900);
    private static final int REFRESH_RATE = 50;

    private Timer timer = new Timer(REFRESH_RATE, this);
        
    private Map map;
    private int[][] path = {
		{3, 0}, {3, 1}, {3, 2}, {3, 3}, {2, 3}, {1, 3}, {2, 3}, {3, 3}, {4, 3}, {4, 4}, {4, 5}, {5, 5}, {6, 5}
    };
    private Field[] pathFields;
    
    private ArrayList<Enemy> enemies = new ArrayList<Enemy>();

    public GamePanel() {
        addKeyListener(this);
        addMouseMotionListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        setBackground(Color.GREEN);
        
        GameState.start();
        this.map = new Map(PANEL_SIZE.width/2, PANEL_SIZE.height/6);
        
        this.pathFields = new Field[path.length];
        for(int i = 0; i<path.length; i++) {
        	this.pathFields[i] = this.map.fields[path[i][0]][path[i][1]];
        }
        
        this.enemies.add(new Enemy(EnemyType.GREEN_UFO, pathFields));
        this.enemies.add(new Enemy(EnemyType.GREY_UFO, pathFields, 10));
        this.enemies.add(new Enemy(EnemyType.PRUPLE_UFO, pathFields, 20));
        this.enemies.add(new Enemy(EnemyType.RED_UFO, pathFields, 40));
        this.enemies.add(new Enemy(EnemyType.GREEN_UFO, pathFields, 60));
        this.enemies.add(new Enemy(EnemyType.GREY_UFO, pathFields, 70));
        this.enemies.add(new Enemy(EnemyType.PRUPLE_UFO, pathFields, 80));
        this.enemies.add(new Enemy(EnemyType.RED_UFO, pathFields, 90));
        this.enemies.add(new Enemy(EnemyType.GREEN_UFO, pathFields, 110));
        this.enemies.add(new Enemy(EnemyType.GREY_UFO, pathFields, 115));
        this.enemies.add(new Enemy(EnemyType.PRUPLE_UFO, pathFields, 120));
        this.enemies.add(new Enemy(EnemyType.RED_UFO, pathFields, 150));
        this.enemies.add(new Enemy(EnemyType.GREEN_UFO, pathFields, 160));
        this.enemies.add(new Enemy(EnemyType.GREY_UFO, pathFields, 180));
        this.enemies.add(new Enemy(EnemyType.PRUPLE_UFO, pathFields, 220));
        this.enemies.add(new Enemy(EnemyType.RED_UFO, pathFields, 240));
        
        timer.start();      
    }

    public Dimension getPreferredSize() {
        return PANEL_SIZE;
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        this.map.draw(g);

        for(int i=0; i<enemies.size(); i++) { 	
        	enemies.get(i).draw(g);
        }
                
        GameState.draw(g);
    }

    // Timer
    public void actionPerformed(ActionEvent e) { 
    	if(GameState.gameOver) {
    		repaint();
    		return;
    	}
    	
    	for(Enemy enemy : enemies) {
        	enemy.move();
        }
    	
    	for(int i=0; i<enemies.size(); i++) {
        	if(enemies.get(i).isDead()) {
        		GameState.lives--;
        		enemies.remove(i);
        		
        		if(GameState.lives == 0) {
        			GameState.gameOver = true;
        		}
        	}
        }
    	    	
        repaint();
    }
    
    public void mouseMoved(MouseEvent e) {
       Field selectedField = map.getFieldFromPosition(e.getX(), e.getY());
       if(selectedField == null) Field.HighlightedID = -1;
       else Field.HighlightedID = selectedField.ID;
    }

    public void mouseDragged(MouseEvent e) {
    	
	}

    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        if(code == KeyEvent.VK_LEFT) {
        }
        else if(code == KeyEvent.VK_RIGHT) {
        }
        else if(code == KeyEvent.VK_UP) {
        }
        else {
            if(code == KeyEvent.VK_DOWN) {
            }
        }
    }

    public void keyTyped(KeyEvent e) {}
    public void keyReleased(KeyEvent e) {}
}
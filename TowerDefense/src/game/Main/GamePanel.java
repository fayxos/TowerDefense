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
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.Timer;

import game.Map.BuildingField;
import game.Map.Field;
import game.Map.Map;
import game.Map.PathField;
import game.Objects.Enemy;
import game.Objects.EnemyType;
import game.Structures.ActiveBuilding;
import game.Structures.ArcherTower;
import game.Structures.Building;

public class GamePanel extends JPanel implements ActionListener, KeyListener, MouseMotionListener, MouseListener {
    private static final long serialVersionUID = 1L;
    public static final Dimension PANEL_SIZE = new Dimension(1500, 900);
    private static final int REFRESH_RATE = 50;
    public static final double SCALING_3D_HEIGHT_FACTOR = 0.566;
    public static final double SCALING_FACTOR = 1.2;

    private Timer timer = new Timer(REFRESH_RATE, this);
            
    private Map map;
    private int[][] path = {
		{3, 0}, {3, 1}, {3, 2}, {3, 3}, {2, 3}, {1, 3}, {2, 3}, {3, 3}, {4, 3}, {4, 4}, {4, 5}, {5, 5}, {6, 5}
    };
    private PathField[] pathFields;
    
    public ArrayList<Enemy> enemies = new ArrayList<Enemy>();
    int mouseX = -50;
    int mouseY = -50;
    
    private Building newBuilding;

    public GamePanel() {
        addKeyListener(this);
        addMouseMotionListener(this);
        addMouseListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        setBackground(Color.GREEN);
                
        GameState.start();
        this.map = new Map(PANEL_SIZE.width/2, PANEL_SIZE.height/7);
        
        this.pathFields = new PathField[path.length];
        for(int i = 0; i<path.length; i++) {
        	this.pathFields[i] = (PathField)this.map.fields[path[i][0]][path[i][1]];
        }
        
        Enemy.path = pathFields;
        Enemy.gamePanel = this;
        
        Enemy.spawnEnemy(EnemyType.GREEN_UFO);
        Enemy.spawnEnemy(EnemyType.GREY_UFO, 10);
        Enemy.spawnEnemy(EnemyType.PRUPLE_UFO, 20);
        Enemy.spawnEnemy(EnemyType.RED_UFO, 40);
        Enemy.spawnEnemy(EnemyType.GREEN_UFO, 60);
        Enemy.spawnEnemy(EnemyType.GREY_UFO, 70);
        Enemy.spawnEnemy(EnemyType.PRUPLE_UFO, 80);
        Enemy.spawnEnemy(EnemyType.RED_UFO, 90);
        Enemy.spawnEnemy(EnemyType.GREEN_UFO, 110);
        Enemy.spawnEnemy(EnemyType.GREY_UFO, 115);
        Enemy.spawnEnemy(EnemyType.PRUPLE_UFO, 120);
        Enemy.spawnEnemy(EnemyType.RED_UFO, 150);
        Enemy.spawnEnemy(EnemyType.GREEN_UFO, 160);
        Enemy.spawnEnemy(EnemyType.GREY_UFO, 180);
        Enemy.spawnEnemy(EnemyType.PRUPLE_UFO, 220);
        Enemy.spawnEnemy(EnemyType.RED_UFO, 240);
        
        timer.start();      
    }

    public Dimension getPreferredSize() {
        return PANEL_SIZE;
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        this.map.draw(g);
                
        GameState.draw(g);
        
        if(newBuilding != null) {
        	if(newBuilding instanceof ActiveBuilding) {
        		ActiveBuilding building = (ActiveBuilding)newBuilding;
        		building.draw(g, mouseX, mouseY, true);
        	} else {
            	newBuilding.draw(g, mouseX, mouseY);
        	}
        }
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
    	
    	for(int i=0; i<pathFields.length; i++) {
    		for(int j=0; j<pathFields[i].enemies.size(); j++)
        	if(pathFields[i].enemies.get(j).isDead()) {
        		GameState.lives--;
        		enemies.remove(pathFields[i].enemies.get(j));
        		pathFields[i].enemies.remove(j);
        		
        		if(GameState.lives == 0) {
        			GameState.gameOver = true;
        		}
        	}
        }
    	    	
        repaint();
    }
    
    public void mouseMoved(MouseEvent e) {
        Field selectedField = map.getFieldFromPosition(e.getX(), e.getY());
        if(selectedField == null) Field.HighlightedField = null;
        else Field.HighlightedField = selectedField;
    }

    public void mouseDragged(MouseEvent e) {
		Field selectedField = map.getFieldFromPosition(e.getX(), e.getY());
		if(selectedField == null) Field.HighlightedField = null;
		else if(selectedField instanceof BuildingField) {
			BuildingField field = (BuildingField)selectedField;
			if(!field.hasStructure()) {
				Field.HighlightedField = selectedField;
			}
		} else {
			Field.HighlightedField = null;
		}
		
		if(newBuilding == null && selectedField == null) {
			newBuilding = new ArcherTower();
		} 
		
		mouseX = e.getX();
		mouseY = e.getY();
	}
    
    @Override
    public void mouseReleased(MouseEvent e) {
    	System.out.println("test");
    	Field selectedField = map.getFieldFromPosition(e.getX(), e.getY());
    	if(selectedField instanceof BuildingField && newBuilding != null) {
			BuildingField field = (BuildingField)selectedField;
			if(!field.hasStructure()) {
				field.setStructure(newBuilding);
			}
        }
    	
    	Field.HighlightedField = null;
        
        newBuilding = null;
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

    
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
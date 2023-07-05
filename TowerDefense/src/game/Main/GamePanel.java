package game.Main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

import game.Map.Map;
import game.Objects.Enemy;

class GamePanel extends JPanel implements ActionListener, KeyListener {
    private static final long serialVersionUID = 1L;
    private static final Dimension PANEL_SIZE = new Dimension(1500, 900);
    private static final int REFRESH_RATE = 10;

    private Timer timer = new Timer(REFRESH_RATE, this);
    
    private Map map;
    private Enemy[] enemies;
    
    int i = 0;

    public GamePanel() {
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        setBackground(Color.GREEN);
        
        this.map = new Map(PANEL_SIZE.width/2, PANEL_SIZE.height/6);
        
        timer.start();      
    }

    public Dimension getPreferredSize() {
        return PANEL_SIZE;
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        this.map.draw(g);
    }

    // Timer
    public void actionPerformed(ActionEvent e) {
        repaint();
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
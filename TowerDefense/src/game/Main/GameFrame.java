package game.Main;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

public class GameFrame extends JFrame {
    private static final long serialVersionUID = 1L;

    public GameFrame() {
        super("Tower Defense");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().add(new GamePanel(), BorderLayout.CENTER);
        pack();
        setResizable(false);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {    
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new GameFrame();
                frame.setVisible(true);
            }
        });     
    }
}
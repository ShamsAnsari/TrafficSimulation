

import javax.swing.*;
import java.util.Scanner;

/**
 *
 */
public class GameWindow extends JFrame {
    public static final int WIDTH = 1280;
    public static final int HEIGHT = 720;
    public static int numCars;
    public static int numTowers = 3;


    /**
     *
     */
    public GameWindow() {
        setTitle("TrafficSimulation");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GamePanel g = new GamePanel(WIDTH, HEIGHT);
        setContentPane(g);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);

    }

    /**
     * Main method
     * @param args not used
     */
    public static void main(String[] args) { ;
        new GameWindow();
    }
}



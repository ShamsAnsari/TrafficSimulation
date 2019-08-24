

import javax.swing.*;

public class GameWindow extends JFrame {
    public static final int WIDTH = 1280;
    public static final  int HEIGHT = 720;


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

    public static void main(String[] args) {
        new GameWindow();
    }
}



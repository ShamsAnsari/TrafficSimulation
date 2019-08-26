

import javax.swing.*;
import java.util.Scanner;

public class GameWindow extends JFrame {
    public static final int WIDTH = 1280;
    public static final int HEIGHT = 720;
    public static int numCars;
    public static int numTowers;


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
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of cars: ");
        numCars = input.nextInt();
        System.out.print("Enter the number of towers: ");
        numTowers = input.nextInt();
        new GameWindow();
    }
}



import javax.swing.*;
import java.awt.*;

/**
 * Contains main gameloop
 */
public class GamePanel extends JPanel implements Runnable {


    private boolean isRunning;
    private Thread thread;
    private Grid grid;
    private Controls controls;

    //==================================================================================================================
    //*****************************************************CONSTRUCTORS*************************************************
    //==================================================================================================================

    public GamePanel(int width, int height) {
        setPreferredSize(new Dimension(width, height));
        initGrid();
        controls = new Controls(grid);
    }
    //==================================================================================================================
    //*************************************************PUBLIC METHODS***************************************************
    //==================================================================================================================

    @Override
    /**
     * Low level thread stuff
     */
    public void addNotify() {
        super.addNotify();
        if (thread == null) {
            thread = new Thread(this, "GameThread");
            thread.start();
        }

    }

    @Override
    /**
     * Gameloop
     */
    public void run() {
        isRunning = true;
        int REFRESH_RATE = 60;
        while (isRunning) {
            repaint();
            update();

            try {
                thread.sleep(1000 / REFRESH_RATE);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }

    public void update() {
        grid.update();
    }


    @Override
    public void paint(Graphics g) {
        grid.render(g);
    }
    //==================================================================================================================
    //*************************************************PRIVATE METHODS***************************************************
    //==================================================================================================================



    private void initGrid() {
        grid = new Grid();

        grid.setNumCars(GameWindow.numCars);
        grid.initTower(GameWindow.numTowers);

    }

}

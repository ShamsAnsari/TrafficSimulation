import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {


    private boolean isRunning;
    private Thread thread;
    private Grid grid;


    public GamePanel(int width, int height) {

        setPreferredSize(new Dimension(width, height));

        initGrid();
    }

    private void initCars(int numCars) {
        for (int i = 0; i < numCars; i++) {

            int speed = 1;
            int radius = 3;
            int locX = (int) (Math.random() * GameWindow.WIDTH);
            int locY = (int) (Math.random() * GameWindow.HEIGHT);

            Point des = Car.calculateSidePoint();

            Car car = new Car(new Point(locX, locY), des, speed, radius, Color.BLACK);
            grid.addCar(car);
        }
    }

    private void initTower(int numTowers) {
        for (int i = 0; i < numTowers; i++) {

            int locX = (int) (Math.random() * GameWindow.WIDTH);
            int locY = (int) (Math.random() * GameWindow.HEIGHT);

            int r = (int) (Math.random() * 255);
            int g = (int) (Math.random() * 255);
            int b = (int) (Math.random() * 255);


            Tower tower = new Tower(0, new Point(locX, locY), new Color(r, g, b));
            grid.addTower(tower);
        }
    }

    private void initGrid() {
        grid = new Grid();

        initCars(GameWindow.numCars);
        initTower(GameWindow.numTowers);

    }

    @Override
    public void addNotify() {
        super.addNotify();
        if (thread == null) {
            thread = new Thread(this, "GameThread");
            thread.start();
        }

    }

    @Override
    public void run() {
        isRunning = true;
        while (isRunning) {
            repaint();
            update();

            try {
                thread.sleep(1000 / 30);
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
}

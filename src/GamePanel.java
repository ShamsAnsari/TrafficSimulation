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


            int speed, radius;
            speed = radius = 5;

            Car car = new Car(new Point(0, 0), new Point(0, 0), speed, radius, Color.BLACK);
            grid.addCar(car);
        }

    }

    private void initGrid() {
        grid = new Grid();

        initCars(1000);

        Tower tower = new Tower(0, new Point(GameWindow.WIDTH / 4, 3 * GameWindow.HEIGHT / 4), Color.RED);
        Tower tower1 = new Tower(0, new Point(GameWindow.WIDTH / 2, GameWindow.HEIGHT / 4), Color.GREEN);
        Tower tower2 = new Tower(0, new Point(3 * GameWindow.WIDTH / 4, 3 * GameWindow.HEIGHT / 4), Color.BLUE);

        grid.addTower(tower);
        grid.addTower(tower1);
        grid.addTower(tower2);


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

    private void update() {
        grid.update();
    }


    @Override
    public void paint(Graphics g) {
        grid.render(g);
    }
}

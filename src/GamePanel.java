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

    private void initGrid() {
        grid = new Grid();

        for (int i = 0; i < 1000; i++) {
//            int r = (int) (Math.random() * 255);
//            int g = (int) (Math.random() * 255);
//            int b = (int) (Math.random() * 255);
            int r = 0;
            int g = 0;
            int b = 0;
            int locX = (int) (Math.random() * GameWindow.WIDTH);
            int locY = (int) (Math.random() * GameWindow.HEIGHT);
            int speedX = (int) ((Math.random() * 6) - 3);
            int speedY = (int) ((Math.random() * 6) - 3);
            if (speedX == 0) {
                speedX = 1;
            }
            if (speedY == 0) {
                speedY = 1;
            }

            Car car = new Car(new Location(locX, locY), speedX, speedY, new Color(r, g, b));
            grid.addCar(car);
        }
        Tower tower = new Tower(0, new Location(GameWindow.WIDTH / 4, 3 * GameWindow.HEIGHT / 4), Color.RED);
        Tower tower1 = new Tower(0, new Location(GameWindow.WIDTH / 2,  GameWindow.HEIGHT / 4), Color.GREEN);
        Tower tower2 = new Tower(0, new Location(3 * GameWindow.WIDTH / 4, 3 * GameWindow.HEIGHT / 4), Color.BLUE);

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

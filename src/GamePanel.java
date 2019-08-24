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

        for (int i = 0; i < 50; i++) {
            int r = (int) (Math.random() * 255);
            int g = (int) (Math.random() * 255);
            int b = (int) (Math.random() * 255);

            int locX = (int) (Math.random() * GameWindow.WIDTH);
            int locY = (int) (Math.random() * GameWindow.HEIGHT);
            int speedX = (int) ((Math.random() * 6) - 3);
            int speedY = (int) ((Math.random() * 24) - 12);
            if (speedX == 0) {
                speedX = 1;
            }
            if (speedY == 0) {
                speedY = 1;
            }

            Car car = new Car(new Location(locX, locY), speedX, speedY, new Color(r, g, b));
            grid.addCar(car);
        }

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

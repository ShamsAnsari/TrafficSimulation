import java.awt.*;

public class Car {
    private Location loc;
    private int speedX;
    private int speedY;
    private Color color;
    private int width = 10;
    private int height = 10;

    public Car(Location loc, int speedX, int speedY, Color color) {
        this.loc = loc;
        this.speedX = speedX;
        this.speedY = speedY;
        this.color = color;
        simplifySpeeds();
    }

    public void update() {
        loc.incrX(speedX);
        loc.incrY(speedY);
        // Wraps around the screen

        if (loc.getX() > GameWindow.WIDTH) {
            loc.setX(0);
        }
        if (loc.getX() < 0) {
            loc.setX(GameWindow.WIDTH);
        }
        if (loc.getY() > GameWindow.HEIGHT) {
            loc.setY(0);
        }
        if (loc.getY() < 0) {
            loc.setY(GameWindow.HEIGHT);
        }
    }

    private void simplifySpeeds() {
        int gcm = gcm(speedX, speedY);
        speedX = speedX / gcm;
        speedY = speedY / gcm;
    }

    /**
     * @return the greatest common denominator
     */
    public static int gcm(int a, int b) {
        return b == 0 ? a : gcm(b, a % b); // Not bad for one line of code :)
    }

    public void render(Graphics g) {
        int x = loc.getX() + width / 2;
        int y = loc.getY() + height / 2;
        g.setColor(color);
        g.fillRect(x, y, width, height);

    }
}

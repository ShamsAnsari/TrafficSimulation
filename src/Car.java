

import java.awt.*;
import java.util.ArrayList;

public class Car {
    private Location center;
    private int speedX;
    private int speedY;
    private Color color;
    private int radius;
    private Grid grid;
    private Tower tower;


    public Car(Location center, int speedX, int speedY, Color color) {
        this.center = center;
        this.speedX = speedX;
        this.speedY = speedY;
        this.color = color;
        radius = 5;
        simplifySpeeds();
    }

    public void update() {
        center.incrX(speedX);
        center.incrY(speedY);
        // Wraps around the screen
        if (center.getX() > GameWindow.WIDTH) {
            center.setX(0);
        }
        if (center.getX() < 0) {
            center.setX(GameWindow.WIDTH);
        }
        if (center.getY() > GameWindow.HEIGHT) {
            center.setY(0);
        }
        if (center.getY() < 0) {
            center.setY(GameWindow.HEIGHT);
        }
//        Tower tower = colliding();
        tower = closestTower();

        int distance = distanceFrom(tower);
        int r = tower.getColor().getRed();
        int g = tower.getColor().getGreen();
        int b = tower.getColor().getBlue();
        double MAX_DISTANCE = 720;
        int a = (int)(((MAX_DISTANCE - distance) / MAX_DISTANCE) * 255.0);
        System.out.println(a);

        setColor(new Color(r, g, b,a));

    }

    private Tower closestTower() {
        ArrayList<Tower> towers = grid.getTowers();

        Tower cTower = towers.get(0);
        for (Tower tower : towers) {
            int distance = distanceFrom(tower);
            if (distance < distanceFrom(cTower)) {
                cTower = tower;
            }
        }

        return cTower;
    }


    private int distanceFrom(Tower tower) {
        int tx = tower.getCenter().getX();
        int ty = tower.getCenter().getY();

        int cx = this.getCenter().getX();
        int cy = this.getCenter().getY();

        int distance = (int) Math.round(Math.sqrt(Math.pow((tx - cx), 2) + Math.pow((ty - cy), 2)));
        return distance;
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

    private void drawCenteredCircle(Graphics g, int x, int y, int radius) {
        int diameter = radius * 2;
        g.fillOval(x - radius, y - radius, diameter, diameter);
    }

    public void render(Graphics g) {
        g.setColor(color);
        drawCenteredCircle(g, center.getX(), center.getY(), radius);

    }

    public Tower colliding() {
        ArrayList<Tower> towers = grid.getTowers();
        for (Tower tower : towers) {
            if (collide(tower, this)) {
                return tower;
            }
        }
        return null;

    }

    public boolean collide(Tower tower, Car car) {
        double xDiff = car.getCenter().getX() - tower.getCenter().getX();
        double yDiff = car.getCenter().getY() - tower.getCenter().getY();

        double distance = Math.sqrt((Math.pow(xDiff, 2) + Math.pow(yDiff, 2)));

        return distance < (car.getRadius() + tower.getRadius());
    }


    public Location getCenter() {
        return center;
    }

    public int getSpeedX() {
        return speedX;
    }

    public int getSpeedY() {
        return speedY;
    }

    public Color getColor() {
        return color;
    }

    public int getRadius() {
        return radius;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setCenter(Location center) {
        this.center = center;
    }

    public void setSpeedX(int speedX) {
        this.speedX = speedX;
    }

    public void setSpeedY(int speedY) {
        this.speedY = speedY;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public Grid getGrid() {
        return grid;
    }

    public void setGrid(Grid grid) {
        this.grid = grid;
    }

}

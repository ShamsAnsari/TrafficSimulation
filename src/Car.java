

import java.awt.*;
import java.util.ArrayList;

public class Car {
    private Point location;
    private Point destination;
    private int speed;
    private Color color;
    private int radius;
    private Grid grid;
    private Tower tower;

    //==================================================================================================================
    //*****************************************************CONSTRUCTORS*************************************************
    //==================================================================================================================

    public Car(Point location, Point destination, int speed, int radius, Color color) {
        this.location = location;
        this.destination = destination;
        this.speed = speed;
        this.color = color;
        this.radius = radius;

    }
    //==================================================================================================================
    //*************************************************PUBLIC METHODS***************************************************
    //==================================================================================================================

    public void render(Graphics g) {
        g.setColor(color);
        drawCenteredCircle(g, location.getX(), location.getY(), radius);

    }

    public void update() {
        double deltaX = destination.getX() - location.getX();
        double deltaY = destination.getY() - location.getY();
        int direction = (int) (Math.round(Math.atan2(deltaY, deltaX)));

        location.incrX((int) Math.round(speed * Math.cos(direction)));
        location.incrY((int) Math.round(speed * Math.sin(direction)));

        if (reached()) {
            Point des = calculateSidePoint();
            setDestination(des);
        }
        // Wraps around the screen
        if (location.getX() > GameWindow.WIDTH) {
            location.setX(0);
        }
        if (location.getX() < 0) {
            location.setX(GameWindow.WIDTH);
        }
        if (location.getY() > GameWindow.HEIGHT) {
            location.setY(0);
        }
        if (location.getY() < 0) {
            location.setY(GameWindow.HEIGHT);
        }
//        Tower tower = colliding();
        tower = closestTower();

        int distance = distanceFrom(tower);
        int r = tower.getColor().getRed();
        int g = tower.getColor().getGreen();
        int b = tower.getColor().getBlue();
        double MAX_DISTANCE = 720;
        int a = (int) (((MAX_DISTANCE - distance) / MAX_DISTANCE) * 255.0);

        setColor(new Color(r, g, b, a));

    }


    //==================================================================================================================
    //*************************************************PRIVATE METHODS***************************************************
    //==================================================================================================================

    private Point calculateSidePoint() {
        int desX = 0;
        int desY = 0;
        int side = (int) (Math.random() * 4 + 1);
        switch (side) {
            case 1:
                desX = 0;
                desY = (int) (Math.random() * GameWindow.HEIGHT);
                break;
            case 2:
                desX = (int) (Math.random() * GameWindow.WIDTH);
                desY = 0;
                break;
            case 3:
                desX = GameWindow.WIDTH;
                desY = (int) (Math.random() * GameWindow.HEIGHT);
                break;
            case 4:
                desX = (int) (Math.random() * GameWindow.WIDTH);
                desY = GameWindow.HEIGHT;
                break;
        }
        return new Point(desX, desY);
    }
    private boolean reached() {
        int distance = distanceFrom(destination);
        int radius = 5;

        return (distance < radius);

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
        int tx = tower.getLocation().getX();
        int ty = tower.getLocation().getY();

        int cx = this.getLocation().getX();
        int cy = this.getLocation().getY();

        int distance = (int) Math.round(Math.sqrt(Math.pow((tx - cx), 2) + Math.pow((ty - cy), 2)));
        return distance;
    }

    private int distanceFrom(Point point) {
        int tx = point.getX();
        int ty = point.getY();

        int cx = this.getLocation().getX();
        int cy = this.getLocation().getY();

        int distance = (int) Math.round(Math.sqrt(Math.pow((tx - cx), 2) + Math.pow((ty - cy), 2)));
        return distance;
    }


    private void drawCenteredCircle(Graphics g, int x, int y, int radius) {
        int diameter = radius * 2;
        g.fillOval(x - radius, y - radius, diameter, diameter);
    }


    private Tower colliding() {
        ArrayList<Tower> towers = grid.getTowers();
        for (Tower tower : towers) {
            if (collide(tower, this)) {
                return tower;
            }
        }
        return null;

    }

    private boolean collide(Tower tower, Car car) {
        double xDiff = car.getLocation().getX() - tower.getLocation().getX();
        double yDiff = car.getLocation().getY() - tower.getLocation().getY();

        double distance = Math.sqrt((Math.pow(xDiff, 2) + Math.pow(yDiff, 2)));

        return distance < (car.getRadius() + tower.getRadius());
    }

    //==================================================================================================================
    //*****************************************************GETTERS & SETTERS********************************************
    //==================================================================================================================

    /**
     * Sets new location.
     *
     * @param location New value of location.
     */
    public void setLocation(Point location) {
        this.location = location;
    }

    /**
     * Gets tower.
     *
     * @return Value of tower.
     */
    public Tower getTower() {
        return tower;
    }

    /**
     * Sets new tower.
     *
     * @param tower New value of tower.
     */
    public void setTower(Tower tower) {
        this.tower = tower;
    }

    /**
     * Gets radius.
     *
     * @return Value of radius.
     */
    public int getRadius() {
        return radius;
    }

    /**
     * Gets destination.
     *
     * @return Value of destination.
     */
    public Point getDestination() {
        return destination;
    }

    /**
     * Sets new radius.
     *
     * @param radius New value of radius.
     */
    public void setRadius(int radius) {
        this.radius = radius;
    }

    /**
     * Sets new color.
     *
     * @param color New value of color.
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * Gets color.
     *
     * @return Value of color.
     */
    public Color getColor() {
        return color;
    }

    /**
     * Sets new destination.
     *
     * @param destination New value of destination.
     */
    public void setDestination(Point destination) {
        this.destination = destination;
    }

    /**
     * Gets speed.
     *
     * @return Value of speed.
     */
    public int getSpeed() {
        return speed;
    }

    /**
     * Sets new speed.
     *
     * @param speed New value of speed.
     */
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    /**
     * Gets location.
     *
     * @return Value of location.
     */
    public Point getLocation() {
        return location;
    }

    /**
     * Gets grid.
     *
     * @return Value of grid.
     */
    public Grid getGrid() {
        return grid;
    }

    /**
     * Sets new grid.
     *
     * @param grid New value of grid.
     */
    public void setGrid(Grid grid) {
        this.grid = grid;
    }
}

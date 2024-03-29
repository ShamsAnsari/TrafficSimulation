import java.awt.*;
import java.util.ArrayList;

public class Tower {
    private int radius;
    private int size;
    private Point location;
    private Color color;
    private ArrayList<Car> cars;
    private Grid grid;
    int l = 0;


    public Tower(int radius, Point location, Color color) {
        this.radius = radius;
        this.location = location;
        this.color = color;
        size = 10;
    }


    private void fillCenteredCircle(Graphics g, int x, int y, int radius) {
        int diameter = radius * 2;
        g.fillOval(x - radius, y - radius, diameter, diameter);
    }

    private void drawCenteredCircle(Graphics g, int x, int y, int radius) {
        int diameter = radius * 2;
        g.drawOval(x - radius, y - radius, diameter, diameter);
    }

    public void render(Graphics g) {
        g.setColor(color);
        fillCenteredCircle(g, location.getX(), location.getY(), size);
        drawCenteredCircle(g, location.getX(), location.getY(), radius);
        if (l % 2 == 0) {
            if (radius > 20) {
                radius = 0;
            } else {
                radius++;
            }
        }
        l++;


    }


    public void update() {
        //TODO: make list of all cars conneted to cell tower
    }

    //==================================================================================================================
    //*****************************************************GETTERS & SETTERS********************************************
    //==================================================================================================================


    /**
     * Gets location.
     *
     * @return Value of location.
     */
    public Point getLocation() {
        return location;
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
     * Sets new location.
     *
     * @param location New value of location.
     */
    public void setLocation(Point location) {
        this.location = location;
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
     * Gets size.
     *
     * @return Value of size.
     */
    public int getSize() {
        return size;
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
     * Sets new size.
     *
     * @param size New value of size.
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * Sets new cars.
     *
     * @param cars New value of cars.
     */
    public void setCars(ArrayList<Car> cars) {
        this.cars = cars;
    }

    /**
     * Gets cars.
     *
     * @return Value of cars.
     */
    public ArrayList<Car> getCars() {
        return cars;
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

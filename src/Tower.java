import java.awt.*;

public class Tower {
    private int radius;
    private int size;
    private Point location;
    private Color color;

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
        g.setColor(new Color(color.getRed(), color.getGreen(), color.getBlue()));
        drawCenteredCircle(g, location.getX(), location.getY(), radius);

    }


    public void update() {

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
}

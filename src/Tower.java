import java.awt.*;

public class Tower {
    private int radius;
    private int size;
    private Location center;
    private Color color;
    private int fartestCar;

    public Tower(int radius, Location center, Color color) {
        this.radius = radius;
        this.center = center;
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
        fillCenteredCircle(g, center.getX(), center.getY(), size);
        g.setColor(new Color(color.getRed(), color.getGreen(), color.getBlue()));
        drawCenteredCircle(g, center.getX(), center.getY(), radius);

    }


    public void update() {

    }

    public int getRadius() {
        return radius;
    }

    public int getSize() {
        return size;
    }

    public Location getCenter() {
        return center;
    }

    public Color getColor() {
        return color;
    }
}

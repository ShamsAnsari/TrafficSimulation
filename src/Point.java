/**
 * Simple point or coordinate class for pixel locations.
 */
public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void incrX(int d) {
        x += d;
    }

    public void incrY(int d) {
        y += d;
    }

    /**
     * Gets y.
     *
     * @return Value of y.
     */
    public int getY() {
        return y;
    }

    /**
     * Sets new x.
     *
     * @param x New value of x.
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Sets new y.
     *
     * @param y New value of y.
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Gets x.
     *
     * @return Value of x.
     */
    public int getX() {
        return x;
    }
}

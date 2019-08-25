import java.awt.*;
import java.util.ArrayList;

/**
 * Represents a city grid. A grid has cars and base station.
 */
public class Grid {
    private ArrayList<Car> cars;
    private ArrayList<Tower> towers;

    public Grid() {
        cars = new ArrayList<>();
        towers = new ArrayList<>();
    }

    public void addCar(Car car) {
        cars.add(car);
        car.setGrid(this);
    }

    public void addTower(Tower tower) {
        towers.add(tower);
    }

    public ArrayList<Car> getCars() {
        return cars;
    }

    public void update() {
        cars.forEach(car -> car.update());
        towers.forEach(tower -> tower.update());


    }

    public void setCars(ArrayList<Car> cars) {
        this.cars = cars;
    }

    public ArrayList<Tower> getTowers() {
        return towers;
    }

    public void setTowers(ArrayList<Tower> towers) {
        this.towers = towers;
    }

    public void render(Graphics g) {
        cars.forEach(car -> car.render(g));
        towers.forEach(tower -> tower.render(g));
    }

    public boolean collide(Tower tower, Car car) {
        double xDiff = car.getCenter().getX() - tower.getCenter().getX();
        double yDiff = car.getCenter().getY() - tower.getCenter().getY();

        double distance = Math.sqrt((Math.pow(xDiff, 2) + Math.pow(yDiff, 2)));

        return distance < (car.getRadius() + tower.getRadius());
    }

}

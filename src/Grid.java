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

    public void update() {
        cars.forEach(car -> car.update());
        towers.forEach(tower -> tower.update());
    }

    public void render(Graphics g) {
        cars.forEach(car -> car.render(g));
        towers.forEach(tower -> tower.render(g));
    }

    public void addCar(Car car) {
        cars.add(car);
        car.setGrid(this);
    }

    public void addTower(Tower tower) {
        towers.add(tower);
        tower.setGrid(this);
    }

    public ArrayList<Car> getCars() {
        return cars;
    }

    public ArrayList<Tower> getTowers() {
        return towers;
    }



}

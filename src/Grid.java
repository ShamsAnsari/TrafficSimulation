import java.awt.*;
import java.util.ArrayList;

/**
 * Represents a city grid. A grid has cars and base station.
 */
public class Grid {
    private ArrayList<Car> cars;

    public Grid(Car... cars) {
        this.cars = new ArrayList<>();
        for (Car car : cars) {
            this.cars.add(car);
        }

    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public void removeCar(Car car) {
        cars.remove(car);
    }

    public ArrayList<Car> getCars() {
        return cars;
    }

    public void update() {
        cars.forEach(car -> car.update());
    }

    public void render(Graphics g) {
        cars.forEach(car -> car.render(g));
    }
}

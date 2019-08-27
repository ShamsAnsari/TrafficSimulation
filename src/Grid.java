import java.awt.*;
import java.util.ArrayList;

/**
 * Represents a city grid. A grid has cars and base station.
 */
public class Grid {
    private volatile ArrayList<Car> cars;
    private volatile ArrayList<Tower> towers;
    private boolean lineToggle;

    public Grid() {
        cars = new ArrayList<>();
        towers = new ArrayList<>();
    }
    //==================================================================================================================
    //*************************************************PUBLIC METHODS***************************************************
    //==================================================================================================================

    public void update() {
        synchronized (cars) {
            cars.forEach(car -> car.update());
        }
        synchronized (towers) {
            towers.forEach(tower -> tower.update());
        }
    }

    public void render(Graphics g) {
        synchronized (cars) {
            cars.forEach(car -> car.render(g));
        }
        synchronized (towers) {
            towers.forEach(tower -> tower.render(g));
        }
    }


    public void toggleCarLines() {
        lineToggle = !lineToggle;
        synchronized (cars) {
            cars.forEach(car -> car.toggleLine());
        }

    }

    public void addCar(Car car) {
        synchronized (cars) {
            cars.add(car);
        }
        car.setGrid(this);

    }

    public void addTower(Tower tower) {
        synchronized (towers) {
            towers.add(tower);
        }
        tower.setGrid(this);

    }

    public void setNumTowers(int needNum) {
        if (towers.size() == needNum) {
            return;
        }

        if (towers.size() > needNum) {
            while (towers.size() > needNum) {
                removeTower(0);
            }
        }
        if (towers.size() < needNum) {
            int diff = needNum - towers.size();
            initTower(diff);
        }


    }

    public void setNumCars(int needNum) {
        if (cars.size() == needNum) {
            return;
        }

        if (cars.size() > needNum) {
            while (cars.size() > needNum) {
                removeCar(0);
            }
        }
        if (cars.size() < needNum) {
            int diff = needNum - cars.size();
            initCars(diff);
        }

        if (isLineToggle()) {
            synchronized (cars) {
                cars.forEach(car -> car.setLineOn(true));
            }
        }
    }

    private void initCars(int numCars) {
        for (int i = 0; i < numCars; i++) {

            int speed = 1;
            int radius = 3;
            int locX = (int) (Math.random() * GameWindow.WIDTH);
            int locY = (int) (Math.random() * GameWindow.HEIGHT);

            Point des = Car.calculateSidePoint();

            Car car = new Car(new Point(locX, locY), des, speed, radius, Color.BLACK);
            this.addCar(car);
        }
    }

    public void initTower(int numTowers) {
        for (int i = 0; i < numTowers; i++) {

            int locX = (int) (Math.random() * GameWindow.WIDTH);
            int locY = (int) (Math.random() * GameWindow.HEIGHT);

            int r = (int) (Math.random() * 255);
            int g = (int) (Math.random() * 255);
            int b = (int) (Math.random() * 255);


            Tower tower = new Tower(20, new Point(locX, locY), new Color(r, g, b));
            this.addTower(tower);
        }
    }

    public ArrayList<Car> getCars() {
        return cars;
    }

    public ArrayList<Tower> getTowers() {
        return towers;
    }

    public void removeTower(Tower tower) {
        synchronized (towers) {
            towers.remove(tower);
        }
    }

    public void removeTower(int index) {
        synchronized (towers) {
            towers.remove(index);
        }
    }

    public void removeCar(Car car) {
        synchronized (cars) {
            cars.remove(car);
        }

    }

    public void removeCar(int index) {
        synchronized (cars) {
            cars.remove(index);
        }

    }

    public int getNumCars() {
        return cars.size();
    }

    /**
     * Gets lineToggle.
     *
     * @return Value of lineToggle.
     */
    public boolean isLineToggle() {
        return lineToggle;
    }

    /**
     * Sets new towers.
     *
     * @param towers New value of towers.
     */
    public void setTowers(ArrayList<Tower> towers) {
        this.towers = towers;
    }

    /**
     * Sets new lineToggle.
     *
     * @param lineToggle New value of lineToggle.
     */
    public void setLineToggle(boolean lineToggle) {
        this.lineToggle = lineToggle;
    }

    /**
     * Sets new cars.
     *
     * @param cars New value of cars.
     */
    public void setCars(ArrayList<Car> cars) {
        this.cars = cars;
    }
}

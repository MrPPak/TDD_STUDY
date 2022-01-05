package study.step02;

import java.util.List;

public class InputCars {

    private final List<Car> cars;

    public InputCars(String input) {
        this.cars = splitAndMakeCars(input);
    }

    public List<Car> getCars() {
        return this.cars;
    }

    public List<Car> splitAndMakeCars(String input) {
        
        return null;
    }
}

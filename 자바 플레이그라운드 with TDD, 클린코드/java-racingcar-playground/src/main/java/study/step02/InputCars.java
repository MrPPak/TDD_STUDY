package study.step02;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputCars {

    private final List<Car> cars;

    public InputCars(String input) {
        this.cars = splitAndMakeCars(input);
    }

    public List<Car> getCars() {
        return this.cars;
    }

    public List<Car> splitAndMakeCars(String input) {
        List<String> carNames = Arrays.asList(input.split(","));
        return carNames.stream().map(name -> new Car(new CarName(name), new CarLocation())).collect(Collectors.toList());
    }
}

package study.racingcar_v1.domain;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

// 일급 컬렉션 - 컬렉션을 wrapping - 무조건 불변이어야 한다.
public class Cars {

    private List<Car> cars; // ppak,king,jagu

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void move() {
        cars.forEach(Car::move);
    }

    public List<Car> findWinners() {
        return cars.stream()
                .filter(car -> car.isWinner(findMaxPosition()))
                .collect(Collectors.toList());
    }

    // stream, optional
    private int findMaxPosition() {
        return cars.stream()
                .mapToInt(car -> car.getCurrentPosition())
                .max().orElseThrow(() -> new RuntimeException());
    }

    public List<Car> getCars() {
        return cars;
    }
}

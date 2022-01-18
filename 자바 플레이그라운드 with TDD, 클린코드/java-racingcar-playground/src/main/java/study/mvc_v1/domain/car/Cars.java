package study.mvc_v1.domain.car;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

// 일급 컬렉션
public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    // 람다식 메서드 참조 공부
    public void move() {
        cars.forEach(Car::move);
    }

    public List<Car> findWinners() {
        return cars.stream()
                .filter(car -> car.isWinner(findMaxPosition()))
                .collect(Collectors.toList());
    }

    private int findMaxPosition() {
        return cars.stream()
                .map(car -> car.getPosition())
                .max(Integer::compare).orElseThrow(() -> new RuntimeException("No Winner"));
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}

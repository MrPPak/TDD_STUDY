package study.mvc_v1.domain.car;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.mvc_v1.domain.engine.FixedEngine;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarsTest {

    Car movableCar1;
    Car movableCar2;
    Car immovableCar;

    @BeforeEach
    public void setUp() throws Exception {
        movableCar1 = new Car("ppak", new FixedEngine(4));
        movableCar2 = new Car("cobi", new FixedEngine(4));
        immovableCar = new Car("nono", new FixedEngine(3));
    }

    @Test
    @DisplayName("자동차 움직임 테스트")
    public void moveTest() throws Exception {

        // given
        Cars cars = new Cars(Arrays.asList(movableCar1, movableCar2, immovableCar));

        // when
        for (int i = 0; i < 5; i++) {
             cars.move();
        }

        // then
        List<Position> positions = cars.getCars().stream()
                .map(Car::getPosition)
                .collect(Collectors.toList());

        Assertions.assertThat(positions).isEqualTo(Arrays.asList(Position.of(5), Position.of(5), Position.of(0)));
    }

    @Test
    @DisplayName("우승자 판별 테스트")
    public void findWinnerTest() throws Exception {

        // given
        Cars cars = new Cars(Arrays.asList(movableCar1, movableCar2, immovableCar));

        // when
        for (int i = 0; i < 5; i++) {
            cars.move();
        }

        // then
        List<CarName> winnerNames = cars.findWinners()
                .stream()
                .map(Car::getCarName)
                .collect(Collectors.toList());

        Assertions.assertThat(winnerNames).isEqualTo(Arrays.asList(CarName.of("ppak"), CarName.of("cobi")));
    }
}

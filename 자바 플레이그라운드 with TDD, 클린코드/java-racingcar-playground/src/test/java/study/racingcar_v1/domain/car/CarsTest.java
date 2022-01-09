package study.racingcar_v1.domain.car;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.racingcar_v1.domain.engine.FixedEngine;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    private Car movableCar;
    private Car movableCar2;
    private Car immovableCar;

    @BeforeEach
    public void setUp() {
        movableCar = new Car("ppak", new FixedEngine(4));
        movableCar2 = new Car("king", new FixedEngine(4));
        immovableCar = new Car("jagu", new FixedEngine(3));
    }

    @Test
    @DisplayName("자동차들 움직임 테스트")
    public void carsMoveTest() {

        // given
        Cars cars = new Cars(Arrays.asList(movableCar, movableCar2, immovableCar));

        // when
        for (int i = 0; i < 5; i++) {
            cars.move();
        }

        // then
        List<Integer> positions = cars.getCars().stream()
                .map(Car::getCurrentPosition)
                .collect(Collectors.toList());

        assertThat(positions).isEqualTo(Arrays.asList(5,5,0));
    }

    @Test
    @DisplayName("우승자 판별 테스트")
    public void findWinnerTest() throws Exception {

        // given
        Cars cars = new Cars(Arrays.asList(movableCar, movableCar2, immovableCar));

        // when
        for (int i = 0; i < 5; i++) {
            cars.move();
        }

        // then
        List<String> winners = cars.findWinners().stream()
                .map(Car::getCarName)
                .collect(Collectors.toList());

        assertThat(winners).isEqualTo(Arrays.asList("ppak", "king"));
    }

}

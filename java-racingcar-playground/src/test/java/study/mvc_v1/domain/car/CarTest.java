package study.mvc_v1.domain.car;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.mvc_v1.domain.engine.FixedEngine;

public class CarTest {

    @Test
    @DisplayName("자동차 움직임 및 현재상태 테스트")
    public void moveTest() throws Exception {

        // given
        Car movableCar = new Car("ppak", new FixedEngine(4));
        Car immovableCar = new Car("ppak", new FixedEngine(3));

        // when
        int numOfRacingRound = 5;
        for (int i = 0; i < numOfRacingRound; i++) {
            movableCar.move();
            immovableCar.move();
        }

        // then
        Assertions.assertThat(movableCar.getPosition()).isEqualTo(Position.of(5));
        Assertions.assertThat(immovableCar.getPosition()).isEqualTo(Position.of(0));

    }

}

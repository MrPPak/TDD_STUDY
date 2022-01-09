package study.racingcar_v1.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.racingcar_v1.domain.car.Car;
import study.racingcar_v1.domain.engine.FixedEngine;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGameTest {

    @Test
    @DisplayName("우승자 판별 테스트")
    public void findWinnerTest() throws Exception {

        // given
        String[] carNames = "ppak,king".split(",");
        int raceRound = 5;
        RacingGame racingGame = new RacingGame(carNames, raceRound);
        List<Car> cars = racingGame.getCars();

        // when
        cars.replaceAll(car -> new Car(car.getCarName(), new FixedEngine(4)));
        cars.add(new Car("loser", new FixedEngine(3)));
        while(racingGame.isContinue()){
            racingGame.race();
        }

        // then
        List<String> winnerNames = racingGame.findWinners()
                .stream()
                .map(Car::getCarName)
                .collect(Collectors.toList());

        Assertions.assertThat(winnerNames).isEqualTo(Arrays.asList("ppak", "king"));
    }
}

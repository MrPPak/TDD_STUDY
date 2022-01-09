package study.racingcar_v1.domain;

import study.racingcar_v1.domain.car.Car;
import study.racingcar_v1.domain.car.Cars;
import study.racingcar_v1.domain.engine.RandomEngine;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {

    private Cars cars;
    private int racingRound;

    public RacingGame(String[] carNames, int racingRound) {
        this.cars = prepareCars(carNames);
        this.racingRound = racingRound;
    }

    private Cars prepareCars(String[] carNames) {
        return new Cars(Arrays.stream(carNames)
                .map(carName -> new Car(carName, new RandomEngine()))
                .collect(Collectors.toList()));
    }

    public boolean isContinue() {
        return racingRound != 0;
    }

    public void race() {
        cars.move();
        racingRound--;
    }

    public List<Car> getCars() {
        return cars.getCars();
    }

    public List<Car> findWinners() {
        return cars.findWinners();
    }

}

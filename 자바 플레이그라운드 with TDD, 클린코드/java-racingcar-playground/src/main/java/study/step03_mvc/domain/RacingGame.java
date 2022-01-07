package study.step03_mvc.domain;

import study.step03_mvc.domain.car.Car;
import study.step03_mvc.domain.car.CarName;
import study.step03_mvc.domain.car.Cars;
import study.step03_mvc.domain.engine.RandomEngine;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {

    private Cars cars;
    private int numOfRacingRound;

    public RacingGame(String[] carNames,int numOfRacingRound) {
        cars = prepareCars(carNames);
        this.numOfRacingRound = numOfRacingRound;
    }

    private Cars prepareCars(String[] carNames) {
        return new Cars(Arrays.stream(carNames)
                .map(carName -> new Car(carName, new RandomEngine()))
                .collect(Collectors.toList()));
    }

    public boolean isContinue() {
        return numOfRacingRound != 0;
    }

    public void race() {
        racePerRound();
        numOfRacingRound--;
    }

    private void racePerRound() {
        cars.move();
    }

    public List<Car> getCars() {
        return cars.getCars();
    }

    public List<Car> findWinners() {
        return cars.findWinners();
    }
}

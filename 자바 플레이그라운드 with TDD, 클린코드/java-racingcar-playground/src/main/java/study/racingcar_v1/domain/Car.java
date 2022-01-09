package study.racingcar_v1.domain;

import study.racingcar_v1.engine.Engine;

public class Car {

    private static final int DEFAULT_CAR_POSITION = 0;
    private static final int GO_FORWARD_DISTANCE = 1;

    private CarName carName;
    private Position position;
    private Engine engine;

    public Car(String name, Engine engine) {
        this.carName = CarName.of(name);
        this.engine = engine;
        this.position = Position.of(DEFAULT_CAR_POSITION);
    }

    public void move() {
        if(engine.movable()) {
            this.position = position.moveForward(GO_FORWARD_DISTANCE);
        }
    }

    public boolean isWinner(int max) {
        return position.isMaxPosition(max);
    }

    public String getCarName() {
        return carName.getValue();
    }

    public int getCurrentPosition() {
        return position.getValue();
    }

}

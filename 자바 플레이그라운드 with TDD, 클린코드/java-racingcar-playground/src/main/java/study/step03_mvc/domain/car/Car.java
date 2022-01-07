package study.step03_mvc.domain.car;

import study.step03_mvc.domain.engine.Engine;

public class Car {

    private static final int GO_FORWARD_DISTANCE = 1;
    private static final int DEFAULT_CAR_POSITION = 0;

    private CarName name;
    private Engine engine;
    private Position position;

    public Car(String name, Engine engine) {
        this.name = CarName.of(name);
        this.engine = engine;
        this.position = Position.of(DEFAULT_CAR_POSITION);
    }

    public void move() {
        if(engine.moveable()) {
            this.position = position.moveForward(GO_FORWARD_DISTANCE);
        }
    }

    public boolean isWinner(int max) {
        return position.isMaxPosition(max);
    }

    public Position getPosition() {
        return this.position;
    }

    public CarName getCarName() {
        return this.name;
    }
}

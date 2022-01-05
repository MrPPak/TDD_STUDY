package study.step02;

public class Car {

    private CarName carName;
    private CarLocation carLocation;

    public Car(CarName carName, CarLocation carLocation) {
        this.carName = carName;
        this.carLocation = carLocation;
    }

    public CarName getCarName() {
        return carName;
    }

    public CarLocation getCarLocation() {
        return carLocation;
    }
}

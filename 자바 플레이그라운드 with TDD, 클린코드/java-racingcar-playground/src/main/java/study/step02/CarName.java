package study.step02;

public class CarName {

    private String carName;

    public CarName(String carName) {
        validateCarName(carName);
        this.carName = carName;
    }

    private void validateCarName(String carName) {
        if(carName.length() > 5) {
            throw new IllegalStateException("차 이름은 5자를 초과할 수 없습니다.");
        }
    }
}

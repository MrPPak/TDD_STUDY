package study.step03_mvc.domain.car;

import study.step03_mvc.exception.InvalidCarNameException;

import java.util.Objects;

public class CarName {

    private static final int CAR_NAME_MIN_LENGTH = 1;
    private static final int CAR_NAME_MAX_LENGTH = 5;

    private final String name;

    private CarName(String name) {
        this.name = name;
    }

    public static CarName of(String name) {
        validateCarName(name);
        return new CarName(name);
    }

    public String getValue() {
        return this.name;
    }

    private static void validateCarName(String name) {
        if(name.length() < CAR_NAME_MIN_LENGTH || name.length() > CAR_NAME_MAX_LENGTH) {
            throw new InvalidCarNameException("자동차 이름은 1자 이상 5자 이하여야 합니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarName carName = (CarName) o;
        return Objects.equals(name, carName.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
package study.step03_mvc.domain.car;

import study.step03_mvc.exception.InvalidPositionException;

import java.util.Objects;

public class Position {

    private int position;

    private Position(int position) {
        this.position = position;
    }

    public static Position of(int position) {
        validatePosition(position);
        return new Position(position);
    }

    private static void validatePosition(int position) {
        if(position < 0) {
            throw new InvalidPositionException("위치는 음수일 수 없습니다.");
        }
    }

    public int getValue() {
        return this.position;
    }

    public Position moveForward(int position) {
        return Position.of(this.position + position);
    }

    public boolean isOn(int max) {
        return max == this.position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position1 = (Position) o;
        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}

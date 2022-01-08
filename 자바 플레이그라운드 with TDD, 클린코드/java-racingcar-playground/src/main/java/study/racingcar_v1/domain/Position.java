package study.racingcar_v1.domain;

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
            throw new RuntimeException("위치는 음수일 수 없습니다.");
        }
    }

    public Position moveForward(int numOfMove) {
        return Position.of(position + numOfMove);
    }

    public boolean isMaxPosition(int max) {
        return max == this.position;
    }

    public int getValue() {
        return this.position;
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

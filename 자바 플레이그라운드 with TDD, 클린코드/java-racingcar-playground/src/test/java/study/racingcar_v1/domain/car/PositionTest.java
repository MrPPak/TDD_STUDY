package study.racingcar_v1.domain.car;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.racingcar_v1.domain.Position;

public class PositionTest {

    @Test
    @DisplayName("Position은 음수값을 가질 수 없다.")
    public void 유효성검사() {
        Assertions.assertThatThrownBy(() -> {
            Position.of(-1);
        }).isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("위치를 제대로 이동시키는지 테스트")
    public void moveTest() {

        // given
        Position position = Position.of(0);
        int numOfMove = 5;

        // when // then
        Assertions.assertThat(position.moveForward(numOfMove)).isEqualTo(Position.of(5));
    }


}

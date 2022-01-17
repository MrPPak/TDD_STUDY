package study.mvc_v1.domain.car;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.mvc_v1.exception.InvalidPositionException;

public class PositionTest {

    @Test
    public void 생성_및_비교() throws Exception {
        Position position1 = Position.of(1);
        Position position2 = Position.of(1);

        Assertions.assertThat(position1).isEqualTo(position2);
    }

    @Test
    @DisplayName("Position이 음수값을 가질 수 없다.")
    public void 유효성검사() throws Exception {
        Assertions.assertThatThrownBy(() -> {
            Position.of(-1);
        }).isInstanceOf(InvalidPositionException.class);
    }

}

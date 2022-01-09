package study.racingcar_v1.domain.car;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import study.racingcar_v1.exception.InvalidCarNameException;

public class CarNameTest {

    @Test
    public void 자동차_이름_검증() {

        String carNameOverMax = "abcdef";
        String carNameLessMin = "";

        Assertions.assertThatThrownBy(() -> {
            CarName.of(carNameOverMax);
        }).isInstanceOf(InvalidCarNameException.class);

        Assertions.assertThatThrownBy(() -> {
            CarName.of(carNameLessMin);
        }).isInstanceOf(InvalidCarNameException.class);
    }
}

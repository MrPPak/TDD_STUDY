package study.step03_mvc.domain.car;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import study.step03_mvc.exception.InvalidCarNameException;

import static org.assertj.core.api.Assertions.assertThat;

public class CarNameTest {

    @Test
    public void 생성_및_비교() throws Exception {

        CarName venz1 = CarName.of("Venz");
        CarName venz2 = CarName.of("Venz");

        assertThat(venz1).isEqualTo(venz2);
    }

    @ParameterizedTest
    @DisplayName("이름 길이가 1자 미만 또는 5자초과 예외처리 테스트")
    @ValueSource(strings = {"", "abcdef"})
    public void 유효성_검사(String carName) throws Exception {

        Assertions.assertThatThrownBy(() -> {
            CarName.of(carName);
        }).isInstanceOf(InvalidCarNameException.class);
    }
}

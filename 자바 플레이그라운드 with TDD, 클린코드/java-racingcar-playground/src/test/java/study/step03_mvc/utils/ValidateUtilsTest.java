package study.step03_mvc.utils;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.step03_mvc.exception.InvalidCarNameException;

public class ValidateUtilsTest {

    @Test
    @DisplayName("자동차 이름 수 확인 검증 테스트")
    public void numOfCarNamesTest() throws Exception {
        // given
        String carNames = "ppak";

        // when // then
        Assertions.assertThatThrownBy(() -> {
            ValidateUtils.validateNumOfCarNames(carNames.split(","));
        }).isInstanceOf(InvalidCarNameException.class);
    }

    @Test
    @DisplayName("시도횟수를 잘못입력할 때 검증 제대로 되는지 테스트")
    public void validateRoundTest() throws Exception {
        // given
        String nonInt = "a";
        String negativeInt = "-1";

        // when // then
        Assertions.assertThatThrownBy(() -> {
            ValidateUtils.validateRacingRound(nonInt);
        }).isInstanceOf(RuntimeException.class);

        Assertions.assertThatThrownBy(() -> {
            ValidateUtils.validateRacingRound(negativeInt);
        }).isInstanceOf(RuntimeException.class);

    }
}

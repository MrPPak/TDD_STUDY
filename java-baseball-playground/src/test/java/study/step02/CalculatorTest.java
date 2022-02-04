package study.step02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {

    @ParameterizedTest
    @CsvSource(value = {"2 + 3 * 4 / 2:10", "1 + 1 * 2 / 4:1", "2 * 3 - 4 * 7:14"}, delimiter = ':')
    @DisplayName("입력을 하면 계산이 된다")
    public void calculateTest(String input, String result) throws Exception {

        // given
        Calculator calculator = new Calculator();

        // when
        int resultNum = calculator.calculateTheInput(input);

        // then
        Assertions.assertTrue(resultNum == Integer.parseInt(result));
    }

    @ParameterizedTest
    @CsvSource(value = {"2 + 3 * 4 / 0:0으로 나눌 수 없습니다.", "2 + 3 * 4 ++ 1:연산자를 잘못입력하셨습니다."}, delimiter = ':')
    @DisplayName("계산기 예외 제대로 터지는지 테스트")
    public void calculateExceptionTest(String input, String exceptionMsg) throws Exception {

        // given
        Calculator calculator = new Calculator();

        assertThatThrownBy(() -> {
            calculator.calculateTheInput(input);
        }).isInstanceOf(ArithmeticException.class)
                .hasMessageContaining(exceptionMsg);
    }

}

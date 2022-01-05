package study.step02;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {

    @Test
    @DisplayName("차이름 5자 초과 입력시 오류확인")
    public void CarNameTest() throws Exception {
        Assertions.assertThatThrownBy(() -> {
            new CarName("abcdef");
        }).isInstanceOf(IllegalStateException.class);
    }

    @ParameterizedTest
    @DisplayName("숫자가 4이상이면 증가 4미만이면 증가 안함")
    @CsvSource(value = {"4:true", "3:false"}, delimiter = ':')
    public void LocationIncreaseTest(String num, String bool) throws Exception {
        int number = Integer.parseInt(num);
        boolean check = Boolean.parseBoolean(bool);

        CarLocation carLocation = new CarLocation();
        Assertions.assertThat(carLocation.canIncrease(number)).isEqualTo(check);
    }

    @Test
    @DisplayName("차이름 입력한대로 차생성하는지 확인")
    public void makeCarsTest() throws Exception {
        String rightInput = "park,jong,hyuk";
        String wrongInput = "mrPPak,jong,hyuk";

        Assertions.assertThat(new InputCars(rightInput).getCars().size()).isEqualTo(3);
        Assertions.assertThatThrownBy(() -> {
            new InputCars(wrongInput);
        }).isInstanceOf(IllegalStateException.class);
    }

}

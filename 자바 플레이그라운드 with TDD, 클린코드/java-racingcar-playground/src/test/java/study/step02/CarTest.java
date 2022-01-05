package study.step02;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    @DisplayName("차이름 5자 초과 입력시 오류확인")
    public void CarNameTest() throws Exception {
        Assertions.assertThatThrownBy(() -> {
            new CarName("abcdef");
        }).isInstanceOf(IllegalStateException.class);
    }


}

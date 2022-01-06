package study.step03_mvc.utils;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

public class RandomUtilsTest {

    private static final int START_BOUND = 1;
    private static final int END_BOUND = 9;

    @Test
    public void 랜덤값의_범위_설정오류_테스트() throws Exception {
        Assertions.assertThatThrownBy(() -> {
            RandomUtils.nextInt(9, 1);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 랜덤값의_시작_범위_테스트() throws Exception {
        Assertions.assertThatThrownBy(() -> {
            RandomUtils.nextInt(-1, 3);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @RepeatedTest(10)
    public void 랜덤값의_범위_테스트() throws Exception {
        Assertions.assertThat(RandomUtils.nextInt(START_BOUND, END_BOUND)).isBetween(START_BOUND, END_BOUND);
    }
}

package study.step01;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    public void splitTest() throws Exception {

        // given
        String str1 = "1,2";
        String str2 = "1,";

        // when
        String[] split1 = str1.split(",");
        String[] split2 = str2.split(",");

        // then
        assertThat(split1).containsExactly("1","2");
        assertThat(split2).containsExactly("1");
    }

    @Test
    public void substringTest() throws Exception {

        // given
        String str = "(1,2)";

        // when
        String substringStr = str.substring(str.indexOf("(") + 1, str.indexOf(")"));

        // then
        assertThat(substringStr).isEqualTo("1,2");
    }

    @Test
    @DisplayName("문자열에서 특정위치의 문자를 가져온다")
    public void stringLocationTest() throws Exception {

        // given
        String str = "abc";
        int index = 2;

        // when
        char one = str.charAt(index - 1);

        // then
        assertThat(one).isEqualTo('b');
    }

    @Test
    @DisplayName("문자열에서 위치값을 벗어나면 예외 발생시킨다")
    public void stringLocationExceptionTest() throws Exception {

        // given
        String str = "abc";
        int index = 4;

        // when // then
        Assertions.assertThatThrownBy(() -> {
                    char one = str.charAt(index - 1);
                }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 3");

    }
}

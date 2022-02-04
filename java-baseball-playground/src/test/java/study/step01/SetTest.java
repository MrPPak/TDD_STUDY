package study.step01;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SetTest {

    private Set<Integer> numbers;

    @BeforeEach
    void setup() throws Exception {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    @DisplayName("Set의 크기를 확인한다.")
    public void setSizeTest() throws Exception {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    @DisplayName("Set에 1,2,3의 값이 존재한다.")
    public void containsTest(int member) throws Exception {
        assertTrue(numbers.contains(member));
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    @DisplayName("Set에 1,2,3은 존재하고 4,5는 존재하지 않는다")
    public void containsTestExpansion(String input, String expected) throws Exception {
        int member = Integer.parseInt(input);
        Boolean isInNumbers = Boolean.parseBoolean(expected);

        assertThat(numbers.contains(member)).isEqualTo(isInNumbers);
    }

}

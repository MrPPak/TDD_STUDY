package study.racingcar_v1.utils;

import java.util.Random;

public class RandomUtils {

    private static final Random RANDOM = new Random();

    private RandomUtils() {}

    public static int nextInt(int start, int end) {
        validateNextInt(start, end);

        if(start == end) {
            return start;
        }

        return start + RANDOM.nextInt(end - start + 1);
    }

    private static void validateNextInt(int start, int end) {
        if(start > end) {
            throw new IllegalArgumentException("시작값은 끝값보다 클 수 없습니다.");
        }

        if(start < 0) {
            throw new IllegalArgumentException("시작값은 음수일 수 없습니다.");
        }
    }
}

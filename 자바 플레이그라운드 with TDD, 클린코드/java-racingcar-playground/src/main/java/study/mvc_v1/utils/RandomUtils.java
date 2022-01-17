package study.mvc_v1.utils;

import java.util.Random;

public class RandomUtils {

    private static final Random RANDOM = new Random();

    private RandomUtils() {}

    public static int nextInt(int start, int end) {
        if(start > end) {
            throw new IllegalArgumentException();
        }

        if(start < 0) {
            throw new IllegalArgumentException();
        }

        if(start == end) {
            return start;
        }

        return start + RANDOM.nextInt(end - start + 1);
    }
}

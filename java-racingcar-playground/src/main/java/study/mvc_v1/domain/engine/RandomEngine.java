package study.mvc_v1.domain.engine;

import study.mvc_v1.utils.RandomUtils;

public class RandomEngine implements Engine{

    private static final int MIN_VALUE = 0;
    private static final int MAX_VALUE = 9;

    @Override
    public boolean moveable() {
        return RandomUtils.nextInt(MIN_VALUE, MAX_VALUE) > MOVABLE_DIGIT;
    }
}

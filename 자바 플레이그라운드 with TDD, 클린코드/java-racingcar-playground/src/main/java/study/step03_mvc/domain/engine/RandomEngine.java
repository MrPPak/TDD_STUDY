package study.step03_mvc.domain.engine;

import study.step03_mvc.utils.RandomUtils;

public class RandomEngine implements Engine{

    private static final int MIN_VALUE = 0;
    private static final int MAX_VALUE = 9;

    @Override
    public boolean moveable() {
        return RandomUtils.nextInt(MIN_VALUE, MAX_VALUE) > MOVEABLE_DIGIT;
    }
}

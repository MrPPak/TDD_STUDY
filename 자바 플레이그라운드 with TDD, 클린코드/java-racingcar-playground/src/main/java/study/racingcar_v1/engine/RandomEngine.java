package study.racingcar_v1.engine;

import study.racingcar_v1.utils.RandomUtils;

public class RandomEngine implements Engine{

    private static final int MIN_VALUE = 0;
    private static final int MAX_VALUE = 9;

    @Override
    public boolean movable() {
        return RandomUtils.nextInt(MIN_VALUE, MAX_VALUE) > MOVABLE_VALUE;
    }
}

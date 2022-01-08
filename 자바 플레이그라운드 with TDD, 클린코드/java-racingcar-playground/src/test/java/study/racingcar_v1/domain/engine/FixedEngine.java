package study.racingcar_v1.domain.engine;

import study.racingcar_v1.engine.Engine;

public class FixedEngine implements Engine {

    private int num;

    public FixedEngine(int num) {
        this.num = num;
    }

    @Override
    public boolean movable() {
        return num > MOVABLE_VALUE;
    }
}

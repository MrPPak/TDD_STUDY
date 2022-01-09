package study.racingcar_v1.domain.engine;

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

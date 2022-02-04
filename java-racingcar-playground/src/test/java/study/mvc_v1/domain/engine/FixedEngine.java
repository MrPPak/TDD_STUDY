package study.mvc_v1.domain.engine;

public class FixedEngine implements Engine {

    private int num;

    public FixedEngine(int num) {
        this.num = num;
    }

    @Override
    public boolean moveable() {
        return num > MOVABLE_DIGIT;
    }
}

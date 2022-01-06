package study.step03_mvc.domain.engine;

public class FixedEngine implements Engine{

    private int num;

    public FixedEngine(int num) {
        this.num = num;
    }

    @Override
    public boolean moveable() {
        return num > MOVEABLE_DIGIT;
    }
}

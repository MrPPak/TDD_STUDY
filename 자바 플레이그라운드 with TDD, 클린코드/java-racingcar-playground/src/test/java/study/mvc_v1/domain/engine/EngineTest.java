package study.mvc_v1.domain.engine;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EngineTest {

    @Test
    public void 자동차_이동여부_테스트() throws Exception {

        Engine moveableEngine = new FixedEngine(4);
        Engine nonMoveableEngine = new FixedEngine(3);

        Assertions.assertTrue(moveableEngine.moveable());
        Assertions.assertTrue(!nonMoveableEngine.moveable());
    }
}

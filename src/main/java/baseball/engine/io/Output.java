package baseball.engine.io;

import baseball.engine.model.BallCount;

public interface Output {
    void ballCount(BallCount ballCount);

    void inputError(RuntimeException ex);

    void correct();
}

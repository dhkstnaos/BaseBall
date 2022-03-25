package baseball.engine;

import baseball.engine.io.Input;
import baseball.engine.io.NumberGenerator;
import baseball.engine.io.Output;
import baseball.engine.model.BallCount;
import baseball.engine.model.Numbers;
import lombok.AllArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
public class BaseBall implements Runnable {
    private final int COUNT_OF_NUMBERS = 3;

    private NumberGenerator generator;
    private Input input;
    private Output output;


    @Override
    public void run() {
        Numbers answer = generator.generate(COUNT_OF_NUMBERS);

        while (true) {
            try {
                String inputString = input.input("숫자를 맞춰보세요. :");

                BallCount bc = BallCount.create(answer, Numbers.parse(inputString));
                output.ballCount(bc);

                if (bc.getStrike() == COUNT_OF_NUMBERS) {
                    output.correct();
                    break;
                }
            } catch (RuntimeException e) {
                output.inputError(e);
            }
        }
    }
}
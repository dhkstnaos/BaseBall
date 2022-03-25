package baseball.engine;

import baseball.engine.io.Input;
import baseball.engine.io.NumberGenerator;
import baseball.engine.io.Output;
import baseball.engine.model.BallCount;
import baseball.engine.model.Numbers;
import lombok.AllArgsConstructor;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@AllArgsConstructor
public class BaseBall implements Runnable {
    private static int COUNT_OF_NUMBERS=3;
    private NumberGenerator generator;
    private Input input;
    private Output output;

    @Override
    public void run() {
        Numbers answer = generator.generate(COUNT_OF_NUMBERS);

        while (true) {
            String inputString = this.input.input("숫자를 맞춰보세요: ");
            Optional<Numbers> parse = parse(inputString);
            if(!parse.isPresent()) output.inputError();
            BallCount ballCount = ballCount(answer, parse.get());
            output.ballCount(ballCount);
            if(ballCount.getStrike()==COUNT_OF_NUMBERS) {
                output.correct();
                break;
            }
        }
    }
    private Optional<Numbers> parse(String inputString) {
        if(inputString.length()==COUNT_OF_NUMBERS) return Optional.empty();
        long count = inputString.chars()
                .filter(Character::isDigit)
                .map(Character::getNumericValue)
                .filter(i-> i>0)
                .distinct()
                .count();
        if(count!=3) return Optional.empty();
        return Optional.of(
                new Numbers(
                        inputString.chars()
                                .map(Character::getNumericValue)
                                .boxed()
                                .toArray(Integer[]::new)
                )
        );
    }

    private BallCount ballCount(Numbers answer, Numbers inputNumbers) {
        //stream 바깥의 기능을 추가하려면 동기화 기능 추가해야함.
        AtomicInteger strike= new AtomicInteger();
        AtomicInteger ball= new AtomicInteger();
        answer.indexedForEach((a,i) -> {
            inputNumbers.indexedForEach((b,j)-> {
                if(!a.equals(b)) return;
                if(i.equals(j)) strike.addAndGet(1);
                else ball.addAndGet(1);
            });
        });
        return null;
    }


}

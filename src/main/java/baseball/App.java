package baseball;

import baseball.engine.BaseBall;
import baseball.engine.io.Input;
import baseball.engine.io.NumberGenerator;
import baseball.engine.io.Output;

public class App {
    public static void main(String[] args) {
        NumberGenerator generator = new HackFakerNumberGenerator();
        Console console = new Console();
        new BaseBall(generator,console,console).run();
    }
}

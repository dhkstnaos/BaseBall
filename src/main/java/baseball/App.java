package baseball;

import baseball.engine.BaseBall;
import baseball.engine.io.Input;
import baseball.engine.io.NumberGenerator;
import baseball.engine.io.Output;

public class App {
    public static void main(String[] args) {
        NumberGenerator generator = new FakerNumberGenerator();
        Input input;
        Output output;
        new BaseBall(generator,input,output).run();
    }
}

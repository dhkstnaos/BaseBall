package baseball;
import baseball.engine.io.Input;
import baseball.engine.io.Output;
import baseball.engine.model.BallCount;

import java.util.Scanner;

public class Console implements Input, Output {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public String input(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    @Override
    public void ballCount(BallCount bc) {
        System.out.println(bc.getStrike() + " Strikes, " + bc.getBall() + " Balls");
    }

    @Override
    public void inputError(RuntimeException ex) {
        System.out.println(ex.getMessage());
    }

    @Override
    public void correct() {
        System.out.println("정답입니다.");
    }
}

package baseball.engine.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class NumbersTest {

    @Test
    void numbers_생성() {
        final Numbers numbers = new Numbers(3, 1, 2);

        assertThat(numbers).isEqualTo(new Numbers(3, 1, 2));
    }

    @Test
    void _같은숫자로_numbers_생성불가() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Numbers(3, 3, 1));
    }

    @Test
    void _0이나_음수로_numbers_생성불가() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Numbers(0, 3, 1));
        assertThatIllegalArgumentException().isThrownBy(() -> new Numbers(-1, 3, 1));
    }

    @Test
    void _10이상의_숫자로_numbers_생성불가() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Numbers(10, 3, 1));
    }

    @Test
    void 문자열을_입력받아_numbers_생성() {
        final Numbers numbers = Numbers.parse("123");

        assertThat(numbers).isEqualTo(new Numbers(1, 2, 3));
    }

    public enum Number {
        ONE(1), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9);

        private final int number;

        Number(final int number) {
            this.number = number;
        }

        public static Number parse(char number) {
            return Arrays.stream(values())
                         .filter(it -> it.number == number - 48)
                         .findFirst()
                         .orElseThrow(() -> new IllegalArgumentException("파싱 실패"));
        }
    }
}
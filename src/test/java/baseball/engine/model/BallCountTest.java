package baseball.engine.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BallCountTest {

    @Test
    void 입력받은_숫자들과_랜덤하게만든_야구공들을_비교해서_볼카운트_생성() {
        //given
        final Numbers answer = new Numbers(1, 2, 3);
        final Numbers input = new Numbers(1, 2, 9);

        //when
        final BallCount ballCount = BallCount.create(answer, input);

        //then
        assertThat(ballCount).isNotNull();
        assertThat(ballCount.getStrike()).isEqualTo(2);
        assertThat(ballCount.getBall()).isEqualTo(0);
    }

    @Test
    void _3개가맞으면_스트라이크() {
        //given
        final Numbers answer = new Numbers(1, 2, 3);
        final Numbers input = new Numbers(1, 2, 3);

        //when
        final BallCount ballCount = BallCount.create(answer, input);

        //then
        assertThat(ballCount.getStrike()).isEqualTo(3);
        assertThat(ballCount.getBall()).isEqualTo(0);
    }

    @Test
    void _있는숫자여도_같은위치에_있는_숫자가아니면_볼() {
        //given
        final Numbers answer = new Numbers(1, 2, 3);
        final Numbers input = new Numbers(3, 1, 2);

        //when
        final BallCount ballCount = BallCount.create(answer, input);

        //then
        assertThat(ballCount.getStrike()).isEqualTo(0);
        assertThat(ballCount.getBall()).isEqualTo(3);
    }
}

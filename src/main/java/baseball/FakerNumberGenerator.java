package baseball;

import baseball.engine.io.NumberGenerator;
import baseball.engine.model.Numbers;
import com.github.javafaker.Faker;

public class FakerNumberGenerator implements NumberGenerator {
    private final Faker faker = new Faker();

    @Override
    public Numbers generate(int count) {
        return new Numbers(faker.number().randomDigitNotZero(), faker.number().randomDigitNotZero(), faker.number().randomDigitNotZero());
    }
}

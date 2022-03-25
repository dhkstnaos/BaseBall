package baseball.engine.model;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.*;
import java.util.function.BiConsumer;

@ToString
@EqualsAndHashCode
public class Numbers {
    private final Integer[] nums;

    public Numbers(Integer... nums) {
        if (Arrays.stream(nums).anyMatch(Objects::isNull)) {
            throw new IllegalArgumentException("숫자는 필수값임");
        }

        if (Arrays.stream(nums).anyMatch(it -> it < 1)) {
            throw new IllegalArgumentException("0이나 음수 허용하지않음");
        }

        if (Arrays.stream(nums).anyMatch(it -> it > 9)) {
            throw new IllegalArgumentException("0이나 음수 허용하지않음");
        }

        final Set<Integer> set = new HashSet<>(Arrays.asList(nums));
        if (set.size() != 3) {
            throw new IllegalArgumentException("중복숫자 허용하지않음");
        }

        this.nums = nums;
    }

    public static Numbers parse(String inputString) {
        return Optional.of(
                new Numbers(
                        inputString.chars()
                                   .map(Character::getNumericValue)
                                   .boxed()
                                   .toArray(Integer[]::new)
                )
        ).orElseThrow(() -> new IllegalArgumentException("파싱 실패"));
    }

    public void indexedForEach(BiConsumer<Integer, Integer> consumer) {
        for (int i = 0; i < nums.length; i++) {
            consumer.accept(nums[i], i);
        }
    }
}

package programmer.zaman.now.test;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extensions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import programmer.zaman.now.test.resolver.RandomParameterResolver;

import java.util.List;
import java.util.Random;


//@Extensions({
//        @ExtendWith(RandomParameterResolver.class)
//})
public class RandomCalculatorTest extends AbstrakCalculatorTest {

//    private Calculator calculator = new Calculator();

    @Test
    void testRandom(TestInfo info, Random random) {

        int a = random.nextInt();
        int b = random.nextInt();

        int result = calculator.add(a, b);
        int expected = a + b;

        Assertions.assertEquals(expected, result);
    }

    @DisplayName("Test random calculator")
    @RepeatedTest(
            value = 10,
            name = "{displayName} ke {currentRepetition} dari {totalRepetitions}"
    )
    void testRandomRepeat(TestInfo info, Random random) {

        int a = random.nextInt();
        int b = random.nextInt();

        int result = calculator.add(a, b);
        int expected = a + b;

        Assertions.assertEquals(expected, result);
    }

    @DisplayName("Test random calculator")
    @RepeatedTest(
            value = 10,
            name = "{displayName}"
    )
    void testRandomRepeatInfo(TestInfo info, Random random, RepetitionInfo repetitionInfo) {

        System.out.println(info.getDisplayName() + " ke " + repetitionInfo.getCurrentRepetition() + " dari " + repetitionInfo.getTotalRepetitions());

        int a = random.nextInt();
        int b = random.nextInt();

        int result = calculator.add(a, b);
        int expected = a + b;

        Assertions.assertEquals(expected, result);
    }

    @DisplayName("Test Calculator")
    @ParameterizedTest(name = "{displayName} dengan parameter {0}")
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 43, 67, 98})
    void testWithParameter(int value) {
        int expected = value + value;
        Integer result = calculator.add(value, value);

        Assertions.assertEquals(expected, result);
    }

    public static List<Integer> parameterSource() {
        return List.of(1, 2, 3, 5, 12, 65, 88);
    }

    @DisplayName("Test Calculator")
    @ParameterizedTest(name = "{displayName} dengan parameter {0}")
    @MethodSource({"parameterSource"})
    void testWithMethodSource(Integer value) {
        int expected = value + value;
        Integer result = calculator.add(value, value);

        Assertions.assertEquals(expected, result);
    }
}

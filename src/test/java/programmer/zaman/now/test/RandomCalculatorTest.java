package programmer.zaman.now.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extensions;
import programmer.zaman.now.test.resolver.RandomParameterResolver;

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
}

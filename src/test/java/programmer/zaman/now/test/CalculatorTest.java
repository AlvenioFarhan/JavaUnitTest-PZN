package programmer.zaman.now.test;

import org.junit.jupiter.api.*;
import org.opentest4j.TestAbortedException;
import programmer.zaman.now.test.generator.SimpleDisplayNameGenerator;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

@DisplayNameGeneration(SimpleDisplayNameGenerator.class)
//@DisplayName("Test untuk Calculator class")
public class CalculatorTest {
    private Calculator calculator = new Calculator();

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Before All");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("After All");
    }

    @BeforeEach
    public void setUp() {
        System.out.println("Before Each");
    }

    @AfterEach
    public void tearDown() {
        System.out.println("After Each");
    }


    @Test
//    @DisplayName("Test skenario sukses untuk method add(Integer, Integer")
    public void testAddSuccess() {
        Integer result = calculator.add(10, 10);

        assertEquals(20, result);

//        if (result != 20) {
//            throw new RuntimeException("Test gagal");
//        }
    }

    @Test
    public void testDivideSuccess() {
        Integer result = calculator.divide(100, 10);
        assertEquals(10, result);
    }

    @Test
    public void testDevideFailed() {
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.divide(10, 0);
        });
    }


    @Test
    @Disabled
    public void testComingSoon() {
        //TODO ComingSoon
    }

    @Test
    public void testAborted() {
        String profile = System.getenv("PROFILE");
        if (!"DEV".equals(profile)) {
            throw new TestAbortedException("Test dibatalkan karena bukan DEV");
        }

        //unit test untuk DEV
    }

    @Test
    public void testAssumptions() {
        assumeTrue("DEV".equals(System.getenv("PROFILE")));

        //unit test untuk DEV
    }

}

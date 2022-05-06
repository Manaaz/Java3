package lesson8.test;

import lesson6.test.Calculator;
import lesson7.MyAnnotation;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.Duration;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void startUp() {
        System.out.println("начинается тест");
        calculator = new Calculator();
    }

    @AfterEach
    void shutdown() {
        System.out.println("тест завершается");
    }

    @BeforeAll
    static void mainStart() {
        System.out.println("MAIN START");
    }

    @AfterAll
    static void mainEnd() {
        System.out.println("MAIN END");
    }

    @DisplayName("Сложение 3 и 5")
    @Test
    void testAdd1() {
        Assertions.assertEquals(8, calculator.add(3, 5));
    }

    @DisplayName("Сложение 7 и 5")
    @Test
    void testAdd2() {
        Assertions.assertEquals(10, calculator.add(7, 5));
    }

    @DisplayName("Проверка исключения")
    @Test
    void testException() {
        Assertions.assertThrows(ArithmeticException.class, () -> calculator.div(8, 0));
    }

    @DisplayName("Проверка таймаута и деление")
    @Test
    void testTimeout() {
        Assertions.assertTimeout(Duration.ofSeconds(1), () -> {
            Assertions.assertEquals(9, calculator.div(54, 6));
            Thread.sleep(1500);
        });
    }

    @DisplayName("Параметризированный тест сложения и таймаута")
    @ParameterizedTest
    @MethodSource("data")
    void paramTest(int expected, int a, int b) {
        Assertions.assertTimeout(Duration.ofSeconds(1), () -> {
            Assertions.assertEquals(expected, calculator.add(a, b));
        });
    }

    static Stream<Arguments> data() {
        return Stream.of(
                Arguments.arguments(6, 2, 4),
                Arguments.arguments(0, 2, -3),
                Arguments.arguments(0, Integer.MAX_VALUE, Integer.MIN_VALUE),
                Arguments.arguments(Integer.MIN_VALUE, Integer.MAX_VALUE, 1),
                Arguments.arguments(-5, 2, -7)
        );
    }


}
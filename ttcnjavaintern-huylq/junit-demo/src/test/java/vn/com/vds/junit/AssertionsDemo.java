package vn.com.vds.junit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(JUnitPlatform.class)
public class AssertionsDemo {

    <T extends Number> T calculate(List<T> inputNumbers, BinaryOperator<T> operator) {
        return inputNumbers.stream().reduce(operator).get();
    }

    @Test
    @DisplayName("Calculation test")
    public void assertEqualsTest() {
        assertEquals(10, calculate(Arrays.asList(1, 2, 3, 4), Integer::sum));
    }

    @Test
    public void exceptionTest() {
        assertThrows(ArithmeticException.class,
                () -> calculate(Arrays.asList(2, 0), (a, b) -> a / b));
    }

    @Test
    @EnabledOnJre(JRE.JAVA_8)
    @DisplayName("JRE Test")
    public void groupedAssertionsTest() {
        assertAll("Calculation",
                () -> assertEquals(12, calculate(Arrays.asList(3, 4, 5), (a, b) -> a + b)),
//                () -> assertEquals(10, calculate(Arrays.asList(10, 4), (a, b) -> a - b)),
//                () -> assertEquals(1, calculate(Arrays.asList(10, 4), (a, b) -> a - b)),
//                () -> assertEquals(4, calculate(Arrays.asList(10, 4), (a, b) -> a - b)),
                () -> assertEquals(6, calculate(Arrays.asList(10, 4), (a, b) -> a - b))
        );
    }

    @ParameterizedTest
    @CsvSource({"1, 1", "4, 4"})
    public void timeoutExceededTest(int a, int b) {
        assertEquals(a, b);
        assertTimeout(Duration.ofMillis(100), () -> {
            Thread.sleep(50);
        });
    }

    @Test
    public void testAssertEqualsAndSame(){
        String str1 = new String("test");
        String str2 = new String("test");
        assertEquals(str2, str1);
//        assertSame(str2, str1);
        assertSame("test", str1.intern());
    }
}

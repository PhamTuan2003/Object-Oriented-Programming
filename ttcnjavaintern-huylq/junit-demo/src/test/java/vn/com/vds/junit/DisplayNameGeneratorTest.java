package vn.com.vds.junit;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("Demo DisplayNameGenerator")
public class DisplayNameGeneratorTest {
    @Nested
    @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
    class Non_static_nested_class {

        @Test
        public void test_method_with_no_params(){

        }

        @ParameterizedTest(name = "Test int number with value {0}")
        @ValueSource(ints = {-10})
        public void parameterized_test_method(int num) {
            Assertions.assertEquals(-10, num);
        }
    }
}

package vn.com.vds.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

public class AssumptionsDemo {
    @Test
    public void testOnlyOnDevServer(){
        Assumptions.assumeTrue(5 > 1);
        Assertions.assertEquals(15, Stream.of(1, 2, 3, 4, 5).mapToInt(i -> i).sum());
    }
}

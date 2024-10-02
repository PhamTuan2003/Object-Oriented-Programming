package vn.com.vds.junit;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;

@DisplayNameGeneration(DisplayNameGenerator.Simple.class)
public class EnvironmentTest {
    @Test
    @EnabledOnOs(OS.WINDOWS)
    public void testRunOnWindows(){
    }

    @Test
    @EnabledOnOs(OS.MAC)
    public void testRunOnMac(){
    }

    @Test
    @EnabledOnJre(JRE.JAVA_11)
    public void testRunOnJava11(){
    }

    @Test
    @EnabledOnJre(JRE.JAVA_8)
    public void testRunOnJava8(){
    }

    @Test
    @EnabledForJreRange(min = JRE.JAVA_8, max = JRE.JAVA_11)
    public void testRunOnJava8ToJava11(){
    }
}

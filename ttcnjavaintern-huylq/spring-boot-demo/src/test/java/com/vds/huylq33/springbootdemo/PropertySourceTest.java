package com.vds.huylq33.springbootdemo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@TestPropertySource(locations = "/application.properties", properties = "os=Windows")
public class PropertySourceTest {

    @Value("${os}")
    private String os;

    @Test
    public void testOS() {
        assertEquals("Windows", os);
    }

    @Test
    public void testServerPort(@Value("${server.port}") String port) {
        assertEquals("8080", port); // Must specify application.properties
    }

    @Test
    public void testJAVA(@Value("${java.home}") String java,
        @Value("${java.vendor}") String vendor) {
        System.out.println(java);
        System.out.println(vendor);
    }
}

package com.vds.huylq33.springbootdemo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

@SpringBootTest(
    args = "randomArgs",
    properties = "some.property=randomValue",
    webEnvironment = WebEnvironment.RANDOM_PORT
)
public class GreetRestControllerTest {

    @Autowired
    private TestRestTemplate template;

    @LocalServerPort
    private int port;

    private URL base;


    @BeforeEach
    public void setUp() throws MalformedURLException {
        this.base = new URL("http://localhost:" + port + "/test");
    }

    @Test
    public void getHello() {
        ResponseEntity<String> response = template.getForEntity(base.toString(), String.class);
        assertEquals("Greetings from Spring Boot!", response.getBody());
    }
}

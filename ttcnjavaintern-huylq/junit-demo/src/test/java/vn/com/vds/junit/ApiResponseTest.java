package vn.com.vds.junit;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import vn.com.vds.model.User;
import vn.com.vds.model.UserService;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(JUnitPlatform.class)
public class ApiResponseTest {
    private static UserService userService;
    private static File jsonFile;

    @BeforeAll
    public static void setup() {
        userService = new UserService();
        jsonFile = new File("src/test/resources/response.json");

    }

    @Test
    @DisplayName("Get users from json response")
    public void jsonResponseTest() throws IOException {
        List<User> user = userService.readAllUsersFromJsonFile(jsonFile);
//        user.forEach(u -> {
//            try {
//                System.out.println(mapper.writeValueAsString(u));
//            } catch (JsonProcessingException e) {
//                e.printStackTrace();
//            }
//        });
        assertEquals(10, user.size());
    }
}

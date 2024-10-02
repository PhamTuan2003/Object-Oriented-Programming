package vn.com.vds.model;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserService {
    private ObjectMapper objectMapper = new ObjectMapper();
    private UserDAO userDAO;

    public UserService() {
    }

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public List<User> getAllUsers() {
        List<User> users = null;
        if (userDAO.isDBConnected()) {
            users = new ArrayList<>();
        }
        return users;
    }

    public List<User> readAllUsersFromJsonFile(File jsonFile) {
        List<User> users = null;
        try {
            users = objectMapper.readValue(jsonFile, new TypeReference<List<User>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }

    public boolean isJsonUserMappedDBRecord(User userInJson) {
        return userDAO.getUniqueId() == Integer.parseInt(userInJson.getId());
    }

    public void printUser(User user) {
        System.out.println(user);
    }
}

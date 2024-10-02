package com.vds.huylq33.service;

import com.vds.huylq33.model.User;
import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User getUser(int id);

    void saveUser(User user);

    void updateUser(User user);

    void deleteUser(int id);
}

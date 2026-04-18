package org.example.usermanagementapi.services;

import org.example.usermanagementapi.model.User;
import java.util.List;

    public interface UserService {

        List<User> getAllUsers();

        User getUserById(int id);

        User createUser(User user);

        User updateUser(int id, User user);

        String deleteUser(int id);
    }


package org.example.usermanagementapi.services.impl;



import org.example.usermanagementapi.model.User;
import org.example.usermanagementapi.services.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private List<User> users = new ArrayList<>();
    private int count = 1;

    @Override
    public List<User> getAllUsers() {
        return users;
    }

    @Override
    public User getUserById(int id) {
        return users.stream()
                .filter(u -> u.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public User createUser(User user) {
        user.setId(count++);
        users.add(user);
        return user;
    }

    @Override
    public User updateUser(int id, User user) {
        for (User u : users) {
            if (u.getId() == id) {
                u.setName(user.getName());
                u.setAge(user.getAge());
                return u;
            }
        }
        return null;
    }

    @Override
    public String deleteUser(int id) {
        users.removeIf(u -> u.getId() == id);
        return "Deleted";
    }
}
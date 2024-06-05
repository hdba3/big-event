package org.example.service;

import org.example.pojo.User;

public interface UserService {
    User selectByUsername(String username);

    void insert(String username, String password);
}

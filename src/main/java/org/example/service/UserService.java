package org.example.service;

import org.example.pojo.User;

public interface UserService {
    User selectByUsername(String username);

    void insert(String username, String password);

    void update(User user);

    void updateAvatar(String avatarUrl);

    void updatePwd(String newPwd);
}

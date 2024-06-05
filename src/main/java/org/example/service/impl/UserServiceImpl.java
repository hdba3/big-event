/**
 * @author 33319
 * @Description service层为业务逻辑层, 即编写方法来实现业务逻辑，需要调用mapper层的方法
 * @create 2024/6/5 14:31
 */
package org.example.service.impl;

import org.example.mapper.UserMapper;
import org.example.pojo.User;
import org.example.service.UserService;
import org.example.utils.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User selectByUsername(String username) {
        return userMapper.selectByUsername(username);
    }

    @Override
    public void insert(String username, String password) {
        //使用MD5工具类对密码进行加密
        String md5password = Md5Util.getMD5String(password);
        userMapper.insert(username, md5password);
    }
}

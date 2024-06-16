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
import org.example.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;

@Service
class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    //根据用户名查询用户
    @Override
    public User selectByUsername(String username) {
        return userMapper.selectByUsername(username);
    }

    //插入用户
    @Override
    public void insert(String username, String password) {
        //使用MD5工具类对密码进行加密
        String md5password = Md5Util.getMD5String(password);
        userMapper.insert(username, md5password);
    }

    //更新用户
    @Override
    public void update(User user) {
        user.setUpdateTime(LocalDateTime.now());
        userMapper.update(user);
    }

    //更新用户头像
    @Override
    public void updateAvatar(String avatarUrl) {
        Map<String, Object> map = ThreadLocalUtil.get();
        Integer id = (Integer) map.get("id");
        userMapper.updateAvatar(avatarUrl, id);
    }

    //更新用户密码
    @Override
    public void updatePwd(String newPwd) {
        Map<String, Object> map = ThreadLocalUtil.get();
        Integer id = (Integer) map.get("id");
        String md5password = Md5Util.getMD5String(newPwd);
        userMapper.updatePwd(md5password, id);
    }
}

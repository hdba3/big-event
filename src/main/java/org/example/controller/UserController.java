/**
 * @author 33319
 * @Description controller层为控制层，用于接收请求，调用service层的方法，返回响应结果，即决定在什么网址使用什么方法返回什么数据
 * 编写顺序mapper->service->controller或者controller->service->mapper
 * @create 2024/6/5 14:39
 */
package org.example.controller;


import org.example.pojo.Result;
import org.example.pojo.User;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/user")
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Result register(String username, String password) {
        User u = userService.selectByUsername(username);
        if (u == null) {
            userService.insert(username, password);
            return Result.success();
        } else {
            return Result.error("用户名已存在");
        }
    }
}

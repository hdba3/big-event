/**
 * @author 33319
 * @Description controller层为控制层，用于接收请求，调用service层的方法，返回响应结果，即决定在什么网址使用什么方法返回什么数据
 * 编写顺序mapper->service->controller或者controller->service->mapper
 * @create 2024/6/5 14:39
 */
package org.example.controller;


import jakarta.validation.constraints.Pattern;
import org.example.pojo.Result;
import org.example.pojo.User;
import org.example.service.UserService;
import org.example.utils.JwtUtil;
import org.example.utils.Md5Util;
import org.example.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Validated  //开启数据校验
@RequestMapping("/user")
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Result register(@Pattern(regexp = "^\\S{5,16}") String username, @Pattern(regexp = "^\\S{5,16}") String password) {
        User u = userService.selectByUsername(username);
        if (u == null) {
            userService.insert(username, password);
            return Result.success();
        } else {
            return Result.error("用户名已存在");
        }
    }

    @PostMapping("/login")
    public Result<String> login(@Pattern(regexp = "^\\S{5,16}") String username, @Pattern(regexp = "^\\S{5,16}") String password) {
        User u = userService.selectByUsername(username);
        if (u == null) {
            return Result.error("用户名不存在");
        }
        if (Md5Util.getMD5String(password).equals(u.getPassword())) {
            Map<String, Object> claims = new HashMap<>();
            claims.put("id", u.getId());
            claims.put("username", u.getUsername());
            String token = JwtUtil.genToken(claims);
            return Result.success(token);
        }
        return Result.error("密码错误");

    }

    @GetMapping("/userInfo")
    public Result userInfo(/*@RequestHeader("Authorization") String token*/) {
//        Map<String, Object> map = JwtUtil.parseToken(token);
        //用ThreadLocalUtil工具类获取业务数据
        Map<String, Object> map = ThreadLocalUtil.get();
        String username = (String) map.get("username");
        User u = userService.selectByUsername(username);
        return Result.success(u);
    }
}

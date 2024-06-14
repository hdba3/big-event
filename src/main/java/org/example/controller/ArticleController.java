/**
 * @author 33319
 * @Description
 * @create 2024/6/12 9:19
 */
package org.example.controller;

import org.example.pojo.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/article")
public class ArticleController {
    @GetMapping("/list")
    //RequestHeader注解用于获取请求头中的信息
    public Result<String> list(/*@RequestHeader(name = "Authorization") String token, HttpServletResponse response*/) {
//        try {
//            Map<String, Object> claims = JwtUtil.parseToken(token);
//            return Result.success("登录成功");
//        } catch (Exception e) {
//            e.printStackTrace();
//            //设置返回的状态码为401
//            response.setStatus(401);
//            return Result.error("token无效");
//        }
        return Result.success("登录成功");
    }
}
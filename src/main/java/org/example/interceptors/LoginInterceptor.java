/**
 * @author 33319
 * @Description 登录拦截器用于验证jwt令牌
 * @create 2024/6/14 14:04
 */
package org.example.interceptors;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.utils.JwtUtil;
import org.example.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Map;

@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    //preHandle的返回值决定了是否继续处理请求，true表示继续处理，false表示不处理
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //获取请求头中的Authorization
        String token = request.getHeader("Authorization");
        //解析token
        try {
            ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
            String redisToken = ops.get(token);
            if (redisToken == null) {
                //token失效
                throw new RuntimeException("登录失效");
            }
            Map<String, Object> claims = JwtUtil.parseToken(token);

            //把业务数据存入ThreadLocal中
            ThreadLocalUtil.set(claims);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            //设置返回的状态码为401
            response.setStatus(401);
            return false;
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //清空ThreadLocal中的数据
        ThreadLocalUtil.remove();
    }
}

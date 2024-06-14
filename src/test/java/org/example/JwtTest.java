/**
 * @author 33319
 * @Description
 * @create 2024/6/12 8:51
 */
package org.example;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.junit.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtTest {

    @Test
    public void getJwt() {
        Map<String, Object> clams = new HashMap<>();
        clams.put("username", "admin");
        clams.put("id", 1);
        String token = JWT.create()
                .withClaim("user", clams)
                .withExpiresAt(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24)
                ).sign(Algorithm.HMAC256("bwl"));
        System.out.println(token);
    }

    @Test
    public void parseToken() {
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJjbGFpbXMiOnsiaWQiOjMsInVzZXJuYW1lIjoiMjIyMjIifSwiZXhwIjoxNzE4MjAwNTc1fQ.I1xAaxnPdjrx2iRSI6-cC4fc4r4ao6D4qyo_sZNXQzQ";
        Map<String, Object> claims = JWT.require(Algorithm.HMAC256("bwl"))
                .build()
                .verify(token)
                .getClaim("claims")
                .asMap();
        System.out.println(claims);
    }
}

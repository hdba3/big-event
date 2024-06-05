/**
 * @author 33319
 * @Description
 * @create 2024/6/5 13:38
 */
package org.example.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private Integer id;
    private String username;
    private String password;
    private String nickname;
    private String email;
    private String userPic;
    private Date createTime;
    private Date updateTime;
}

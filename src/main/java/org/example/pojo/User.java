/**
 * @author 33319
 * @Description
 * @create 2024/6/5 13:38
 */
package org.example.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.Date;

@Data
public class User {
    private Integer id;
    private String username;
    @JsonIgnore //让springmvc把当前对象返回成json时，忽略这个字段
    private String password;
    private String nickname;
    private String email;
    private String userPic;
    private Date createTime;
    private Date updateTime;
}

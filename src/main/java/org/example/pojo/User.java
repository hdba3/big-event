/**
 * @author 33319
 * @Description
 * @create 2024/6/5 13:38
 */
package org.example.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class User {
    @NotNull    //非空校验，值可以为空，不能为null
    private Integer id;
    private String username;
    @JsonIgnore //让springmvc把当前对象返回成json时，忽略这个字段
    private String password;
    @NotEmpty   //非空校验，值不能为空
    @Pattern(regexp = "^\\S{1,16}")
    private String nickname;
    @NotEmpty   //非空校验
    @Email  //邮箱校验
    private String email;
    private String userPic;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}

/**
 * @author 33319
 * @Description
 * @create 2024/6/5 13:40
 */
package org.example.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.groups.Default;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import java.time.LocalDateTime;

@Data
public class Category {
    @NotNull(groups = {Update.class})
    private Integer id;
    @NotEmpty
    private String categoryName;
    @NotEmpty
    private String categoryAlias;
    //    @JsonIgnore //让springmvc把当前对象返回成json时，忽略这个字段
    private Integer createUser;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;

    //如果没有指定分组，则默认是Default组
    //组与组之间的规则可以继承extends

    //分组校验
    //新增时校验
    public interface Insert extends Default {
    }

    //更新时校验
    public interface Update extends Default {
    }
}
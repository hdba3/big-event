/**
 * @author 33319
 * @Description
 * @create 2024/6/5 13:40
 */
package org.example.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import java.time.LocalDateTime;

@Data
public class Category {
    private Integer id;
    @NotEmpty
    private String categoryName;
    @NotEmpty
    private String categoryAlias;
    @JsonIgnore //让springmvc把当前对象返回成json时，忽略这个字段
    private Integer createUser;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
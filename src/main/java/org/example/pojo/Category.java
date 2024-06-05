/**
 * @author 33319
 * @Description
 * @create 2024/6/5 13:40
 */
package org.example.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class Category {
    private Integer id;
    private String categoryName;
    private String categoryAlias;
    private Integer createUser;
    private Date createTime;
    private Date updateTime;
}
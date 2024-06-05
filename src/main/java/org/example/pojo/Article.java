/**
 * @author 33319
 * @Description
 * @create 2024/6/5 13:41
 */
package org.example.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class Article {
    private Integer id;
    private String title;
    private String content;
    private String coverImg;
    private String state;
    private Integer categoryId;
    private Integer createUser;
    private Date createTime;
    private Date updateTime;
}

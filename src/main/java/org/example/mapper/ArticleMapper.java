package org.example.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.example.pojo.Article;

import java.util.List;

//@RequestMapping("/article")
@Mapper
public interface ArticleMapper {
    //添加文章
    @Insert("insert into article(title,content,state,cover_img,create_user,create_time,update_time,category_id) values(#{title},#{content},#{state},#{coverImg},#{createUser},#{createTime},#{updateTime},#{categoryId})")
    void insert(Article article);

    List<Article> list(Integer userId, String state, Integer categoryId);
}

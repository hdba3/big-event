package org.example.mapper;

import org.apache.ibatis.annotations.*;
import org.example.pojo.Article;

import java.util.List;

//@RequestMapping("/article")
@Mapper
public interface ArticleMapper {
    //添加文章
    @Insert("insert into article(title,content,state,cover_img,create_user,create_time,update_time,category_id) values(#{title},#{content},#{state},#{coverImg},#{createUser},#{createTime},#{updateTime},#{categoryId})")
    void insert(Article article);

    //条件查询文章
    List<Article> list(Integer userId, String state, Integer categoryId);

    //更新文章
    @Update("update article set title=#{title},content=#{content},state=#{state},cover_img=#{coverImg},update_time=now(),category_id=#{categoryId} where id=#{id}")
    void update(Article article);

    //删除文章
    @Delete("delete from article where id=#{id}")
    void delete(Integer id);

    //查询文章详情
    @Select("select * from article where id=#{id}")
    Article detail(Integer id);
}

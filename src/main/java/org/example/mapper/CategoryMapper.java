package org.example.mapper;

import org.apache.ibatis.annotations.*;
import org.example.pojo.Category;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/category")
@Mapper
public interface CategoryMapper {

    //添加分类
    @Insert("insert into category(category_name,category_alias,create_user,create_time,update_time) values(#{categoryName},#{categoryAlias},#{createUser},#{createTime},#{updateTime})")
    void insert(Category category);

    //查询分类
    @Select("select * from category where create_user=#{userid}")
    List<Category> list(Integer userid);

    //查询分类详情
    @Select("select * from category where id=#{id}")
    Category detail(Integer id);

    //更新分类
    @Update("update category set category_name=#{categoryName},category_alias=#{categoryAlias},update_time=now() where id=#{id}")
    void update(Category category);

    //删除分类
    @Delete("delete from category where id=#{id}")
    void delete(Integer id);
}

package org.example.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.example.pojo.Category;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/category")
@Mapper
public interface CategoryMapper {

    //添加分类
    @Insert("insert into category(category_name,category_alias,create_user,create_time,update_time) values(#{categoryName},#{categoryAlias},#{createUser},#{createTime},#{updateTime})")
    void insert(Category category);
}

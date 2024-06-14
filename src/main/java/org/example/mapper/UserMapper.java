/**
 * @author 33319
 * @Description 编写顺序mapper->service->controller或者controller->service->mapper
 * mapper层为持久层用于操作数据库写sql语句,mapper层为接口层
 * @create 2024/6/5 14:25
 */
package org.example.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.pojo.User;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/user")
@Mapper
public interface UserMapper {
    //查询用户名是否存在
    @Select("select * from user where username=#{username}")
    User selectByUsername(String username);

    //插入用户
    @Insert("insert into user(username,password,update_time,create_time) values(#{username},#{password},now(),now())")
    void insert(String username, String password);
}

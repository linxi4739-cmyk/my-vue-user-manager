package com.example.demo.mapper;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper // 告诉 Spring 这是一个操作数据库的接口
public interface UserMapper {

    // 这一行 SQL 就会去数据库查数据，自动把结果填进 User 对象
    @Select("SELECT * FROM user WHERE id = #{id}")
    User findById(Integer id);

    // 2. 新增的插入功能（加在这里）
    @Insert("INSERT INTO user(name) VALUES(#{name})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertUser(User user);
}
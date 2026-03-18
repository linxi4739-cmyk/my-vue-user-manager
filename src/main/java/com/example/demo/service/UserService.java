package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper; // 导入刚才写的 Mapper
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    // 在 UserService 类中添加这个方法
    public int addUser(String name) {
        User user = new User();
        user.setName(name);
        return userMapper.insertUser(user);
    }

    @Autowired // 让 Spring 自动把 UserMapper 的实现类注入进来
    private UserMapper userMapper;

    public User findUserById(Integer id) {
        // 这一步就是真正的数据库查询了
        return userMapper.findById(id);
    }


}
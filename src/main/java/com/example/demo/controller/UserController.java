package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController // 告诉 Spring 这是一个接口类
@RequestMapping("/test") // 浏览器访问的前缀
public class UserController {

    @Autowired // 自动连接上面的 UserService
    private UserService userService;

    @GetMapping("/hello") // 完整路径：localhost:8080/test/hello?id=1
    public User sayHello(@RequestParam Integer id) {
        return userService.findUserById(id);
    }

    // 访问地址：http://localhost:8080/test/add?name=张三
    @GetMapping("/add")
    public String addUser(@RequestParam String name) {
        int result = userService.addUser(name);
        if (result > 0) {
            return "用户 " + name + " 添加成功！";
        } else {
            return "添加失败，请检查数据库连接。";
        }
    }


}
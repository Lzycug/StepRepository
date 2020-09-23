
package com.lzycug.learn.jpa.controller;

import com.lzycug.learn.jpa.entity.Result;
import com.lzycug.learn.jpa.entity.User;
import com.lzycug.learn.jpa.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * description：
 * author：lzyCug
 * date: 2020/9/23 18:47
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("save")
    public Result saveUser() {
        // 模拟客户端传递的用户信息
        User user = new User();
        user.setUsername("王五");
        user.setPassword("123456");
        user.setAge(25);
        user.setAddress("北京西单");
        boolean res = userService.saveUser(user);
        return res ? Result.ok() : Result.error();
    }

    @GetMapping("user")
    public Result<User> findUserByUsernameEqualsAndPasswordLike() {
        List<User> userList = userService.findUserByUsernameEqualsAndPasswordLike("李四", "123456");
        return Result.ok(userList);
    }

    @GetMapping("userMax")
    public Result<User> getUserMaxAge() {
        User user = userService.getUserMaxAge();
        return Result.ok(user);
    }
}

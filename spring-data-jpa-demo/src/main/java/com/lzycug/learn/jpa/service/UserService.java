package com.lzycug.learn.jpa.service;

import com.lzycug.learn.jpa.entity.User;

import java.util.List;

/**
 * description：
 * author：lzyCug
 * date: 2020/9/23 18:45
 */
public interface UserService {

    boolean saveUser(User user);

    List<User> findUserByUsernameEqualsAndPasswordLike(String username, String password);

    User getUserMaxAge();
}

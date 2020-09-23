package com.lzycug.learn.jpa.service.impl;

import com.lzycug.learn.jpa.dao.UserDao;
import com.lzycug.learn.jpa.entity.User;
import com.lzycug.learn.jpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * description：
 * author：lzyCug
 * date: 2020/9/23 18:46
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public boolean saveUser(User user) {
        User saveUser = userDao.save(user);
        System.out.println(saveUser);
        return true;
    }

    @Override
    public List<User> findUserByUsernameEqualsAndPasswordLike(String username, String password) {
        return userDao.findUserByUsernameEqualsAndPasswordLike(username, password);
    }

    @Override
    public User getUserMaxAge() {
        return userDao.getUserMaxAge();
    }
}

package com.lzycug.blog.test;


import com.lzycug.blog.dao.UserDao;
import com.lzycug.blog.pojo.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: lzyCug
 * @date: 2021/3/8 11:14
 * @description: 测试类
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {
    @Autowired
    UserDao userDao;

    @Test
    public void testAddUser() {
        User user = new User();
        user.setName("张三");
        user.setAge(18);
        user.setAddress("陕西西安");
        List<String> hobbies = new ArrayList<>();
        hobbies.add("乒乓球");
        hobbies.add("羽毛球");
        hobbies.add("橄榄球");
        user.setHobbies(hobbies);

        Integer row = userDao.addUser(user);
        assert(row == 1);
    }

    @Test
    public void testGetUser() {
        List<User> users = userDao.getAllUser();
        for (User user : users) {
            System.out.println(user);
        }
    }
}


package com.lzycug.learn.jpa.dao;

import com.lzycug.learn.jpa.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * description：
 * author：lzyCug
 * date: 2020/9/23 18:38
 */
public interface UserDao extends JpaRepository<User, Integer> {
    List<User> findUserByUsernameEqualsAndPasswordLike(String username, String password);

    @Query(value = "select * from t_user where age = (select max(age) from t_user)", nativeQuery = true)
    User getUserMaxAge();
}

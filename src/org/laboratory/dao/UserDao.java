package org.laboratory.dao;

import org.laboratory.entity.User;

import java.util.List;

/**
 * Created by niu on 2017/7/28.
 */
public interface UserDao {

    public User getUserById(Integer id);

    public List<User> getAllUsers();
}

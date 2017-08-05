package org.laboratory.dao;

import org.laboratory.entity.User;

import java.util.List;


public interface UserDao {

    public User getUserById(Integer id);

    public List<User> getAllUsers();
}

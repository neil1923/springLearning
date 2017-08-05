package org.laboratory.service;

import org.laboratory.entity.User;

import java.util.List;

/**
 * Created by niu on 2017/7/28.
 */
public interface UserService {

    public User getUserById(Integer id);


    public List<User> getUsers();

}

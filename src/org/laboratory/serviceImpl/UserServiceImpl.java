package org.laboratory.serviceImpl;

import org.laboratory.daoImpl.UserDaoImpl;
import org.laboratory.entity.User;
import org.laboratory.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by niu on 2017/7/28.
 */
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDaoImpl userDao;

    @Override
    public User getUserById(Integer id) {
        return userDao.getUserById(id);
    }

    @Override
    public List<User> getUsers() {
        return userDao.getAllUsers();
    }

}

package org.laboratory.daoImpl;

import org.laboratory.dao.UserDao;
import org.laboratory.entity.User;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by niu on 2017/7/28.
 */
public class UserDaoImpl implements UserDao{

    private DataSource datasource;
    private JdbcTemplate jdbcTemplateObject;

    public void setDatasource(DataSource ds) {
        this.datasource = ds;
        this.jdbcTemplateObject = new JdbcTemplate(datasource);
    }

    public User getUserById(Integer id) {
        List<User> users = null;
        String sql = "SELECT * FROM userInfo where id=" + id;
        users = jdbcTemplateObject.query(sql, new UserMapper());
        if(users.size() != 0){
            return users.get(0);
        }
        return null;
    }

    public List<User> getAllUsers() {
        List<User> users = null;
        String sql = "SELECT * FROM userInfo";
        users = jdbcTemplateObject.query(sql, new UserMapper());
        return users;
    }

}

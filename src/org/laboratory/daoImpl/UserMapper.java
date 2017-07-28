package org.laboratory.daoImpl;

import org.laboratory.entity.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by niu on 2017/7/28.
 */
public class UserMapper implements RowMapper<User> {

    public User mapRow(ResultSet rs, int rownum) throws SQLException {
        User user = new User();
        user.setId(rs.getInt("id"));
        user.setName(rs.getString("name"));

        return user;
    }

}

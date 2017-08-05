package org.laboratory.daoImpl;


import org.laboratory.entity.MyMessage;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MessageMapper implements RowMapper<MyMessage> {

    public MyMessage mapRow(ResultSet rs, int rownum) throws SQLException {
        MyMessage myMessage = new MyMessage();

        myMessage.setBlog_cmt_id(rs.getInt("blog_cmt_id"));
        myMessage.setBlog_reply_id(rs.getInt("blog_reply_id"));
        myMessage.setBlog_reply_time(rs.getDate("blog_reply_time"));
        myMessage.setContent(rs.getString("content"));
        myMessage.setFrom_uid(rs.getInt("from_uid"));
        myMessage.setTo_uid(rs.getInt("to_uid"));
        myMessage.setStatus(rs.getInt("status"));

        return myMessage;
    }

}

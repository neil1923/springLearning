package org.laboratory.daoImpl;

import org.laboratory.dao.MyMessagesDao;
import org.laboratory.entity.MyMessage;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by niu on 2017/8/5.
 */
public class MessageDaoImpl implements MyMessagesDao{

    private DataSource datasource;
    private JdbcTemplate jdbcTemplateObject;


    public void setDatasource(DataSource ds) {
        this.datasource = ds;
        this.jdbcTemplateObject = new JdbcTemplate(datasource);
    }

    @Override
    public List<MyMessage> getUserMessagesByToUid(Integer to_uid) {
        List<MyMessage> myMessages = null;
        String sql = "select * from BlogCommentReply where to_uid ="+to_uid;
        myMessages = jdbcTemplateObject.query(sql, new MessageMapper());
        return myMessages;
    }

    @Override
    public MyMessage getMessageById(Integer blog_reply_id) {
        List<MyMessage> myMessages = null;
        MyMessage message = null;
        String sql = "select *  from BlogCommentReply where blog_reply_id = "+blog_reply_id;
        myMessages  = jdbcTemplateObject.query(sql, new MessageMapper());
        if(myMessages.size()!=0){
            message = myMessages.get(0);
        }
        return message;
    }
}

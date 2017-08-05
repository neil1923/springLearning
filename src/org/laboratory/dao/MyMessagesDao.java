package org.laboratory.dao;

import org.laboratory.entity.MyMessage;
import org.laboratory.entity.User;

import java.util.List;


public interface MyMessagesDao {

    public List<MyMessage> getUserMessagesByToUid(Integer to_uid);

    public MyMessage getMessageById(Integer blog_reply_id);

}

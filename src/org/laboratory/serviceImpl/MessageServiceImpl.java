package org.laboratory.serviceImpl;

import org.laboratory.daoImpl.MessageDaoImpl;
import org.laboratory.entity.MyMessage;
import org.laboratory.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class MessageServiceImpl implements MessageService{

    @Autowired
    private MessageDaoImpl myMessagesDao;

    @Override
    public List<MyMessage> getUserMessagesByToUid(Integer to_uid) {
        return myMessagesDao.getUserMessagesByToUid(to_uid);
    }

    @Override
    public MyMessage getMessageById(Integer blog_reply_id) {
        return myMessagesDao.getMessageById(blog_reply_id);
    }
}

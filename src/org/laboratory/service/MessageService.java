package org.laboratory.service;

import org.laboratory.entity.MyMessage;
import org.laboratory.entity.User;

import java.util.List;

/**
 * Created by niu on 2017/7/28.
 */
public interface MessageService {

    public List<MyMessage> getUserMessagesByToUid(Integer to_uid);

    public MyMessage getMessageById(Integer blog_reply_id);

}

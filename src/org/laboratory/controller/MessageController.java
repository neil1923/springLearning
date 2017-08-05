package org.laboratory.controller;

import org.laboratory.entity.MyMessage;
import org.laboratory.entity.User;
import org.laboratory.service.MessageService;
import org.laboratory.serviceImpl.MessageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/domain")
public class MessageController {

    @Autowired
    private MessageServiceImpl messageSerivce;


    @RequestMapping(value = "/getUserMessagesByToUid/{id}", method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public List<MyMessage> getUserMessagesByToUid(@PathVariable Integer id){
        return messageSerivce.getUserMessagesByToUid(id);
    }

    @RequestMapping(value = "/getMessageById/{id}", method = RequestMethod.GET, produces = {
            "application/json;charset=UTF-8" })
    @ResponseBody
    public MyMessage getMessageById(@PathVariable Integer id) {
        return messageSerivce.getMessageById(id);
    }
}

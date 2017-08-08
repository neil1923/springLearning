package org.laboratory.controller;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.laboratory.entity.MyMessage;
import org.laboratory.entity.User;
import org.laboratory.serviceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/domain")
public class UserController {

	@Autowired
	private UserServiceImpl userService;


	@RequestMapping(value = "/getUserById/{id}", method = RequestMethod.GET, produces = {
			"application/json;charset=UTF-8" })
	@ResponseBody
	public User getUserById(@PathVariable Integer id) {
		return userService.getUserById(id);
	}

	@RequestMapping(value = "/getUsers", method = RequestMethod.GET, produces = {
			"application/json;charset=UTF-8" })
	@ResponseBody
	public List<User> getUsers() {
		return userService.getUsers();
	}

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String showIndex(){
		return "/index";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String doSave(User user){
		System.out.println("user的信息:"+ToStringBuilder.reflectionToString(user));
		System.out.println("user的信息:"+user.toString());
		//进行业务操作，如数据持久化,调用UserDao方法
//		user.setUser_id(1);
//		return "redirect:/domain/getUserById/"+user.getUser_id();

		return "redirect:/domain/getUsers";
	}

}

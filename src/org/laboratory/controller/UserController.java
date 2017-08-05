package org.laboratory.controller;

import org.laboratory.entity.User;
import org.laboratory.serviceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
}

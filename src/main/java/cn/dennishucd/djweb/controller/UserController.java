package cn.dennishucd.djweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.dennishucd.djweb.model.User;
import cn.dennishucd.djweb.service.UserService;

import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * UserController 
 * 
 * @author dennis
 */

@Controller
@RequestMapping(value="/user")
public class UserController {
	private final UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value="/login", method = RequestMethod.POST)
	public @ResponseBody ObjectNode login(@RequestBody User user) {
		
		return userService.login(user);
	}
}

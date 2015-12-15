package cn.dennishucd.djweb.service;

import cn.dennishucd.djweb.model.User;

import com.fasterxml.jackson.databind.node.ObjectNode;


public interface UserService {

	public ObjectNode login(User user);
	
}
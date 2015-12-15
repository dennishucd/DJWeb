package cn.dennishucd.djweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.dennishucd.djweb.utils.CodeMsg;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * UserController 
 * 
 * @author dennis
 */

@Controller
@RequestMapping(value="/user")
public class UserController {

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody ObjectNode login() {
		ObjectNode node = new ObjectMapper().createObjectNode();
		
		node.put(CodeMsg.CODE, CodeMsg.SUCCESS_CODE);
		node.put(CodeMsg.MSG, CodeMsg.SUCCESS_MSG);
		
		return node;
	}
}

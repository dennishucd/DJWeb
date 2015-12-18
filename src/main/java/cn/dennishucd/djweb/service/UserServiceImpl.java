package cn.dennishucd.djweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import cn.dennishucd.djweb.dao.UserDao;
import cn.dennishucd.djweb.model.User;
import cn.dennishucd.djweb.utils.CodeMsg;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

@Service
/* @Transactional indicates that each method in this service should run within a transaction.
 * Spring will commit the operation if the method is completed successfully
 * and will rollback if any runtime exception occurs. 
 */
@Transactional  
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	
	@Override
	public ObjectNode login(User user) {
		ObjectNode node = new ObjectMapper().createObjectNode();
		
		User tUser = userDao.findByLoginName(user.getLoginName());
		
		if (tUser == null) {
			node.put(CodeMsg.CODE, CodeMsg.USER_NOT_EXIST_CODE);
			node.put(CodeMsg.MSG, CodeMsg.USER_NOT_EXIST_MSG);
		} else if (tUser.getPasswd().endsWith(user.getPasswd())) {
			node.put(CodeMsg.CODE, CodeMsg.SUCCESS_CODE);
			node.put(CodeMsg.MSG, CodeMsg.SUCCESS_MSG);
		} else {
			node.put(CodeMsg.CODE, CodeMsg.PWD_MISMATCH_CODE);
			node.put(CodeMsg.MSG, CodeMsg.PWD_MISMATCH_MSG);
		}
		
		return node;
	}
}
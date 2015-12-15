package cn.dennishucd.djweb.dao;

import org.apache.ibatis.annotations.Select;

import cn.dennishucd.djweb.model.User;

/**
 * @author dennis
 */
public interface UserDao {

	@Select("select * from user where loginName = #{loginName}")
	public User findByLoginName(String loginName);
}

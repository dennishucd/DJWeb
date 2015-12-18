package cn.dennishucd.djweb.model;

/**
 * User
 * @author dennis
 */
public class User {

	private long id;
	private String loginName;
	private String passwd;
	private String mobile;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("id: "+id);
		sb.append(", loginName: "+loginName);
		sb.append(", passwd: "+passwd);
		sb.append(", mobile: "+mobile);
		
		return sb.toString();
	}
}

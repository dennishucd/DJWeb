package cn.dennishucd.djweb.utils;

/**
 * code和msg的设计原则：每个code唯一对应一个msg.
 * 通常2000这个code可用于每个流程中最普遍意义的那个成功，2前缀代表业务上的成功，如2000可表示获取到可用新版本，
 * 如2001可表示未检测到新版本
 * 前缀为3的可表示业务异常，如3001可表达找不到对应的产品
 * 
 * @author dennis
 */
public class CodeMsg {
	public static final String  CODE = "code";
	public static final String   MSG = "msg";
	public static final String  DATA = "data";
	public static final String TOTAL = "total";

	public static final Integer SUCCESS_CODE = 2000;
	public static final String  SUCCESS_MSG  = "成功";

	public static final Integer NO_NEW_VERSION_CODE = 2001;
	public static final String   NO_NEW_VERSION_MSG = "您的软件已经是最新版本了!";
	
	public static final Integer USER_NOT_EXIST_CODE = 3001;
	public static final String   USER_NOT_EXIST_MSG = "用户不存在";
	
	public static final Integer PWD_MISMATCH_CODE = 3001;
	public static final String   PWD_MISMATCH_MSG = "密码错误";
	
	public static final Integer UPLOAD_FAILED_CODE = 3014;
	public static final String UPLOAD_FAILED_MSG = "文件上传失败";
	
	public static final Integer FILE_EMPTY_CODE = 3015;
	public static final String FILE_EMPTY_MSG = "文件为空";
}

package cn.dennishucd.djweb.utils;

import java.io.IOException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

public class Const {
	private static final Logger logger = LoggerFactory.getLogger(Const.class);

	public static String FILE_UPLOAD_PATH;
	public static String FILE_DOWNLOAD_PATH;

	static {
		Resource resource = new ClassPathResource("djweb.properties");

		try {
			Properties properties = PropertiesLoaderUtils.loadProperties(resource);
			String os = System.getProperty("os.name").toLowerCase();
			
			if (os.indexOf("linux") !=-1) {
				FILE_UPLOAD_PATH = properties.getProperty("file.upload.path", " /tmp/");
				FILE_DOWNLOAD_PATH = properties.getProperty("file.upload.path", "/tmp/");
			} else {
				FILE_UPLOAD_PATH = properties.getProperty("file.upload.path", "c:\\");
				FILE_DOWNLOAD_PATH = properties.getProperty("file.upload.path", "c:\\");
			}
			
		} catch (IOException e) {
			logger.error("djweb.properties loading failed. "+e.getMessage());
		}
	}
}

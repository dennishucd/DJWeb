package cn.dennishucd.djweb.api;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.dennishucd.djweb.utils.CodeMsg;
import cn.dennishucd.djweb.utils.Const;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * FileController 
 * 
 * @author dennis
 */

@Controller
@RequestMapping(value="/file")
public class FileController {
	private static final Logger logger = LoggerFactory.getLogger(FileController.class);
	
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public @ResponseBody
	ObjectNode upload(@RequestParam("name") String name,
			@RequestParam("file") MultipartFile file) {
		ObjectNode node = new ObjectMapper().createObjectNode();

		String fileName = Const.FILE_UPLOAD_PATH + name;

		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(new File(fileName)));
				stream.write(bytes);
				stream.close();
			} catch (Exception e) {
				logger.warn("You failed to upload " + name + ", "
						+ e.getMessage());

				node.put(CodeMsg.CODE, CodeMsg.UPLOAD_FAILED_CODE);
				node.put(CodeMsg.MSG, CodeMsg.UPLOAD_FAILED_MSG);

				return node;
			}
		} else {
			node.put(CodeMsg.CODE, CodeMsg.FILE_EMPTY_CODE);
			node.put(CodeMsg.MSG, CodeMsg.FILE_EMPTY_MSG);

			return node;
		}

		node.put(CodeMsg.CODE, CodeMsg.SUCCESS_CODE);
		node.put(CodeMsg.MSG, CodeMsg.SUCCESS_MSG);

		return node;
	}

	//value中使用了SpEL，用来解决path中带有.的时候, .后面的部分被截断的问题
	@RequestMapping(value = "/download/{fileName:.+}", method = RequestMethod.GET)
	public void download(HttpServletResponse response,
			@PathVariable("fileName") String fileName) throws IOException {
		String fullName = Const.FILE_DOWNLOAD_PATH + fileName;

		InputStream is = new FileInputStream(fullName);
		response.setContentType("application/octet-stream");
		response.setHeader("Content-Disposition", "attachment; filename=\""
				+ fileName + "\"");

		OutputStream os = response.getOutputStream();
		byte[] buffer = new byte[1024];
		int len;
		while ((len = is.read(buffer)) != -1) {
			os.write(buffer, 0, len);
		}
		
		os.flush();
		os.close();
		is.close();
	}
}

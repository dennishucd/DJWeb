package cn.dennishucd.djweb.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.TimeUnit;

public class LogInterceptor extends HandlerInterceptorAdapter {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(LogInterceptor.class);

	private Long start = 0L;

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		
		start = System.nanoTime();
		LOGGER.info("start to process {} {} ", request.getMethod(),
				request.getRequestURI());
		
		return true;
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		Long now = System.nanoTime();
		Long cost = now - start;
		LOGGER.info("complete process {} {} cost {}ms", request.getMethod(),
				request.getRequestURI(),
				TimeUnit.NANOSECONDS.toMillis(cost));
	}
}

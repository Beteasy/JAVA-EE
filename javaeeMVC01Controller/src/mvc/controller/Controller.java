package mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 处理请求的接口
 * 控制的核心：处理请求
 * @author fhzheng
 *
 */
public interface Controller {
	String handleRequest(
			HttpServletRequest request, 
			HttpServletResponse response);
}

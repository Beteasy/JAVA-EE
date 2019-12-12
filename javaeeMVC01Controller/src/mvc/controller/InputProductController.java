package mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 对录入进行处理
 * 处理方式：直接转发到录入界面
 * @author fhzheng
 *
 */
public class InputProductController implements Controller {
	@Override
	public String handleRequest(HttpServletRequest request, 
			HttpServletResponse response) {
		return "/WEB-INF/jsp/ProductForm.jsp";
	}
}

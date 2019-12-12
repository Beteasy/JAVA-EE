package mvc.filter;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class CharacterRequest extends HttpServletRequestWrapper {

	private HttpServletRequest request;
	
	public CharacterRequest(HttpServletRequest request) {
		super(request);
		this.request = request;
	}
	
	public String getParameter(String name) {
		String value = super.getParameter(name);
		if (value == null) {
			return null;
		}
		String method = super.getMethod();
		if ("get".equalsIgnoreCase(method)) {
			try {
				value = new String(value.getBytes("iso-8859-1"), "utf-8");
			} catch (UnsupportedEncodingException e) {
				throw new RuntimeException(e);
			}
		}
		//解决乱码后返回结果
		return value;
	}
}

package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 演示要点
 * 1 直接访问，会找不到资源
 * 2 但服务器上，会有响应，可以看到过滤器的生命周期函数运行过程
 * 3 可以从开启服务到关闭服务来观察它的生命周期
 * 
 * 该过滤器只对/MyFilter过滤
 * @author fhzheng
 *
 */

public class MyFilter implements Filter {

	public void destroy() {
		System.out.println("MyFilter destroy()...");
	}

	public void doFilter(
			ServletRequest arg0, 
			ServletResponse arg1,
			FilterChain arg2) 
					throws IOException, ServletException {
		System.out.println("MyFilter过滤器工作...Start doFilter()...");
		System.out.println("MyFilter过滤器工作...doFilter()...");
		arg2.doFilter(arg0, arg1);
		System.out.println("MyFilter过滤器工作...End doFilter()...");

	}

	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("MyFilter init()...");
	}

}

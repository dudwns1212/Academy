package myjsp;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

/**
 * Servlet Filter implementation class MyFilter
 */
@WebFilter("/*")
public class MyFilter extends HttpFilter implements Filter {
        
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("MyFilter.doFilter() start");
		chain.doFilter(request, response);
		System.out.println("MyFilter.doFilter() end");
	}
}

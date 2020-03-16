package cn.zsyy.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import cn.zsyy.uit.JDB;

/**
 * Servlet Filter implementation class AdminFilter
 */
@WebFilter("/admin/*")
public class AdminFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public AdminFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		// chain.doFilter(request, response);
		System.out.println("-----------过滤器----------");

		// 转换成httpservlet
		HttpServletRequest req = (HttpServletRequest) request;
		// 获取路径
		String servletPath = req.getServletPath();
		System.out.println("获取到登录界面路径"+servletPath);
		// 通过路径匹配放行，注册登录其他的都需要判断登录
		if (servletPath.equals("/admin/register") || servletPath.equals("/admin/login")) {
			chain.doFilter(request, response);
			
		} else {
			// 获取存在session中的数据
			HttpSession session = req.getSession();
			// 判断sessio中是否存有数据，并且不能为空
			if (session.getAttribute("username") != null) {
				// 以登录放行
				// chain.doFilter(request, response);
				String username = (String) session.getAttribute("username");
				// 查找此用户的用户类型
				String sqlStr = "select * from user where username=?";
				// 存入集合中
				String[] params = { username };
				ArrayList<HashMap<String, Object>> query = JDB.query(sqlStr, params);
				HashMap<String, Object> user = query.get(0);
				
				
				// 判断权限账号是否有管理员账号，如没有请注册
				if (user.get("userType").equals("admin")) {
					// admin管理人权限放行
					chain.doFilter(request, response);
				} else {
					req.setAttribute("httpUrl", "/admin/login");
					req.setAttribute("infojsp", "您没有权限请联系管理,即将调转登录界面");
					req.setAttribute("title", "访问失败");
					req.getRequestDispatcher("/admin/infojsp.jsp").forward(req, response);
				}

				
			} else {
				// 如果没有登录就跳转登录界面
				req.setAttribute("httpUrl", "/admin/login");
				req.setAttribute("infojsp", "您未登录！即将跳转至登录界面");
				req.setAttribute("title", "未登录");
				req.getRequestDispatcher("/admin/infojsp.jsp").forward(req, response);
			}

		}

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}

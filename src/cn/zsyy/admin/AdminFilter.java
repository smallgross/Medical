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
		System.out.println("-----------������----------");

		// ת����httpservlet
		HttpServletRequest req = (HttpServletRequest) request;
		// ��ȡ·��
		String servletPath = req.getServletPath();
		System.out.println("��ȡ����¼����·��"+servletPath);
		// ͨ��·��ƥ����У�ע���¼�����Ķ���Ҫ�жϵ�¼
		if (servletPath.equals("/admin/register") || servletPath.equals("/admin/login")) {
			chain.doFilter(request, response);
			
		} else {
			// ��ȡ����session�е�����
			HttpSession session = req.getSession();
			// �ж�sessio���Ƿ�������ݣ����Ҳ���Ϊ��
			if (session.getAttribute("username") != null) {
				// �Ե�¼����
				// chain.doFilter(request, response);
				String username = (String) session.getAttribute("username");
				// ���Ҵ��û����û�����
				String sqlStr = "select * from user where username=?";
				// ���뼯����
				String[] params = { username };
				ArrayList<HashMap<String, Object>> query = JDB.query(sqlStr, params);
				HashMap<String, Object> user = query.get(0);
				
				
				// �ж�Ȩ���˺��Ƿ��й���Ա�˺ţ���û����ע��
				if (user.get("userType").equals("admin")) {
					// admin������Ȩ�޷���
					chain.doFilter(request, response);
				} else {
					req.setAttribute("httpUrl", "/admin/login");
					req.setAttribute("infojsp", "��û��Ȩ������ϵ����,������ת��¼����");
					req.setAttribute("title", "����ʧ��");
					req.getRequestDispatcher("/admin/infojsp.jsp").forward(req, response);
				}

				
			} else {
				// ���û�е�¼����ת��¼����
				req.setAttribute("httpUrl", "/admin/login");
				req.setAttribute("infojsp", "��δ��¼��������ת����¼����");
				req.setAttribute("title", "δ��¼");
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

package cn.zsyy.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.zsyy.uit.JDB;

/**
 * Servlet implementation class login
 */
@WebServlet("/admin/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//response请求响应到界面上
		
		request.getRequestDispatcher("/admin/login.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		//请求获得表单上的账号
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		//查询数据库是不是有相同的数据
		String sqlStr="select*from user where username=?and password=?";
		String []params= {username,password};
		ArrayList<HashMap<String, Object>> query = JDB.query(sqlStr,params);
		if (query.size()>0) {
			System.out.println("成功登录");
			//设置登录状态
			HttpSession session = request.getSession();
			session.setAttribute("isLogin", true);
			session.setAttribute("username", username);
			//显示成功信息
			//显示登录成功信息
			request.setAttribute("httpUrl", "/admin/index");
			request.setAttribute("infojsp", "登录成功！即将调转至后台");
			request.setAttribute("title", "登录成功");
			request.getRequestDispatcher("/admin/infojsp.jsp").forward(request, response);
		}else {
			System.out.println("登录失败重新登录");
			
			//显示登录成功信息
			request.setAttribute("httpUrl", "/admin/login");
			request.setAttribute("infojsp", "登录失败即将返回");
			request.setAttribute("title", "登录失败");
			request.getRequestDispatcher("/admin/infojsp.jsp").forward(request, response);
		}
						
	}

}

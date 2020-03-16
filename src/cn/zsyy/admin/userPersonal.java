package cn.zsyy.admin;

import java.io.IOException;
import java.net.URLDecoder;
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
 * Servlet implementation class userPersonal
 */
@WebServlet("/admin/userPersonal")
public class userPersonal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public userPersonal() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//获取用户名
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		String strSql="select*from user where username=?";
		String []parms= {username};
		ArrayList<HashMap<String, Object>> query = JDB.query(strSql, parms);
		//返回数组的第一个内容即是用户的map对象
		HashMap<String, Object> user = query.get(0);
		//将username放置到request
		request.setAttribute("user", user);
		request.getRequestDispatcher("/admin/userPersonal.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		//设置utf-8
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		//获取表单信息
		//获取表单数据信息
				String username = request.getParameter("username");
				String name = request.getParameter("name");
				String password = request.getParameter("password");
				String sex = request.getParameter("sex");
				String age = request.getParameter("age");
				String brief = request.getParameter("brief");
				String mail = request.getParameter("mail");
				String mobile = request.getParameter("mobile");
				String userType = request.getParameter("userType");
				
				//对提交表单的中文进行解码
				//URLencoder编码将中文的字符串变成url地质队中文编码
				//urlDecoder解码将url地址的中文编码。解码成字符串
				name = URLDecoder.decode(name);
				System.out.println(name);
				
				//将表单信息更新到数据库
				String sqlStr = "update user set username=?,name=?,password=?,sex=?,age=?,brief=?,mail=?,mobile=?,userType=? where username=?";
				String[] params = {username,name,password,sex,age,brief,mail,mobile,userType,username};
				int execute = JDB.execute(sqlStr,params);
				System.out.println(execute);
				System.out.println(name);
				//用户修改完成
				//用户修改完成
				request.setAttribute("httpUrl", "/admin/edituser?username="+username);
				request.setAttribute("infojsp", "用户信息修改成功，返回至修改页面！");
				request.setAttribute("title", "修改成功");
				request.getRequestDispatcher("/admin/index.jsp").forward(request, response);
	}

}

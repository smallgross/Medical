package cn.zsyy.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.zsyy.uit.JDB;

/**
 * Servlet implementation class Register
 */
@WebServlet("/admin/register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//使用转发的方法转发到register
		//为什么要用doget转发呢？因为doget只有一个流每一个都有限制
			request.getRequestDispatcher("/admin/register.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	//doPost通过其他流的传递参数可以传输二进制数据
	//post比get安全GET 调用会把传递给Servlet的参数在 URL 里显示出来
	//请求则通过其他流传递参数，不会在 URL 中显示，更安全
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		//请求数据发到服务器中request：请求，在浏览器输入地址,回车,就是一个请求。
		//getParameter接收数据
	String username = request.getParameter("username");
	String password = request.getParameter("password");
	System.out.println(username);
	System.out.println(password);
	String strSQL="select username from user where username=?";
	String []str= {username};
	ArrayList<HashMap<String, Object>> query = JDB.query(strSQL,str);
	if (query.size()>0) {
	System.out.println("已经被注册过了");	
	//使用setAttribute保存数据
		request.setAttribute("title", "注册失败");
		request.setAttribute("infojsp", "注册失败，该用户名已存在，调回注册页面");
		//转发进入的页面就可以获取到你的值
		request.setAttribute("httpUrl", "/admin/register");
	}else {
		System.out.println("注册成功");
		//插入用户信息表单中
		HashMap<String , Object> user = new HashMap<>();
		user.put("username", username);
		user.put("password", password);
		user.put("userType", "admin");
		JDB.insertObj("user", user);
		
		request.setAttribute("title", "注册成功");
		request.setAttribute("infojsp", "注册成功，该用户名已存在即将调转");
		request.setAttribute("httpUrl", "/admin/login");
	}
	
	request.getRequestDispatcher("/admin/infojsp.jsp").forward(request, response);
	}

}

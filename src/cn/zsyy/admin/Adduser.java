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
 * Servlet implementation class Adduser
 */
@WebServlet("/admin/adduser")
public class Adduser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Adduser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/admin/adduser.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
				//判断用户名是否存在
				String sqlStr ="select*from user where username=?";
				String []parms= {};
				ArrayList<HashMap<String, Object>> result = JDB.query(sqlStr, parms);
				if (result.size()==0) {
					HashMap<String, Object> user = new HashMap<>();
					user.put("username", username);
					user.put("name", name);
					user.put("password", password);
					user.put("sex", sex);
					user.put("age", age);
					user.put("brief", brief);
					user.put("mail", mail);
					user.put("mobile", mobile);
					user.put("userType", userType);
				
					
					JDB.insertObj("user",user);
					//添加用户添加成功
					request.setAttribute("httpUrl", "/admin/userlist");
					request.setAttribute("infojsp", "用户信息添加成功，返回至修改页面！");
					request.setAttribute("title", "添加成功");
					request.getRequestDispatcher("/admin/infojsp.jsp").forward(request, response);	
				}else if(result.get(0).get("isDelete")!=null&&result.get(0).get("isDelete").equals("true")){
					//将表单信息更新到数据库
					sqlStr = "update user set username=?,name=?,password=?,sex=?,age=?,brief=?,mail=?,mobile=?,userType=? where username=?";
					String[] params1 = {username,name,password,sex,age,brief,mail,mobile,userType,username};
					int execute = JDB.execute(sqlStr,params1);
				}else {
					
					//添加用户失败
					request.setAttribute("httpUrl", "/admin/userlist");
					request.setAttribute("infojsp", "此用户已使用，用户信息添加失败，返回至修改页面！");
					request.setAttribute("title", "添加失败");
					request.getRequestDispatcher("/admin/infojsp.jsp").forward(request, response);	
				}
				
				
				
				
	}

}

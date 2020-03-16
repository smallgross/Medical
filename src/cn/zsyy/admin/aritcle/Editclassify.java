package cn.zsyy.admin.aritcle;

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
 * Servlet implementation class Editclassify
 */
@WebServlet("/admin/artice/editclassify")
public class Editclassify extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Editclassify() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	request.getRequestDispatcher("/admin/artice/editclassify.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置utf-8
				request.setCharacterEncoding("UTF-8");
				response.setCharacterEncoding("UTF-8");
				//获取表单信息
				//获取表单数据信息
						String classify = request.getParameter("classify");
						String brief = request.getParameter("brief");
						String parentid = request.getParameter("parentid");
						
						
						//对提交表单的中文进行解码
						//URLencoder编码将中文的字符串变成url地质队中文编码
						//urlDecoder解码将url地址的中文编码。解码成字符串
						classify = URLDecoder.decode(classify);
						System.out.println(classify);
						
						//将表单信息更新到数据库
						String sqlStr = "update user set classify=?,classify=?,brief=?,parentid=?where classify=?";
						String[] params = {classify,brief,parentid};
						int execute = JDB.execute(sqlStr,params);
						System.out.println(execute);
						System.out.println(classify);
						//用户修改完成
						//用户修改完成
						request.setAttribute("httpUrl", "/admin/artice/editclassify?classify="+classify);
						request.setAttribute("infojsp", "用户信息修改成功，返回至修改页面！");
						request.setAttribute("title", "修改成功");
						request.getRequestDispatcher("/admin/index.jsp").forward(request, response);
	}

}

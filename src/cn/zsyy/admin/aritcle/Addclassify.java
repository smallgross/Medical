package cn.zsyy.admin.aritcle;

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
@WebServlet("/admin/artice/addclassify")
public class Addclassify extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Addclassify() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取所有分类信息
		String sqlStr="select *from classify";
		ArrayList<HashMap<String, Object>> clist = JDB.query(sqlStr);
		request.setAttribute("clist", clist);
		request.getRequestDispatcher("/admin/artice/addclassify.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		//获取表单信息
		//获取表单数据信息
				String classify = request.getParameter("classify");
				
				String brief = request.getParameter("brief");
				String parentid = request.getParameter("parentid").equals("")? "0":request.getParameter("parentid");
			
				//判断分类是否存在
				String sqlStr ="select*from classify where classify=?";
				String []parms= {classify};
				ArrayList<HashMap<String, Object>> result = JDB.query(sqlStr, parms);
				if (result.size()==0) {
					HashMap<String, Object> catagory = new HashMap<>();
					catagory.put("classify",classify);
					
					catagory.put("brief", brief);
					catagory.put("parentid", parentid);
					JDB.insertObj("classify",catagory);
					//添加分类添加成功
					request.setAttribute("httpUrl", "/admin/artice/classify");
					request.setAttribute("infojsp", "添加成功，返回至分类列表页！");
					request.setAttribute("title", "添加成功");
					request.getRequestDispatcher("/admin/infojsp.jsp").forward(request, response);	
				}else if(result.get(0).get("isDelete")!=null&&result.get(0).get("isDelete").equals("true")){
					//将表单信息更新到数据库
					sqlStr = "update user set classify=?,brief=?,parentid=?,isdelete='false' where classify=?";
					String[] params1 = {classify,brief,parentid};
					int execute = JDB.execute(sqlStr,params1);
					
					//添加分类添加成功
					request.setAttribute("httpUrl", "/admin/artice/classify");
					request.setAttribute("infojsp", "添加成功，返回至分类列表页！");
					request.setAttribute("title", "添加成功");
					request.getRequestDispatcher("/admin/infojsp.jsp").forward(request, response);	
				}else {
					
					//添加用户失败
					request.setAttribute("httpUrl", "/admin/artice/classify");
					request.setAttribute("infojsp", "此已使用，信息添加失败，返回至分类列表页！");
					request.setAttribute("title", "添加失败");
					request.getRequestDispatcher("/admin/infojsp.jsp").forward(request, response);	
				}
				
				
				
				
	}

}

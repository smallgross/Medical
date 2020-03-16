package cn.zsyy.admin.aritcle;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.zsyy.uit.JDB;

/**
 * Servlet implementation class Deleteclassify
 */
@WebServlet("/admin/artice/deleteclassify")
public class Deleteclassify extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Deleteclassify() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//物理删除物理删除则是把数据从介质上彻底删除掉。
		String id = request.getParameter("id");
		String sqlStr="delete from classify where id=?";
		String []parans= {id};
		int execute = JDB.execute(sqlStr, parans);
		//删除成功返回分类
		//添加用户添加成功
		request.setAttribute("httpUrl", "/admin/artice/classify");
		request.setAttribute("infojsp", "删除成功，返回至文章分类页面！");
		request.setAttribute("title", "删除成功");
		request.getRequestDispatcher("/admin/infojsp.jsp").forward(request, response);	
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] ids = request.getParameterValues("ids[]");
		String sqlStr="delete from classify where id in(";
		for (int i = 0; i < ids.length; i++) {
			
			if (i==(ids.length-1)) {
				sqlStr=sqlStr+ids[i]+")";
			}else {
				sqlStr=sqlStr+ids[i]+",";
			}
		}
	int execute = JDB.execute(sqlStr);
	System.out.println(execute);
		response.getWriter().println("ping liang shanchu");
	}

	}



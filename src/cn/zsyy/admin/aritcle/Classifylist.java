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
 * Servlet implementation class Classify
 */
@WebServlet("/admin/artice/classify")
public class Classifylist extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Classifylist() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取所有用户的数据最新建立的10条用户
		String page = request.getParameter("page");
		// 如果默认获取不到第几页的参数，那么就重第一页开始
		if (page == null) {
			page = "1";

		}
		String strSql = null;
		String steSql1 = null;
		int num = (Integer.parseInt(page) - 1) * 5;
	
		// 文章获取模糊查询的所有分类
		String likeclassify = request.getParameter("likeclassify");
		System.out.println(likeclassify);
		
		if(likeclassify!=null) {
			//模糊查询分类
			strSql = "select * from classify where  classify like '%"+likeclassify +"%' order by id asc limit "+num+",5";
			steSql1 = "select * from classify where  classify like '%"+likeclassify +"%'";
		}else {
			strSql = "SELECT c1.id,c1.classify,c1.brief,c1.parentid,c2.classify as parentname  from classify as c1  LEFT JOIN classify as c2 on c1.parentid = c2.id order by c1.id asc LIMIT "+num+",5";
			steSql1 = "select * from classify ";
			
		}

		
		
		// 分类列表获取
		// strSql = "select*from user where isdelete is NULL order by id limit " + num +
		// ",5";
		System.out.println(strSql);
		ArrayList<HashMap<String, Object>> classifylist = JDB.query(strSql);
		request.setAttribute("classifylist", classifylist );
		request.setAttribute("page", page);

		// 获取总页数
		// String steSql1 = "select*from user where isdelete is NULL";
		ArrayList<HashMap<String, Object>> allList = JDB.query(steSql1);
		int size = allList.size();
		int allpage = (int) Math.ceil((double) size / 5);
		request.setAttribute("size", size);
		request.setAttribute("allpage", allpage);
		request.getRequestDispatcher("/admin/artice/classifylist.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

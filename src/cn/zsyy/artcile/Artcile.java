package cn.zsyy.artcile;

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
 * Servlet implementation class Artcile
 */
@WebServlet("/artcile/*")
public class Artcile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Artcile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				//通过pathinfo字符串截取获取相对应的文章id
				String pathInfo = request.getPathInfo();
				
				String id = pathInfo.substring(3, pathInfo.length()-5);
				//通过id从数据中取文章内容
				String strSql="select*from artile where id=?";
				String []params= {id};
				ArrayList<HashMap<String, Object>> result = JDB.query(strSql, params);
				HashMap<String, Object> artile = result.get(0);
				request.setAttribute("artile",artile);
//				String id = pathInfo.substring(3, pathInfo.length()-5);
//				//通过id从数据获取文章内容
//				String strSql = "select * from artile where id=?";
//				String[] params = {id};
//				System.out.println(id);
//				ArrayList<HashMap<String, Object>> result = JDB.query(strSql, params);
//				HashMap<String, Object> artile = result.get(0);
//				request.setAttribute("artile", artile);
				request.getRequestDispatcher("/articleList/article.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

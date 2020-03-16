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
 * Servlet implementation class Articlelist
 */
@WebServlet("/admin/artice/articlelist")
public class Articlelist extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Articlelist() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ��ȡ�����û����������½�����10���û�
		String page = request.getParameter("page");
		// ���Ĭ�ϻ�ȡ�����ڼ�ҳ�Ĳ�������ô���ص�һҳ��ʼ
		if (page == null) {
			page = "1";

		}
		String strSql = null;
		String steSql1 = null;
		int num = (Integer.parseInt(page) - 1) * 5;
	
		// ���»�ȡģ����ѯ�����з���
		String likeArticle = request.getParameter("likeArticle");
		System.out.println(likeArticle);
		
		if(likeArticle!=null) {
			strSql = "select * from artile where  title like '%"+likeArticle +"%' order by id asc limit "+num+",5";
			steSql1 = "select * from artile where  title like '%"+likeArticle +"%'";
		}else {
			strSql = "select * from artile order by id asc LIMIT "+num+",5";
			steSql1 = "select * from artile";
			
		}
		// �����б��ȡ
				// strSql = "select*from user where isdelete is NULL order by id limit " + num +
				// ",5";
				System.out.println(strSql);
				ArrayList<HashMap<String, Object>>articlelist = JDB.query(strSql);
				request.setAttribute("articlelist",articlelist);
				request.setAttribute("page", page);

				// ��ȡ��ҳ��
				// String steSql1 = "select*from user where isdelete is NULL";
				ArrayList<HashMap<String, Object>> allList = JDB.query(steSql1);
				int size = allList.size();
				int allpage = (int) Math.ceil((double) size / 5);
				request.setAttribute("size", size);
				request.setAttribute("allpage", allpage);
		request.getRequestDispatcher("/admin/artice/articlelist.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

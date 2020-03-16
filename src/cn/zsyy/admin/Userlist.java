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
 * Servlet implementation class Userlist
 */
@WebServlet("/admin/userlist")
public class Userlist extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Userlist() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// ��ȡ�����û����������½�����10���û�
		String page = request.getParameter("page");
		// ���Ĭ�ϻ�ȡ�����ڼ�ҳ�Ĳ�������ô���ص�һҳ��ʼ
		if (page == null) {
			page = "1";

		}
		String strSql = null;
		String steSql1 = null;
		int num = (Integer.parseInt(page) - 1) * 5;
		// ��ȡ�鿴�û�����s
		String userType = request.getParameter("userType");
		if (userType == null) {
			userType = "all";
		}
		// ��ȡģ����ѯ�������û������ݲ��ҵĹؼ���
		String likeuser = request.getParameter("likeuser");
		System.out.println(likeuser);
		System.out.println(userType);

		if(likeuser==null&&!userType.equals("all")) {
			//û��ģ�������κ��û�
			strSql = "select * from user where isdelete is NULL and userType='"+userType +"' order by id asc limit "+num+",5";
			steSql1 = "select * from user where isdelete is NULL and userType='"+userType +"'";
		}else if(likeuser!=null&&!userType.equals("all")) {
			strSql = "select * from user where isdelete is NULL and userType='"+userType +"' and username like '%"+likeuser+"%' order by id asc limit "+num+",5";
			steSql1 = "select * from user where isdelete is NULL and userType='"+userType +"' and username like '%"+likeuser+"%'";
		}else if(likeuser!=null&&userType.equals("all")) {
			strSql = "select * from user where isdelete is NULL  and username like '%"+likeuser+"%' order by id asc limit "+num+",5";
			steSql1 = "select * from user where isdelete is NULL and username like '%"+likeuser+"%'";
		}else {
			strSql = "select * from user where isdelete is NULL order by id asc limit "+num+",5";
			steSql1 = "select * from user where isdelete is NULL";
		}

		
		
		// �û��б��ȡ
		// strSql = "select*from user where isdelete is NULL order by id limit " + num +
		// ",5";
		ArrayList<HashMap<String, Object>> userList = JDB.query(strSql);
		request.setAttribute("userlist", userList);
		request.setAttribute("page", page);

		// ��ȡ��ҳ��
		// String steSql1 = "select*from user where isdelete is NULL";
		ArrayList<HashMap<String, Object>> allList = JDB.query(steSql1);
		int size = allList.size();
		int allpage = (int) Math.ceil((double) size / 5);
		request.setAttribute("size", size);
		request.setAttribute("allpage", allpage);

		request.getRequestDispatcher("/admin/userlist.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		/// doGet(request, response);
	}

}

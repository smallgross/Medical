package cn.zsyy.admin;

import java.io.IOException;
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
 * Servlet implementation class login
 */
@WebServlet("/admin/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//response������Ӧ��������
		
		request.getRequestDispatcher("/admin/login.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		//�����ñ��ϵ��˺�
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		//��ѯ���ݿ��ǲ�������ͬ������
		String sqlStr="select*from user where username=?and password=?";
		String []params= {username,password};
		ArrayList<HashMap<String, Object>> query = JDB.query(sqlStr,params);
		if (query.size()>0) {
			System.out.println("�ɹ���¼");
			//���õ�¼״̬
			HttpSession session = request.getSession();
			session.setAttribute("isLogin", true);
			session.setAttribute("username", username);
			//��ʾ�ɹ���Ϣ
			//��ʾ��¼�ɹ���Ϣ
			request.setAttribute("httpUrl", "/admin/index");
			request.setAttribute("infojsp", "��¼�ɹ���������ת����̨");
			request.setAttribute("title", "��¼�ɹ�");
			request.getRequestDispatcher("/admin/infojsp.jsp").forward(request, response);
		}else {
			System.out.println("��¼ʧ�����µ�¼");
			
			//��ʾ��¼�ɹ���Ϣ
			request.setAttribute("httpUrl", "/admin/login");
			request.setAttribute("infojsp", "��¼ʧ�ܼ�������");
			request.setAttribute("title", "��¼ʧ��");
			request.getRequestDispatcher("/admin/infojsp.jsp").forward(request, response);
		}
						
	}

}

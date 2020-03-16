package cn.zsyy.admin;

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
 * Servlet implementation class userPersonal
 */
@WebServlet("/admin/userPersonal")
public class userPersonal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public userPersonal() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//��ȡ�û���
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		String strSql="select*from user where username=?";
		String []parms= {username};
		ArrayList<HashMap<String, Object>> query = JDB.query(strSql, parms);
		//��������ĵ�һ�����ݼ����û���map����
		HashMap<String, Object> user = query.get(0);
		//��username���õ�request
		request.setAttribute("user", user);
		request.getRequestDispatcher("/admin/userPersonal.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		//����utf-8
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		//��ȡ����Ϣ
		//��ȡ��������Ϣ
				String username = request.getParameter("username");
				String name = request.getParameter("name");
				String password = request.getParameter("password");
				String sex = request.getParameter("sex");
				String age = request.getParameter("age");
				String brief = request.getParameter("brief");
				String mail = request.getParameter("mail");
				String mobile = request.getParameter("mobile");
				String userType = request.getParameter("userType");
				
				//���ύ�������Ľ��н���
				//URLencoder���뽫���ĵ��ַ������url���ʶ����ı���
				//urlDecoder���뽫url��ַ�����ı��롣������ַ���
				name = URLDecoder.decode(name);
				System.out.println(name);
				
				//������Ϣ���µ����ݿ�
				String sqlStr = "update user set username=?,name=?,password=?,sex=?,age=?,brief=?,mail=?,mobile=?,userType=? where username=?";
				String[] params = {username,name,password,sex,age,brief,mail,mobile,userType,username};
				int execute = JDB.execute(sqlStr,params);
				System.out.println(execute);
				System.out.println(name);
				//�û��޸����
				//�û��޸����
				request.setAttribute("httpUrl", "/admin/edituser?username="+username);
				request.setAttribute("infojsp", "�û���Ϣ�޸ĳɹ����������޸�ҳ�棡");
				request.setAttribute("title", "�޸ĳɹ�");
				request.getRequestDispatcher("/admin/index.jsp").forward(request, response);
	}

}

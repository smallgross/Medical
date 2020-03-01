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
 * Servlet implementation class Register
 */
@WebServlet("/admin/register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ʹ��ת���ķ���ת����register
		//ΪʲôҪ��dogetת���أ���Ϊdogetֻ��һ����ÿһ����������
			request.getRequestDispatcher("/admin/register.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	//doPostͨ���������Ĵ��ݲ������Դ������������
	//post��get��ȫGET ���û�Ѵ��ݸ�Servlet�Ĳ����� URL ����ʾ����
	//������ͨ�����������ݲ����������� URL ����ʾ������ȫ
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		//�������ݷ�����������request������������������ַ,�س�,����һ������
		//getParameter��������
	String username = request.getParameter("username");
	String password = request.getParameter("password");
	System.out.println(username);
	System.out.println(password);
	String strSQL="select username from user where username=?";
	String []str= {username};
	ArrayList<HashMap<String, Object>> query = JDB.query(strSQL,str);
	if (query.size()>0) {
	System.out.println("�Ѿ���ע�����");	
	//ʹ��setAttribute��������
		request.setAttribute("title", "ע��ʧ��");
		request.setAttribute("infojsp", "ע��ʧ�ܣ����û����Ѵ��ڣ�����ע��ҳ��");
		//ת�������ҳ��Ϳ��Ի�ȡ�����ֵ
		request.setAttribute("httpUrl", "/admin/register");
	}else {
		System.out.println("ע��ɹ�");
		//�����û���Ϣ����
		HashMap<String , Object> user = new HashMap<>();
		user.put("username", username);
		user.put("password", password);
		user.put("userType", "admin");
		JDB.insertObj("user", user);
		
		request.setAttribute("title", "ע��ɹ�");
		request.setAttribute("infojsp", "ע��ɹ������û����Ѵ��ڼ�����ת");
		request.setAttribute("httpUrl", "/admin/login");
	}
	
	request.getRequestDispatcher("/admin/infojsp.jsp").forward(request, response);
	}

}

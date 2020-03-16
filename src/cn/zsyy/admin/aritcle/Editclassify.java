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
		//����utf-8
				request.setCharacterEncoding("UTF-8");
				response.setCharacterEncoding("UTF-8");
				//��ȡ����Ϣ
				//��ȡ��������Ϣ
						String classify = request.getParameter("classify");
						String brief = request.getParameter("brief");
						String parentid = request.getParameter("parentid");
						
						
						//���ύ�������Ľ��н���
						//URLencoder���뽫���ĵ��ַ������url���ʶ����ı���
						//urlDecoder���뽫url��ַ�����ı��롣������ַ���
						classify = URLDecoder.decode(classify);
						System.out.println(classify);
						
						//������Ϣ���µ����ݿ�
						String sqlStr = "update user set classify=?,classify=?,brief=?,parentid=?where classify=?";
						String[] params = {classify,brief,parentid};
						int execute = JDB.execute(sqlStr,params);
						System.out.println(execute);
						System.out.println(classify);
						//�û��޸����
						//�û��޸����
						request.setAttribute("httpUrl", "/admin/artice/editclassify?classify="+classify);
						request.setAttribute("infojsp", "�û���Ϣ�޸ĳɹ����������޸�ҳ�棡");
						request.setAttribute("title", "�޸ĳɹ�");
						request.getRequestDispatcher("/admin/index.jsp").forward(request, response);
	}

}

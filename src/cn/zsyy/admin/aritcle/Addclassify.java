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
		//��ȡ���з�����Ϣ
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
		//��ȡ����Ϣ
		//��ȡ��������Ϣ
				String classify = request.getParameter("classify");
				
				String brief = request.getParameter("brief");
				String parentid = request.getParameter("parentid").equals("")? "0":request.getParameter("parentid");
			
				//�жϷ����Ƿ����
				String sqlStr ="select*from classify where classify=?";
				String []parms= {classify};
				ArrayList<HashMap<String, Object>> result = JDB.query(sqlStr, parms);
				if (result.size()==0) {
					HashMap<String, Object> catagory = new HashMap<>();
					catagory.put("classify",classify);
					
					catagory.put("brief", brief);
					catagory.put("parentid", parentid);
					JDB.insertObj("classify",catagory);
					//��ӷ�����ӳɹ�
					request.setAttribute("httpUrl", "/admin/artice/classify");
					request.setAttribute("infojsp", "��ӳɹ��������������б�ҳ��");
					request.setAttribute("title", "��ӳɹ�");
					request.getRequestDispatcher("/admin/infojsp.jsp").forward(request, response);	
				}else if(result.get(0).get("isDelete")!=null&&result.get(0).get("isDelete").equals("true")){
					//������Ϣ���µ����ݿ�
					sqlStr = "update user set classify=?,brief=?,parentid=?,isdelete='false' where classify=?";
					String[] params1 = {classify,brief,parentid};
					int execute = JDB.execute(sqlStr,params1);
					
					//��ӷ�����ӳɹ�
					request.setAttribute("httpUrl", "/admin/artice/classify");
					request.setAttribute("infojsp", "��ӳɹ��������������б�ҳ��");
					request.setAttribute("title", "��ӳɹ�");
					request.getRequestDispatcher("/admin/infojsp.jsp").forward(request, response);	
				}else {
					
					//����û�ʧ��
					request.setAttribute("httpUrl", "/admin/artice/classify");
					request.setAttribute("infojsp", "����ʹ�ã���Ϣ���ʧ�ܣ������������б�ҳ��");
					request.setAttribute("title", "���ʧ��");
					request.getRequestDispatcher("/admin/infojsp.jsp").forward(request, response);	
				}
				
				
				
				
	}

}

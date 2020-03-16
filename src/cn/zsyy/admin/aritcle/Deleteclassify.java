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
	//����ɾ������ɾ�����ǰ����ݴӽ����ϳ���ɾ������
		String id = request.getParameter("id");
		String sqlStr="delete from classify where id=?";
		String []parans= {id};
		int execute = JDB.execute(sqlStr, parans);
		//ɾ���ɹ����ط���
		//����û���ӳɹ�
		request.setAttribute("httpUrl", "/admin/artice/classify");
		request.setAttribute("infojsp", "ɾ���ɹ������������·���ҳ�棡");
		request.setAttribute("title", "ɾ���ɹ�");
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



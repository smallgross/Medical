package cn.zsyy.admin.aritcle;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class Upload
 */
@WebServlet("/admin/article/upload")
@MultipartConfig
public class Upload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Upload() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//���ñ���
				request.setCharacterEncoding("utf-8");
				response.setCharacterEncoding("utf-8");
				response.setContentType("text/html");
				//��ȡ����,multipart/form-data�Ĳ���������·�������±�׷��@MultipartConfig
				String brief = request.getParameter("brief");
				response.getWriter().println(brief);
				//��ȡ�ļ�
				Part part = request.getPart("headerimg");
				response.getWriter().println(part);
				//��ȡ�ļ�����
				String header = part.getHeader("content-disposition");
				response.getWriter().println(header);
				String filename = getfilename(header);
				response.getWriter().println(filename);
		
				//��ȡuploadĿ¼�����λ��
				String realPath = request.getServletContext().getRealPath("upload");
				response.getWriter().println(realPath);
				long time = new Date().getTime();
				
				//д�뵽����ĳ��λ��part.write(����Ĵ���λ��)
				
				String path=realPath+"/"+time+filename;
				System.out.println(path);
				part.write(path);
				//��������ݿ������·��
				String  httpUrl = request.getContextPath()+"/upload/"+time+filename;
				response.getWriter().println("<img src='"+httpUrl+"'>");
			
		
	}
	//��ͷ���ַ�����ȡ�ļ���
	String getfilename(String header){
		String filename=null;
		String[] splitArr = header.split(";");
		String[] split = splitArr[2].split("=");
		////System.out.println(splitArr[2]);
		filename= split[1].substring(1,split[1].length()-1);
		return filename;
		
	}

}

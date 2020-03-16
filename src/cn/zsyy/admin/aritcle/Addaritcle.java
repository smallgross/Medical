package cn.zsyy.admin.aritcle;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import cn.zsyy.uit.JDB;

/**
 * Servlet implementation class Adduser
 */
@WebServlet("/admin/artice/addarticle")
@MultipartConfig
public class Addaritcle extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Addaritcle() {
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
		//��ȡ���з�����Ϣ
		String sqlStr="select *from classify";
		ArrayList<HashMap<String, Object>> clist = JDB.query(sqlStr);
		request.setAttribute("clist", clist);
		request.getRequestDispatcher("/admin/artice/addarticle.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		// ��ȡ����Ϣ
		// ��ȡ��������Ϣ
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String classifyid = request.getParameter("classifyid");
		String content = request.getParameter("content");
		// �ϴ�����tup
		String titleimgUrl = uploadimg(request, response);
		
		//��ȡ����ʱ���ʱ������ұ��浽���ݿ���
		long time = new Date().getTime();
		
		//��������
		HashMap<String , Object> article = new HashMap<>();
		article.put("title", title);
		article.put("author", author);
		article.put("classifyid", classifyid);
		article.put("content", content);
		article.put("pubtime", time);
		article.put("titleimg", titleimgUrl);
		
		//�����
	 JDB.insertObj("artile", article);
	 request.setAttribute("infojsp", "������ӳɹ�,��ת�������б�");
	 request.setAttribute("page", "�����б�");
	 request.setAttribute("pageUrl", "admin/artice/articlelist");
	 
		request.getRequestDispatcher("/admin/infojsp.jsp").forward(request, response);	
	}

	String  uploadimg(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// ��ȡ����,multipart/form-data�Ĳ���������·�������±�׷��@MultipartConfig
	
		
		// ��ȡ�ļ�
		Part part = request.getPart("titleimg");
		
		// ��ȡ�ļ�����
		String header = part.getHeader("content-disposition");
	
		String filename = getfilename(header);
		

		// ��ȡuploadĿ¼�����λ��
		String realPath = request.getServletContext().getRealPath("upload");
	
		long time = new Date().getTime();

		// д�뵽����ĳ��λ��part.write(����Ĵ���λ��)

		String path = realPath + "/" + time + filename;
	
		part.write(path);
		// ��������ݿ������·��
		String httpUrl = request.getContextPath() + "/upload/" + time + filename;
	return httpUrl;
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

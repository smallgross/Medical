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
		//获取所有分类信息
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
		// 获取表单信息
		// 获取表单数据信息
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String classifyid = request.getParameter("classifyid");
		String content = request.getParameter("content");
		// 上传辩题tup
		String titleimgUrl = uploadimg(request, response);
		
		//获取发布时间的时候戳并且保存到数据库张
		long time = new Date().getTime();
		
		//插入数据
		HashMap<String , Object> article = new HashMap<>();
		article.put("title", title);
		article.put("author", author);
		article.put("classifyid", classifyid);
		article.put("content", content);
		article.put("pubtime", time);
		article.put("titleimg", titleimgUrl);
		
		//插入表
	 JDB.insertObj("artile", article);
	 request.setAttribute("infojsp", "文章添加成功,跳转到文章列表");
	 request.setAttribute("page", "文章列表");
	 request.setAttribute("pageUrl", "admin/artice/articlelist");
	 
		request.getRequestDispatcher("/admin/infojsp.jsp").forward(request, response);	
	}

	String  uploadimg(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// 获取参数,multipart/form-data的参数必须在路径配置下边追加@MultipartConfig
	
		
		// 获取文件
		Part part = request.getPart("titleimg");
		
		// 获取文件名称
		String header = part.getHeader("content-disposition");
	
		String filename = getfilename(header);
		

		// 获取upload目录具体的位置
		String realPath = request.getServletContext().getRealPath("upload");
	
		long time = new Date().getTime();

		// 写入到磁盘某个位置part.write(具体的磁盘位置)

		String path = realPath + "/" + time + filename;
	
		part.write(path);
		// 存放至数据库的网络路径
		String httpUrl = request.getContextPath() + "/upload/" + time + filename;
	return httpUrl;
	}
	//从头部字符串提取文件名
		String getfilename(String header){
			String filename=null;
			String[] splitArr = header.split(";");
			String[] split = splitArr[2].split("=");
			////System.out.println(splitArr[2]);
			filename= split[1].substring(1,split[1].length()-1);
			return filename;
			
		}
}

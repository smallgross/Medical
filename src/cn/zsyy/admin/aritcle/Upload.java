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
		//设置编码
				request.setCharacterEncoding("utf-8");
				response.setCharacterEncoding("utf-8");
				response.setContentType("text/html");
				//获取参数,multipart/form-data的参数必须在路径配置下边追加@MultipartConfig
				String brief = request.getParameter("brief");
				response.getWriter().println(brief);
				//获取文件
				Part part = request.getPart("headerimg");
				response.getWriter().println(part);
				//获取文件名称
				String header = part.getHeader("content-disposition");
				response.getWriter().println(header);
				String filename = getfilename(header);
				response.getWriter().println(filename);
		
				//获取upload目录具体的位置
				String realPath = request.getServletContext().getRealPath("upload");
				response.getWriter().println(realPath);
				long time = new Date().getTime();
				
				//写入到磁盘某个位置part.write(具体的磁盘位置)
				
				String path=realPath+"/"+time+filename;
				System.out.println(path);
				part.write(path);
				//存放至数据库的网络路径
				String  httpUrl = request.getContextPath()+"/upload/"+time+filename;
				response.getWriter().println("<img src='"+httpUrl+"'>");
			
		
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

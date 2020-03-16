package cn.zsyy.uit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCutil {
	static {
		try {
			//将mysql驱动注册到DriverManager中
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
	}
	
	public static Connection con() {
		Connection connection =null;
		String username="root";
		String password="123";
		String database="yyxxlt";
		//注册数据库驱动
		String url="jdbc:mysql://localhost:3306/"+database+
				"?serverTimezone=UTC&useUnicode=true&characterEncoding=utf8&useSSL=false";
		try {
			//获取数据库连接
		 connection = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return connection;
		
	}
	public static void close(Connection conn) {
		if (conn!= null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void main(String[]args) {
		System.out.println("JDBCutil");
	}
}

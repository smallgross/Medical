package cn.zsyy.uit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCutil {
	static {
		try {
			//��mysql����ע�ᵽDriverManager��
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
		//ע�����ݿ�����
		String url="jdbc:mysql://localhost:3306/"+database+
				"?serverTimezone=UTC&useUnicode=true&characterEncoding=utf8&useSSL=false";
		try {
			//��ȡ���ݿ�����
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

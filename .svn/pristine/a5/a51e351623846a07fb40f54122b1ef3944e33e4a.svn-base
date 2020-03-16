package cn.zsyy.uit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class JDB {
	// execute方法之间输入sql语句，直接执行数据库的插入更改和删除
	public static int execute(String sql) {
		Connection conn = null;
		PreparedStatement ps = null;
		int resultSet = 0;

		conn = JDBCutil.con();
		try {
			// 插入数据库
			ps = conn.prepareStatement(sql);
			// toString查询数据返回ps对象的字符串
			System.out.println(ps.toString());
			// 查询数据进行曾删改查
			resultSet = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCutil.close(conn);
		}
		return resultSet;

	}
	
	
	
	/*
	 * 
	 */

	public static int execute(String sql, Object[] params) {

		Connection conn = null;
		PreparedStatement ps = null;
		int resultSet = 0;
		conn = JDBCutil.con();

		try {
			ps = conn.prepareStatement(sql);
			for (int i = 0; i < params.length; i++) {
				Object item = params[i];
				ps.setObject(i + 1, item);

			}
			System.out.println(ps.toString());
			resultSet = ps.executeUpdate();// 是修改表中零行或多行中的一列或多列
			//System.out.println("excute:"+resultSet);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCutil.close(conn);
		}
		return resultSet;

	}

	
	/*
	 * 使用集合插入数组
	 */
	public static int insertObj(String tableName, Map<String,
			Object> dataItem) {
		// 把集合到进去
		String fieldStr = "";
		String valueStr = "";
		// 返回此映射中的键-值映射关系数并且获取map集合中的大小
		Object[] valueObjs = new Object[dataItem.size()];
		int i = 0;
		for (String key : dataItem.keySet()) {
			fieldStr = fieldStr + key + ",";
			valueStr = valueStr + "?" + ",";
			valueObjs[i] = dataItem.get(key);
			i++;

		}
		fieldStr = fieldStr.substring(0, fieldStr.length() - 1);
		valueStr = valueStr.substring(0, valueStr.length() - 1);
		String sqlStr = "insert into " + tableName + " (" + fieldStr + ") values (" + valueStr + ")";

		int exe = execute(sqlStr,valueObjs);

		return exe;

	}

	// query方法，通过输入查询语句自动生成hashmao对象组合的数组
	public static ArrayList<HashMap<String, Object>> query(String sql) {
		ResultSet result = null;
		Connection conn = null;
		PreparedStatement pStatement = null;
		ArrayList<HashMap<String, Object>> temArray = new ArrayList<HashMap<String, Object>>();

		try {
			conn = JDBCutil.con();
			pStatement = conn.prepareStatement(sql);
			System.out.println(pStatement.toString());
			// 执行查询语句，执行后返回代表查询结果的ResultSet对象
			result = pStatement.executeQuery();

			ResultSetMetaData metaData = result.getMetaData();
			int columnCount = metaData.getColumnCount();

			while (result.next()) {
				HashMap<String, Object> hashMap = new HashMap<>();
				for (int i = 1; i <= columnCount; i++) {
					hashMap.put(metaData.getCatalogName(i), result.getObject(i));

				}
				temArray.add(hashMap);

			}

			return temArray;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JDBCutil.close(conn);
		} finally {
			JDBCutil.close(conn);
		}
		return temArray;

	}

	public static ArrayList<HashMap<String, Object>> query(String sql, Object[] params) {
		ResultSet result = null;
		Connection conn = null;
		PreparedStatement pStatement = null;
		ArrayList<HashMap<String, Object>> tempArray = new ArrayList<HashMap<String, Object>>();

		try {
			conn = JDBCutil.con();
			pStatement = conn.prepareStatement(sql);
			for (int i = 0; i < params.length; i++) {
				Object item = params[i];
				pStatement.setObject(i + 1, item);

			}
			System.out.println(pStatement.toString());
			result = pStatement.executeQuery();

			ResultSetMetaData metaData = result.getMetaData();
			int columnCount = metaData.getColumnCount();
			while (result.next()) {
				HashMap<String, Object> hashMap = new HashMap<>();
				for(int i=1;i<=columnCount;i++) {
					hashMap.put(metaData.getColumnName(i), result.getObject(i));
				}
				tempArray.add(hashMap);
				
			}
			return tempArray;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JDBCutil.close(conn);
		}finally {
			JDBCutil.close(conn);
		}
		return tempArray;

	}
	public static void main(String[] args) {
		
		/*String strSql = "insert into user (username,password) values (\"小红\",\"123456789\")";
		int execute = Dao.execute(strSql);*/

		
		/*String strSql = "insert into user (username,password) values (?,?)";
		Object[] arrayList = {"小黑1","789456"};
		int execute = execute(strSql,arrayList);
		System.out.println(execute);*/
//		String strSql = "select * from user where id > ?";
//		Object[] arrayList = {1};
//		ArrayList<HashMap<String, Object>> query = JDB.query(strSql,arrayList);
//		System.out.println(query.size());
//		System.out.println(JSON.toJSONString(query));
		
//		HashMap<String , Object> hashMap = new HashMap<>();
//		hashMap.put("username", "xiaoluo");
//		hashMap.put("password", "admin");
//		hashMap.put("brief", "很帅");
//		insertObj("user", hashMap);
		
	}
}
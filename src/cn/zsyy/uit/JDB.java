package cn.zsyy.uit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class JDB {
	// execute����֮������sql��䣬ֱ��ִ�����ݿ�Ĳ�����ĺ�ɾ��
	public static int execute(String sql) {
		Connection conn = null;
		PreparedStatement ps = null;
		int resultSet = 0;

		conn = JDBCutil.con();
		try {
			// �������ݿ�
			conn.prepareStatement(sql);
			// toString��ѯ���ݷ���ps������ַ���
			System.out.println(ps.toString());
			// ��ѯ���ݽ�����ɾ�Ĳ�
			resultSet = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultSet;

	}

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
			resultSet = ps.executeUpdate();// ���޸ı������л�����е�һ�л����
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCutil.close(conn);
		}
		return resultSet;

	}

	public static int insertObj(String tableName, Map<String, Object> dataItem) {
		// �Ѽ��ϵ���ȥ
		String fieldStr = "";
		String valueStr = "";
		// ���ش�ӳ���еļ�-ֵӳ���ϵ�����һ�ȡmap�����еĴ�С
		Object[] valueObjs = new Object[dataItem.size()];
		int i = 0;
		for (String key : dataItem.keySet()) {
			fieldStr = fieldStr + key + ",";
			valueStr = valueStr + "?" + ",";
			valueObjs[i] = dataItem.get(key);
			i++;

		}
		fieldStr = fieldStr.substring(0, fieldStr.length() - 1);
		fieldStr = valueStr.substring(0, valueStr.length() - 1);
		String sqlStr = "insert into " + tableName + " (" + fieldStr + ") values (" + valueStr + ")";

		int exe = execute(sqlStr, valueObjs);

		return exe;

	}

	// query������ͨ�������ѯ����Զ�����hashmao������ϵ�����
	public static ArrayList<HashMap<String, Object>> query(String sql) {
		ResultSet result = null;
		Connection conn = null;
		PreparedStatement pStatement = null;
		ArrayList<HashMap<String, Object>> temArray = new ArrayList<HashMap<String, Object>>();
		
		try {
			conn = JDBCutil.con();
			pStatement = conn.prepareStatement(sql);
			System.out.println(pStatement.toString());
			//ִ�в�ѯ��䣬ִ�к󷵻ش����ѯ�����ResultSet����
			result = pStatement.executeQuery();
			
			ResultSetMetaData metaData = result.getMetaData();
			int columnCount = metaData.getColumnCount();
			
			
			while (result.next()) {
				HashMap<String , Object> hashMap = new HashMap<>();
				for (int i = 0; i <=columnCount; i++) {
					hashMap.put(metaData.getCatalogName(i),result.getObject(i));
					
					
					
				}
				temArray.add(hashMap);
				
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JDBCutil.close(conn);
		}finally {
			JDBCutil.close(conn);
		}
		return temArray;

	}
	public static ArrayList<HashMap<String , Object>>query(String sql,Object[]params){
		ResultSet resultSet=null;
		Connection conn=null;
		PreparedStatement pStatement=null;
		ArrayList<HashMap<String, Object>> tempArray = new ArrayList<HashMap<String, Object>>();
		
		
		try {
			conn = JDBCutil.con();
			pStatement = conn.prepareStatement(sql);
			for (int i = 0; i < params.length; i++) {
				Object item = params[i];
				pStatement.setObject(i+1, item);
				
			}
			System.out.println(pStatement.toString());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
		
	}
}

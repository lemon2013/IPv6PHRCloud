package cn.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.domain.MyFileExd;
import cn.utils.JDBCUtils;

public class MyFileExdDao {

	private static QueryRunner run=null;
	private static Connection conn=null;
	static{
		run=new QueryRunner();
	}
	//查询所有文件
			public static List<MyFileExd> queryAllFiles(){
				conn=JDBCUtils.getConnection();
				String sql="select u.name owner,f.name,f.id, f.size,f.createdate,f.type from myfile f,user u where f.user_id=u.uid";
				List<MyFileExd> list=null;
				try {
					list=run.query(conn, sql, new BeanListHandler<MyFileExd>(MyFileExd.class));
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
					try {
						conn.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				return list;	
			}
	//根据条件查询
	public static List<MyFileExd> queryFilesByCondition(MyFileExd myfileExd){
		conn=JDBCUtils.getConnection();
		List<String> str=new ArrayList();
		StringBuffer sb=new StringBuffer();
		if(myfileExd.getOwner()!=null&&!"".equals(myfileExd.getOwner().trim())){
			sb.append(" and u.name like ?");
			str.add("%"+myfileExd.getOwner()+"%");
		}
		if(myfileExd.getName()!=null&&!"".equals(myfileExd.getName().trim())){
			sb.append(" and f.name like ?");
			str.add("%"+myfileExd.getName()+"%");
		}
		
		String sql="select u.name owner,f.id, f.name, f.size,f.createdate,f.type from myfile f,user u "
				+ "where f.user_id=u.uid "+sb;
		List<MyFileExd> list=null;
		Object[] params=str.toArray();
		try {
			list=run.query(conn, sql, new BeanListHandler<MyFileExd>(MyFileExd.class),params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;	
	}
}

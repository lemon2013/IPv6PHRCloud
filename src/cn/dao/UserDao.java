package cn.dao;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import cn.domain.User;
import cn.utils.JDBCUtils;



public class UserDao {
	private static QueryRunner run=null;
	private static Connection conn=null;
	static{
		run=new QueryRunner();
		
	
	}
	
	public static User query(User user) throws SQLException{
		conn=JDBCUtils.getConnection();
		String sql = "select * from user where email = ? and password = md5(?)";
		Object param[] = {user.getEmail(),user.getPassword()};
		User u=null;
		u = run.query(conn,sql, new BeanHandler<User>(User.class), param);		
		conn.close();					
		return u;
	}
	public static void save(User user) throws SQLException{
		conn=JDBCUtils.getConnection();
		System.out.println(conn);
		String sql = "insert into user (email,username,password,name,age,joindate,gender,portrait) " +
				"values(?,?,md5(?),?,?,?,?,'portrait')";
		Object param[] = {user.getEmail(),user.getUsername(),user.getPassword(),user.getName(),user.getAge(),
				user.getJoindate(),user.getGender()};				
		run.update(conn,sql, param);
		conn.close();
	}
	
	
}

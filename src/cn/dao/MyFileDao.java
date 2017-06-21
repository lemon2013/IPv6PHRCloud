package cn.dao;

import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.domain.MyFile;
import cn.domain.MyFileExd;
import cn.utils.JDBCUtils;

public class MyFileDao {

	private static QueryRunner run=null;
	private static Connection conn=null;
	static{
		run=new QueryRunner();
	}
	
	public static int save(MyFile myfile){
		conn=JDBCUtils.getConnection();
		String sql = "insert into myfile(user_id,name,path,size,type,createdate) values(?,?,?,?,?,?)";
		Object[] params={myfile.getUser_id(),myfile.getName(),myfile.getPath(),
				myfile.getSize(),myfile.getType(),myfile.getCreateDate()};
		int result=0;
		try {
			result=run.update(conn, sql, params);
		
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
		return result;
	}
	
	//根据文件ID查询
	public static MyFile queryById(int fid){
		conn=JDBCUtils.getConnection();
		String sql="select * from myfile where id=?";
		MyFile myfile=null;
		try {
			myfile=run.query(conn, sql, new BeanHandler<MyFile>(MyFile.class), fid);
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
		return myfile;
	} 	
	//根据文件名查询
	public static List<MyFile> queryAllByFileName(String fileName){
		conn=JDBCUtils.getConnection();
		String sql="select * from myfile where name like ?";
		List<MyFile> list=null;
		try {
			list=run.query(conn, sql, new BeanListHandler<MyFile>(MyFile.class), "%"+fileName+"%");
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
	
	//根据文件名和用户ID查询
	public static List<MyFile> queryByNameAndUserid(String fileName,Integer user_id){
		conn=JDBCUtils.getConnection();
		//String sql="select * from myfile where name like '%"+fileName+"%' and user_id=?";
		String sql="select * from myfile where name like ? and user_id=?";
		Object[] params={"%"+fileName+"%",user_id};
		List<MyFile> list=null;
		try {
			 list=run.query(conn,sql,new BeanListHandler<MyFile>(MyFile.class), params);
			
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
	
	//根据用户名查询
	public static List<MyFile> queryByUserName(String username){
		conn=JDBCUtils.getConnection();
		//String sql="select * from myfile where name like '%"+fileName+"%' and user_id=?";
		String sql="select * from myfile where username=?";
		Object[] params={username};
		List<MyFile> list=null;
		try {
			 list=run.query(conn,sql,new BeanListHandler<MyFile>(MyFile.class), params);
			//list=run.query(conn,sql,new BeanListHandler<MyFile>(MyFile.class), 1);
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
	
	//根据用户ID查询
	public static List<MyFile> queryByUserId(Integer user_id){
		conn=JDBCUtils.getConnection();
		//String sql="select * from myfile where name like '%"+fileName+"%' and user_id=?";
		String sql="select * from myfile where user_id=?";
		Object[] params={user_id};
		List<MyFile> list=null;
		try {
			 list=run.query(conn,sql,new BeanListHandler<MyFile>(MyFile.class), params);
			//list=run.query(conn,sql,new BeanListHandler<MyFile>(MyFile.class), 1);
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
	//根据文件ID删除
	public static int deleteById(Integer id){
		conn=JDBCUtils.getConnection();
		String sql="delete from myfile where id=?";
		int result=0;
		try {
			 result=run.update(conn, sql, id);
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
		return result;
	}
	//更新文件名
	public static int updateFileName(String newFileName,Integer id) throws SQLException{
		conn=JDBCUtils.getConnection();
		String sql="update myfile set name=? where id=?";
		Object[] params={newFileName,id};
		int result=run.update(conn, sql, params);
		conn.close();
		return result;
		
	}
	
}

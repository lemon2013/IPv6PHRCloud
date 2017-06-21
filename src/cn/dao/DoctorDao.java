package cn.dao;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import cn.domain.Doctor;
import cn.domain.User;
import cn.utils.JDBCUtils;

public class DoctorDao {
	private static QueryRunner run=null;
	private static Connection conn=null;
	static{
		run=new QueryRunner();	
	}
	public static int save(Doctor doctor) throws SQLException{
		conn=JDBCUtils.getConnection();
		System.out.println(conn);
		String sql = "insert into doctor (jobid,email,name,username,password,age,gender,department,section,sk)" +
				"values(?,?,?,?,md5(?),?,?,?,?,?)";
		Object param[] = {doctor.getJobid(),doctor.getEmail(),doctor.getName(),doctor.getUsername(),doctor.getPassword(),
				doctor.getAge(),doctor.getGender(),doctor.getDepartment(),doctor.getSection(),doctor.getSk()};				
		int result=run.update(conn,sql, param);
		conn.close();
		return result;
	}
	
	//根据邮箱和密码进行查询
	public static Doctor query(Doctor doctor) throws SQLException{
		conn=JDBCUtils.getConnection();
		String sql = "select * from doctor where email = ? and password = md5(?)";
		Object param[] = {doctor.getEmail(),doctor.getPassword()};
		Doctor d=null;
		d = run.query(conn,sql, new BeanHandler<Doctor>(Doctor.class), param);		
		conn.close();					
		return d;
	}
}

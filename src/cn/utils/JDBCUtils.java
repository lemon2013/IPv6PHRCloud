package cn.utils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;


public class JDBCUtils {
//采用dbcp连接池	
private static BasicDataSource ds;
static{
	ds=new BasicDataSource();
	ds.setDriverClassName("com.mysql.jdbc.Driver");
	ds.setUrl("jdbc:mysql://localhost:3306/test?characterEncoding=UTF-8");
	ds.setUsername("root");
	ds.setPassword("265410");
	ds.setInitialSize(1);
	ds.setMaxActive(3);
	
}
//获取数据库连接池
public static DataSource getDataSource(){
	return ds;
}
//从连接池中获取连接
public static Connection getConnection(){
	Connection conn=null;
	try {
		conn = getDataSource().getConnection();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return conn;
}
}



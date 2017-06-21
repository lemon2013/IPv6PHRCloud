package cn.test;

import java.sql.Connection;

import org.junit.Test;

import cn.utils.JDBCUtils;

public class JdbcTest {

@Test
public void test1(){
	Connection conn=JDBCUtils.getConnection();
	System.out.println(conn);
}
}

package cn.test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.struts2.ServletActionContext;
import org.junit.Test;

import cn.dao.UserDao;
import cn.domain.User;
import cn.encrypt.abe.Cpabe;
import cn.utils.ConstantUtils;

public class UserTest {

	@Test
	public void testSave() throws SQLException{
		User u=new User();
		u.setAge(11);
		u.setEmail("liuxuhui1@126.com");
		u.setGender("男");
		u.setPassword("2222");
		u.setUsername("liuxuhui1");
		u.setName("liuxuhui");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日(E)");	
		u.setJoindate(sdf.format(new Date()));
		UserDao userDao=new UserDao();
		userDao.save(u);
	}
	@Test
	public void testQuery() throws SQLException{
		User u=new User();	
		u.setEmail("liuxuhui@126.com");
		u.setPassword("2222");
		
		UserDao userDao=new UserDao();
		User user=userDao.query(u);
		System.out.println(user);
	}
	@Test
	public void testKeygen() throws Exception{
		Cpabe cpabe=new Cpabe();
		String pubfile=ConstantUtils.PUBFILE;
		String mskfile=ConstantUtils.MSKFILE;
		String attr_str="";
		//String realpath=ServletActionContext.getServletContext().getRealPath("/uploadFiles");
		//System.out.println("realpath:     "+realpath);
		String prvfile="D:/prvfile.txt";
		System.out.println(prvfile);
		cpabe.keygen(pubfile, prvfile, mskfile, "department:surgery age:23");//生成用户私钥文件
	}
}

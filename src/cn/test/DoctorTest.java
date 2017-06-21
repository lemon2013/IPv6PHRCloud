package cn.test;

import java.sql.SQLException;

import org.junit.Test;

import cn.dao.DoctorDao;
import cn.domain.Doctor;

public class DoctorTest {

	@Test
	public void testSave() throws SQLException{
		Doctor d=new Doctor();
		d.setEmail("lili");
		d.setPassword("111");
		d.setAge(12);
		d.setDepartment("surgery");
		d.setGender("男");
		d.setName("liming");
		DoctorDao.save(d);
	}
	
	@Test
	public void testQuery() throws SQLException{
		Doctor d=new Doctor();
		d.setEmail("lili");
		d.setPassword("111");
		Doctor doc=DoctorDao.query(d);
		System.out.println(doc.getDepartment());
	}
}

package cn.test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import cn.dao.MyFileDao;
import cn.dao.MyFileExdDao;
import cn.domain.MyFile;
import cn.domain.MyFileExd;
import cn.encrypt.abe.Cpabe;
import cn.utils.ConstantUtils;

public class MyFileTest {

	@Test
	public void test1(){//测试保存
		MyFile myfile=new MyFile();
		myfile.setUser_id(1);
		myfile.setName("历史书");
		myfile.setSize(100);
		myfile.setType("doc");
		myfile.setCreateDate("2015nian");
		MyFileDao.save(myfile);		
		System.out.println();
	}
	@Test
	public void test2(){//测试删除
		
		System.out.println(MyFileDao.deleteById(3));
		
	}
	@Test
	public void test3(){//测试查询
		List<MyFile> list=MyFileDao.queryAllByFileName("his");
		System.out.println(list.get(0).getName());		
	}
	@Test
	public void test4(){//测试查询
		MyFile myfile=MyFileDao.queryById(4);
		System.out.println(myfile.getName());
	}
	
	@Test
	public void test5(){//测试查询
		int fid=9;
		MyFile myfile=MyFileDao.queryById(fid);
		String path=myfile.getPath();	
		System.out.println(path);
		File file=new File(path);					
		if(file.delete()){
			MyFileDao.deleteById(fid);
		}//删除服务器上的文件
		////删除数据库里的文件信息
	}
	@Test
	public void test6(){//测试查询
		int fid=8;
		
		String path="D:\\java\\eclipse\\workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\PHRCloud\\uploadFiles\\新建 Microsoft Word 文档.docx";		 
		File file=new File(path);	
		
		file.delete();
	}
	@Test
	public void test7() throws IOException{
		File file=new File("D:/hello/liming.txt");
		File dir=new File("D:/hello");
		if(!dir.exists()){
			dir.mkdir();
		}
		String path=file.getPath();
		System.out.println(path);
		FileWriter fw=new FileWriter(file);
		fw.write("hello");
	}
	@Test
	public void test8() throws IOException{
		MyFileExd f=new MyFileExd();
		f.setOwner("liuxuhui");
		f.setName("历史书");
		List<MyFileExd> list=MyFileExdDao.queryFilesByCondition(f);
		for(MyFileExd file:list)
		System.out.println(file.getName()+","+file.getOwner()+","+file.getCreateDate());
	}
	@Test
	public void test9() throws  Exception{
		
		String pubfile=ConstantUtils.PUBFILE;
		String prvfile="D:/java/eclipse/workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/PHRCloud/uploadFiles/prv_key.txt";	
		String encfile="D:/java/eclipse/workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/PHRCloud/uploadFiles/hello.txt";		
		String decfile="d:/decfile.txt";
		Cpabe.dec(pubfile, prvfile, encfile, decfile);
		
		
	}
}




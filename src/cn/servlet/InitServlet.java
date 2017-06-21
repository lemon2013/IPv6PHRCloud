package cn.servlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.struts2.ServletActionContext;

import cn.encrypt.abe.Cpabe;
import cn.utils.ConstantUtils;

public class InitServlet extends HttpServlet{
	 private String pubfile=ConstantUtils.PUBFILE;
	 private String mskfile=ConstantUtils.MSKFILE;
	@Override
	public void init() throws ServletException {	
		Cpabe cpabe = new Cpabe();
		try {
			cpabe.setup(pubfile, mskfile);
		} catch (Exception e) {			
				e.printStackTrace();
					
		} //生成公钥和主密钥，将其保存在uploadFiles文件夹下
		
	}

}

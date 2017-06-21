package cn.action;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.dao.DoctorDao;
import cn.dao.MyFileDao;
import cn.dao.MyFileExdDao;
import cn.domain.Doctor;
import cn.domain.MyFile;
import cn.domain.MyFileExd;
import cn.encrypt.abe.Cpabe;
import cn.utils.ConstantUtils;


public class DoctorAction extends ActionSupport implements  ModelDriven<Doctor>{

	private Doctor doctor=new Doctor();
	private Cpabe cpabe=new Cpabe();
	private DoctorDao doctorDao=new DoctorDao();
	private MyFileExdDao myFileExdDao=new MyFileExdDao();
	//用户注册,生成私钥文件
	public String register() throws Exception{
		
		String pubfile=ConstantUtils.PUBFILE;
		String mskfile=ConstantUtils.MSKFILE;
		
		String attr_str=this.to_attr(doctor);
		System.out.println("attr_str:"+attr_str);
		String realpath=ServletActionContext.getServletContext().getRealPath("/uploadFiles");
		
		String prvfileDir=realpath+"\\"+doctor.getUsername();
		File file=new File(prvfileDir);
		if(!file.exists()){
			file.mkdir();
		}
		String prvfile=prvfileDir+"\\prvfile.txt";
		System.out.println(prvfile);
		cpabe.keygen(pubfile, prvfile, mskfile,attr_str);//生成用户私钥文件	
		doctor.setSk(prvfile);
		doctorDao.save(doctor);
		return "register_success";//
	}
	//登录
	public String login() throws Exception{
		
		Doctor d = doctorDao.query(doctor);
		if(d != null){	
			ActionContext.getContext().getApplication().put("doctor", d);

		return "disk_doctor";//登录成功进入我的网盘
		}
		else{
			addFieldError("error", "邮箱或密码不正确！");
			return "login";//登录失败返回登录页面，并提示失败。
		}
	}
	
	//列出所有文件
	public String listAll(){
		List<MyFileExd> myFileList=myFileExdDao.queryAllFiles();
		ActionContext.getContext().put("myFileList", myFileList);
		ActionContext.getContext().put("size", myFileList.size());
		return "right_doctor";
	}
	
	//转换成字符串形式
	public String to_attr(Doctor doctor) throws Exception{
		String department=doctor.getDepartment();
		String section= doctor.getSection();
		String attr="部门："+department+" 部门："+section;
		System.out.println("attr_str:"+attr);
		
		return attr;
	}
	
	//用户退出
		public String logout(){
			ActionContext.getContext().getApplication().remove("doctor");
			return "logout";
		}
		@Override
		public Doctor getModel() {
			// TODO Auto-generated method stub
			return doctor;
		}
}

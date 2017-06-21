package cn.action;

import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.CompoundRoot;
import com.opensymphony.xwork2.util.ValueStack;

import cn.dao.MyFileDao;
import cn.dao.UserDao;
import cn.domain.MyFile;
import cn.domain.User;
import cn.encrypt.abe.Cpabe;
import cn.utils.ConstantUtils;
public class UserAction extends ActionSupport implements ModelDriven<User>{
	private User user=new User();
	private UserDao userDao=new UserDao();
	private Cpabe cpabe=new Cpabe();
	private MyFileDao myFileDao=new MyFileDao();
	//用户注册
	public String register() throws Exception{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日(E)");
		user.setJoindate(sdf.format(new Date()));	
		userDao.save(user);		
//		String pubfile=ConstantUtils.PUBFILE;
//		String mskfile=ConstantUtils.MSKFILE;
//		String attr_str="department:surgery age:23";//用户属性
//		String realpath=ServletActionContext.getServletContext().getRealPath("/uploadFiles");
//		String prvfileDir=realpath+"\\"+user.getUsername();
//		File file=new File(prvfileDir);
//		if(!file.exists()){
//			file.mkdir();
//		}
//		String prvfile=prvfileDir+"\\prvfile.txt";
//		cpabe.keygen(pubfile, prvfile, mskfile,attr_str);//生成用户私钥文件
		return "register_success";
	}
	
	
	
	//用户登录
	public String login() throws SQLException{
		
		User u = userDao.query(user);
		if(u != null){	
			ActionContext.getContext().getApplication().put("user", u);
			
			List<MyFile> myFileList=myFileDao.queryByUserId(u.getUid());
			ServletActionContext.getRequest().setAttribute("myFileList", myFileList);
			
		return "disk_user";//登录成功进入我的网盘
		}
		else{
			addFieldError("error", "邮箱或密码不正确！");
			return "login";
		}
		
	}



	//查询文件
	public String searchFile(){
		User u=(User) ActionContext.getContext().getApplication().get("user");
		String filename=user.getFilename();
		int user_id=u.getUid();
		List<MyFile> list=myFileDao.queryByNameAndUserid(filename, user_id);
		ServletActionContext.getRequest().setAttribute("myFileList", list);
		ActionContext.getContext().put("size", list.size());
		return "right_user";
	}
	
	public String to_error(){
		
		return "error";
	}
	
	
	//用户退出
	public String logout(){
		ActionContext.getContext().getApplication().remove("user");
		return "logout";
	}

	@Override
	public User getModel() {	
		return user;
	}
	
	
}

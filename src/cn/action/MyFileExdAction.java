package cn.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import cn.dao.MyFileExdDao;
import cn.domain.MyFileExd;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class MyFileExdAction extends ActionSupport implements ModelDriven<MyFileExd>{

	MyFileExd myfileExd=new MyFileExd();
	MyFileExdDao myFileExdDao=new MyFileExdDao();
	@Override
	public MyFileExd getModel() {
		// TODO Auto-generated method stub
		return myfileExd;
	}

	//根据条件查询
	public String search(){
		
		List<MyFileExd> myFileList=myFileExdDao.queryFilesByCondition(myfileExd);
		ServletActionContext.getRequest().setAttribute("myFileList", myFileList);
		ActionContext.getContext().put("size", myFileList.size());
		return "right_doctor";
	}
}

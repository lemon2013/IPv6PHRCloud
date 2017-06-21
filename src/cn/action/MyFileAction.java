package cn.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import cn.dao.MyFileDao;
import cn.domain.Doctor;
import cn.domain.MyFile;
import cn.domain.User;
import cn.encrypt.abe.Cpabe;
import cn.utils.ConstantUtils;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class MyFileAction extends ActionSupport implements ModelDriven<MyFile>{
	private File uploadfile;//所上传的文件的临时文件
	private String uploadfileContentType;//上传文件的类型
	private String uploadfileFileName;//得到上传文件的名称
	private MyFileDao myfileDao=new MyFileDao();
	private Cpabe cpabe=new Cpabe();
	private MyFile myfile=new MyFile();
	public File getUploadfile() {
		return uploadfile;
	}
	public void setUploadfile(File uploadfile) {
		this.uploadfile = uploadfile;
	}
	public String getUploadfileContentType() {
		return uploadfileContentType;
	}
	public void setUploadfileContentType(String uploadfileContentType) {
		this.uploadfileContentType = uploadfileContentType;
	}
	public String getUploadfileFileName() {
		return uploadfileFileName;
	}
	public void setUploadfileFileName(String uploadfileFileName) {
		this.uploadfileFileName = uploadfileFileName;
	}
	
	//文件上传并加密
	public String upload() {
		User user=(User) ActionContext.getContext().getApplication().get("user");		
		String realpath = ServletActionContext.getServletContext().getRealPath("/uploadFiles");
		File dir = new File(realpath);
		
		if(!dir.exists()) 
			dir.mkdirs();		
			File file=new File(dir, uploadfileFileName);									
			String pubfile=ConstantUtils.PUBFILE;
			String policy=ServletActionContext.getRequest().getParameter("accessPolicy");
			System.out.println(policy);
			//String policy=new String(policystr.getBytes(),"utf-8");		
			String inputfile=uploadfile.getAbsolutePath();
			String encfile=file.getAbsolutePath();//加密后文件		
			try{
				cpabe.enc(ConstantUtils.PUBFILE, policy, inputfile, encfile);
				MyFile myfile=new MyFile();
				myfile.setName(uploadfileFileName);
				int index=uploadfileFileName.lastIndexOf(".");
				myfile.setType(uploadfileFileName.substring(index+1));
				float size=(float) (uploadfile.length()/(1024.0));
				myfile.setSize(size);
				myfile.setPath(file.getAbsolutePath());
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日(E)");
				myfile.setCreateDate(sdf.format(new Date()));			
				Integer user_id=user.getUid();
				myfile.setUser_id(user_id);
				myfileDao.save(myfile);//将上传的文件信息保存到数据库中		
			} catch (Exception e) {
				// TODO Auto-generated catch block
				return "encrypterror";
			}finally{
				if(uploadfile!=null)
				uploadfile.delete();
			}
								
		return "listAll";	
		
	} 
	
	
	//转到文件重命名页面
	public String to_rename(){
		String fileId=ServletActionContext.getRequest().getParameter("fileID");	
		MyFile myfile=myfileDao.queryById(Integer.parseInt(fileId));	
		ActionContext.getContext().put("filename", myfile.getName());
		ActionContext.getContext().put("id", myfile.getId());
			return "to_rename";
		}
	
	//文件重命名
		public String rename() throws Exception{
			String newFileName=myfile.getName();
			Integer fileID=myfile.getId();
			
			myfileDao.updateFileName(newFileName, fileID);
			
			return "listAll";
			}
		//列出该患者用户上传的所有文件
		public String listAll(){		
			User u=(User) ActionContext.getContext().getApplication().get("user");			
			List<MyFile> list=myfileDao.queryByUserId(u.getUid());
			ActionContext.getContext().put("myFileList", list);
			ActionContext.getContext().put("size", list.size());
			return "right_user";
		}
		//文件删除
		public String deleteFile(){		
			
			String fileId=ServletActionContext.getRequest().getParameter("fileID");
			
			MyFile myfile=myfileDao.queryById(Integer.parseInt(fileId));
			String path=myfile.getPath();
			
			File file=new File(path);					
			if(file.delete()){//删除服务器上的文件
				
				myfileDao.deleteById(Integer.parseInt(fileId));//删除数据库里的文件信息			
			}
			return "listAll";
		}
	//文件下载并解密
	public String download()  {
		Doctor doctor=(Doctor) ActionContext.getContext().getApplication().get("doctor");
		
		Integer fileID=Integer.parseInt(ServletActionContext.getRequest().getParameter("fileID"));   	
    	MyFile myfile=myfileDao.queryById(fileID);
    	String filename=myfile.getName();
    	String encfile=myfile.getPath();//密文文件    
       String prvfile=doctor.getSk();//私钥文件     
       String decfile=ServletActionContext.getServletContext().
    		   getRealPath("/uploadFiles")+"\\dec_"+filename;
       OutputStream out = null;
       InputStream fis=null; 
       
		try {
			cpabe.dec(ConstantUtils.PUBFILE, prvfile, encfile, decfile);
			fis=new FileInputStream(decfile);
		       HttpServletResponse resp=ServletActionContext.getResponse();
		       resp.setContentType("application/force-download");
		       resp.setHeader("Content-Disposition", "attachment;filename=dec_"+filename);
		       out=resp.getOutputStream();
		       byte[] b=new byte[1024];
		       int len=0;
		      while((len=fis.read(b))!=-1){
		    	  out.write(b, 0, len);
		      }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return "error_decrypt";
		} 
		finally{
			if(out!=null)
				try {
					out.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if(fis!=null)
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
		       
		return null;
		
	}
	
	//打开文件
		public String open() throws IOException{
			
			Integer fileID=Integer.parseInt(ServletActionContext.getRequest().getParameter("fileID"));
			System.out.println("id:"+fileID);
	    	MyFile myfile=myfileDao.queryById(fileID);
	    	String filename=myfile.getName();
	    	
	    	String filePath=myfile.getPath();
	      
	       InputStream fis=new FileInputStream(filePath);
	       HttpServletResponse resp=ServletActionContext.getResponse();
	       resp.setContentType("application/force-download");
	       resp.setHeader("Content-Disposition", "attachment;filename="+filename);
	       OutputStream out=resp.getOutputStream();
	       byte[] b=new byte[1024];
	       int len=0;
	      while((len=fis.read(b))!=-1){
	    	  out.write(b, 0, len);
	      }
	      out.close();
	      fis.close();
			return null;
		}
	@Override
	public MyFile getModel() {
		// TODO Auto-generated method stub
		return myfile;
	}
	
	
}

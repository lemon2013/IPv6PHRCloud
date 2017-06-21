package cn.domain;

public class Doctor {
private int id;
private String jobid;
private String email;
private String username;//昵称，用户名

private String name;//真实姓名
private int age;
private String password;
private String gender;
private String department;
private String section;
private String sk;//私钥文件路径
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getSection() {
	return section;
}
public void setSection(String section) {
	this.section = section;
}
public String getJobid() {
	return jobid;
}
public void setJobid(String jobid) {
	this.jobid = jobid;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public String getDepartment() {
	return department;
}
public void setDepartment(String department) {
	this.department = department;
}
public String getSk() {
	return sk;
}
public void setSk(String sk) {
	this.sk = sk;
}
}

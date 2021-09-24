package model.userTable;

import java.util.Date;

public class UserTableVO {
	private String userid;
	private String name;
	private String passwd;
	private Date date;
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "UserVO [userid=" + userid + ", name=" + name + ", passwd=" + passwd + ", date=" + date + "]";
	}
}

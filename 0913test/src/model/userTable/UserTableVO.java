package model.userTable;

import java.sql.Date;

public class UserTableVO {
	private String userid;
	private String name;
	private String passwd;
	private Date datetime;
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
	public Date getDatetime() {
		return datetime;
	}
	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}
	@Override
	public String toString() {
		return "userTableVO [userid=" + userid + ", name=" + name + ", passwd=" + passwd + ", datetime=" + datetime
				+ "]";
	}
	
	
}

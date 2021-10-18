package model.board;

import java.sql.Date;

public class BoardVO {
	private int bnum;
	private String userID;
	private String title;
	private String content;
	private Date wdate;
	
	public int getBnum() {
		return bnum;
	}
	public void setBnum(int bnum) {
		this.bnum = bnum;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getWdate() {
		return wdate;
	}
	public void setWdate(Date wdate) {
		this.wdate = wdate;
	}
	@Override
	public String toString() {
		return "BoardVO [bnum=" + bnum + ", userID=" + userID + ", title=" + title + ", content=" + content + ", wdate="
				+ wdate + "]";
	}
	
	
	
	
}
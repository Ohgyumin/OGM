package model.msg;

import java.util.ArrayList;

public class MsgSet {
	private MessageTableVO m;
	private ArrayList<ReplyVO> rlist=new ArrayList<ReplyVO>();
	public MessageTableVO getM() {
		return m;
	}
	public void setM(MessageTableVO m) {
		this.m = m;
	}
	public ArrayList<ReplyVO> getRlist() {
		return rlist;
	}
	public void setRlist(ArrayList<ReplyVO> rlist) {
		this.rlist = rlist;
	}
	@Override
	public String toString() {
		return "MsgSet [m=" + m + ", rlist=" + rlist + "]";
	}
}

package model.member;

public class MemberVO {
	int m_num;
	String m_id;
	String m_pw;
	public int getM_num() {
		return m_num;
	}
	public void setM_num(int m_num) {
		this.m_num = m_num;
	}
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	public String getM_pw() {
		return m_pw;
	}
	public void setM_pw(String m_pw) {
		this.m_pw = m_pw;
	}
	@Override
	public String toString() {
		return "MemberVO [m_num=" + m_num + ", m_id=" + m_id + ", m_pw=" + m_pw + "]";
	}

}

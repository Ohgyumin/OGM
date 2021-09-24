package model.msg;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.common.JNDI;

public class MessageTableDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public ArrayList<MsgSet> selectAll(String userid,int cnt) {
		ArrayList<MsgSet> datas = new ArrayList<MsgSet>();
		conn = JNDI.getConnection();
		String sql;
		try {
			if((userid == null) || (userid.equals(""))) { 
				sql="select * from messagetable where rownum<=? order by datetime asc";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, cnt);
			}
			else{
				sql="select * from messagetable where userid=? and rownum<=? order by datetime asc";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1,userid);
				pstmt.setInt(2,cnt);
			}
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MsgSet ms = new MsgSet();
				MessageTableVO m = new MessageTableVO();
				ArrayList<ReplyVO> rlist = new ArrayList<ReplyVO>();
				
				m.setMid(rs.getInt("mid"));
				m.setMsg(rs.getString("msg"));
				m.setFavcount(rs.getInt("favcount"));
				m.setUserid(rs.getString("userid"));
				m.setDatetime(rs.getDate("datetime"));
				
				String rsql="select * from reply where mid=? order by datetime asc";
				pstmt = conn.prepareStatement(rsql);
				pstmt.setInt(1,rs.getInt("mid"));
				ResultSet rrs = pstmt.executeQuery();
				int rcnt=0;
				while(rrs.next()) {
					ReplyVO r = new ReplyVO();
					r.setDate(rrs.getDate("datetime"));
					r.setMid(rrs.getInt("mid"));
					r.setRid(rrs.getInt("rid"));
					r.setRmsg(rrs.getString("rmsg"));
					r.setUserid(rrs.getString("userid"));
					rlist.add(r);
					rcnt++;
				}
				m.setReplycount(rcnt);
				
				ms.setM(m);
				ms.setRlist(rlist);
				datas.add(ms);
				rrs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
		return datas;
	}
	public boolean insert(MessageTableVO vo) {
		conn = JNDI.getConnection();
		String sql="insert into messagetable(mid, userid, msg, datetime) values((select nvl(max(mid),0)+1 from messagetable),?,?,sysdate)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getUserid());
			pstmt.setString(2, vo.getMsg());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return true;
	}
	public boolean delete(MessageTableVO vo) {
		conn = JNDI.getConnection();
		String sql = "delete from messagetable where mid = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getMid());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return true;	
	}
	public void update(MessageTableVO vo) {
		conn = JNDI.getConnection();
		String sql = "update messagetable set favcount=favcount+1 where mid=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getMid());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}

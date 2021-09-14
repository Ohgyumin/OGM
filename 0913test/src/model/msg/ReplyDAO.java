package model.msg;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.common.JNDI;

public class ReplyDAO {
	Connection conn;
	PreparedStatement pstmt;
	public ReplyVO selectOne(ReplyVO vo) {
		conn=JNDI.getConnection();
		pstmt=null;
		ReplyVO data=null;
		System.out.println("1차체크");
		try {
			String sql="select * from reply where rid=?";
			pstmt=conn.prepareStatement(sql);
			System.out.println("sql체크");
			pstmt.setInt(1, vo.getRid());
			System.out.println(vo.getRid());
			ResultSet rs=pstmt.executeQuery();
			System.out.println("rs체크");
			if(rs.next()) {
				data=new ReplyVO();
				System.out.println("체크1");
				data.setDatetime(rs.getDate("datatime"));
				data.setMid(rs.getInt("mid"));
				data.setRid(rs.getInt("rid"));
				data.setRmsg(rs.getString("rmsg"));
				data.setUserid(rs.getString("userid"));
				System.out.println("rs.next체크");
			}
			rs.close();
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return data;
	}
	public boolean insert(ReplyVO vo) {
		conn=JNDI.getConnection();
		String sql="insert into reply(rid,mid,userid,datetime,rmsg) values((select nvl(max(rid),0)+1 from reply),?,?,sysdate,?)";
		try {
			pstmt=conn.prepareStatement(sql);
			System.out.println(vo.getRid());
			pstmt.setInt(1, vo.getMid());
			System.out.println(vo.getMid()+"mid");
			pstmt.setString(2, vo.getUserid());
			System.out.println(vo.getUserid()+"userid");
			pstmt.setString(3, vo.getRmsg());
			System.out.println(vo.getRmsg()+"rmsg");
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}finally {
			try {
				pstmt.close();
				conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return true;
	}
	public boolean delete(ReplyVO vo) {
		conn=JNDI.getConnection();
		String sql="delete from reply where rid=?";
		boolean res=false;
		System.out.println(vo.getRid()+"삭제");
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getRid());
			pstmt.executeUpdate();
			return true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				pstmt.close();
				conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return res;
	}
}


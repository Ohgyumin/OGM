package model.userTable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.common.JNDI;

public class UserTableDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	public boolean insert(UserTableVO vo) {
		conn = JNDI.getConnection();
		String sql = "insert into userTable(userid,name,passwd,datetime) values(?,?,?,sysdate)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getUserid());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getPasswd());
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
	public boolean login(UserTableVO vo) {
		conn = JNDI.getConnection();
		String sql = "select userid, passwd from usertable where userid = ?";
		boolean result = false;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getUserid());
			rs = pstmt.executeQuery();
			rs.next();
			if(rs.getString("passwd").equals(vo.getPasswd()))
				result=true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
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
		return result;
	}
	public ArrayList<UserTableVO> selectAll() {
		ArrayList<UserTableVO> datas = new ArrayList<UserTableVO>();
		conn = JNDI.getConnection();
		String sql = "select * from usertable where rownum<=5 order by datetime desc";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				UserTableVO data=new UserTableVO();
				data.setDate(rs.getDate("datetime"));
				data.setName(rs.getString("name"));
				data.setPasswd(rs.getString("passwd"));
				data.setUserid(rs.getString("userid"));
				datas.add(data);
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
}

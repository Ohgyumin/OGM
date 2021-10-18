package model.client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.common.JNDI;

public class ClientDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	String login="select * from client where userID=? and userPW=?"; //로그인
	String c_insert="insert into client values (?,?,?)"; // 회원가입

	boolean flag=false;

	public ClientVO login(ClientVO vo) {  // 로그인
		conn=JNDI.connect();

		ClientVO data = null;

		try {
			pstmt=conn.prepareStatement(login);
			pstmt.setString(1, vo.getUserID());
			pstmt.setString(2, vo.getUserPW());
			rs=pstmt.executeQuery();
			if (rs.next()) { // 일치하는 회원 ID,PW가 있다면 ... 
				data = new ClientVO();
				data.setUserID(rs.getString("userID"));
				data.setUserPW(rs.getString("userPW"));
				data.setName(rs.getString("name"));
			} // 이 정보를 받아와서 return 해주면 회원정보 수정을 할때 편리
			// return flag를 하면 ID값만 받아오니까 .. .
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JNDI.disconnect(pstmt, conn);
		}
		return data;

	}

	public boolean insert(ClientVO vo) { // 회원가입
		conn=JNDI.connect();

		try {
			pstmt =conn.prepareStatement(c_insert);
			pstmt.setString(1, vo.getUserID());
			pstmt.setString(2, vo.getUserPW());
			pstmt.setString(3, vo.getName());
			pstmt.executeUpdate();

			flag=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JNDI.disconnect(pstmt, conn);
		}

		return flag;

	}

}

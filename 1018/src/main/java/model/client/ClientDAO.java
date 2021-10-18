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

	String login="select * from client where userID=? and userPW=?"; //�α���
	String c_insert="insert into client values (?,?,?)"; // ȸ������

	boolean flag=false;

	public ClientVO login(ClientVO vo) {  // �α���
		conn=JNDI.connect();

		ClientVO data = null;

		try {
			pstmt=conn.prepareStatement(login);
			pstmt.setString(1, vo.getUserID());
			pstmt.setString(2, vo.getUserPW());
			rs=pstmt.executeQuery();
			if (rs.next()) { // ��ġ�ϴ� ȸ�� ID,PW�� �ִٸ� ... 
				data = new ClientVO();
				data.setUserID(rs.getString("userID"));
				data.setUserPW(rs.getString("userPW"));
				data.setName(rs.getString("name"));
			} // �� ������ �޾ƿͼ� return ���ָ� ȸ������ ������ �Ҷ� ��
			// return flag�� �ϸ� ID���� �޾ƿ��ϱ� .. .
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JNDI.disconnect(pstmt, conn);
		}
		return data;

	}

	public boolean insert(ClientVO vo) { // ȸ������
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

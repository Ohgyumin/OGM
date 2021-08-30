package model.message;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.common.JDBC;

public class MessageDAO {
	
	public ArrayList<MessageVO> getDBList(){ // �� ���==ArrayList�� ����
		Connection conn=JDBC.connect(); // JDBC�� connect�ҷ���
		ArrayList<MessageVO> datas=new ArrayList(); // ��� ����Ʈ ����
		PreparedStatement pstmt=null;
		try {
			String sql="select * from message order by mnum desc"; // ������������ ����sql��
			pstmt=conn.prepareStatement(sql);
			ResultSet rs=pstmt.executeQuery(); // ResultSet ����
			while(rs.next()) { // ������ �ҷ�����
				MessageVO vo=new MessageVO();
				vo.setContent(rs.getString("content"));
				vo.setMnum(rs.getInt("mnum"));
				vo.setTitle(rs.getString("title"));
				vo.setWdate(rs.getDate("wdate"));
				vo.setWriter(rs.getString("writer"));
				datas.add(vo); // ArrayList�� �߰�
			}
			rs.close();
		}catch(Exception e){
			System.out.println("getDBList()���� ���");
			e.printStackTrace();
		}finally {
			JDBC.disconnect(pstmt, conn);
		}
		return datas;
	}
	
	public MessageVO getDBData(MessageVO vo) {
		Connection conn=JDBC.connect();
		MessageVO data=null; // �޾ƿ� data�� ����
		PreparedStatement pstmt=null;
		try {
			String sql="select * from message where mnum=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getMnum()); // mnum�� message�� ����
			ResultSet rs=pstmt.executeQuery(); // ResultSet ����
			while(rs.next()) { // ������ �ҷ�����
				data.setContent(rs.getString("content"));
				data.setMnum(rs.getInt("mnum"));
				data.setTitle(rs.getString("title"));
				data.setWdate(rs.getDate("wdate"));
				data.setWriter(rs.getString("writer"));
			}
			rs.close();
		}catch(Exception e){
			System.out.println("getDBData()���� ���");
			e.printStackTrace();
		}finally {
			JDBC.disconnect(pstmt, conn);
		}
		return data;
	}
	
	public void insertDB() {
		
	}
	
	public void deleteDB() {
		
	}
	public boolean updateDB(MessageVO vo) { // ���� ����,Ÿ�� ����� ���� �ٲ���ϱ⶧���� ���ڷ� VO�� ����
		Connection conn=JDBC.connect();
		boolean res=false;
		PreparedStatement pstmt=null;
		try {
			String sql="update message set writer=?, title=?, content=?, wdate=sysdate where=mnum=?"; // sysdate==���糯¥ ��������
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, vo.getWriter());
			pstmt.setString(2, vo.getTitle());
			pstmt.setString(3, vo.getContent());
			pstmt.setDate(4, vo.getWdate());
			pstmt.setInt(5, vo.getMnum());
			pstmt.executeUpdate();
			res=true; // ������Ʈ�� �����Ƿ� true
		}
		catch(Exception e) {
			System.out.println("updaet()���� ���");
			e.printStackTrace();
		}
		finally {
			JDBC.disconnect(pstmt, conn);
		}
		return res;
	}
}

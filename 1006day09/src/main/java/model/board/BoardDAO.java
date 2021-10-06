package model.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import model.common.JDBC;

// JDBC
// DAO -> ����̹� , CP, MyBatis, JPA, ...
// Service�� DAO ��ü�� �̿��Ͽ� CRUD����� ���� �� ����!
// ��Service <-> �ð�DAO
// DAO�� ��üȭ�� �Ǿ���ϱ⶧���� Component
// ����Ʈ���� �ľ��� ���� Repository��� 

@Repository("boardDAO")
public class BoardDAO {
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private final String insertSQL="insert into board values ((select nvl(max(id),0)+1 from board),?,?,?,sysdate)";
	private final String updateSQL="update board set title=?, writer=?, content=?, where id=? ";
	private final String deleteSQL="delete from board where id=?";
	private final String getBoardListSQL="select * from board";
	private final String getBoardSQL="select * from board where id=?";
	
	public void insertBoard(BoardVO vo) {
		System.out.println("insertBoard ����");
		conn=JDBC.getConnection();
		try {
			pstmt=conn.prepareStatement(insertSQL);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getWriter());
			pstmt.setString(3, vo.getContent());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			System.out.println("insertŻ��");
			JDBC.close(conn, pstmt);
		}
				
	}
	public void updateBoard(BoardVO vo) {
		System.out.println("updateBoard ����");
		conn=JDBC.getConnection();
		try {
			pstmt=conn.prepareStatement(updateSQL);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getWriter());
			pstmt.setString(3, vo.getContent());
			pstmt.setInt(4, vo.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBC.close(conn, pstmt);
		}
		
	}
	public void deleteBoard(BoardVO vo) {
		System.out.println("deleteBoard ����");
		conn=JDBC.getConnection();
		try {
			pstmt=conn.prepareStatement(deleteSQL);
			pstmt.setInt(1, vo.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBC.close(conn, pstmt);
		}
		
	}
	public ArrayList<BoardVO> getBoardList(BoardVO vo) {	
		System.out.println("getBoardList ����");
		ArrayList<BoardVO> datas=new ArrayList<BoardVO>();
		conn=JDBC.getConnection();
		try {
			pstmt=conn.prepareStatement(getBoardListSQL);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				BoardVO data=new BoardVO();
				data.setId(rs.getInt("id"));
				data.setTitle(rs.getString("title"));
				data.setWriter(rs.getString("writer"));
				data.setContent(rs.getString("content"));
				data.setWdate(rs.getDate("wdate"));
				datas.add(data);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			JDBC.close(conn, pstmt, rs);
		}
		
		return datas;
	}
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("getBoard ����");
		BoardVO data=null;
		conn=JDBC.getConnection();
		try {
			pstmt=conn.prepareStatement(getBoardSQL);
			pstmt.setInt(1, vo.getId());
			rs=pstmt.executeQuery();
			if(rs.next()) {
				data=new BoardVO();
				data.setId(rs.getInt("id"));
				data.setTitle(rs.getString("title"));
				data.setWriter(rs.getString("writer"));
				data.setContent(rs.getString("content"));
				data.setWdate(rs.getDate("wdate"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBC.close(conn, pstmt, rs);
		} 
		return data;
		
	}

}

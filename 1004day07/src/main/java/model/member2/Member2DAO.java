package model.member2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import model.common.JDBC;

@Repository
public class Member2DAO {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private String insertSQL="insert into member2 values(?,?,?,?)";
	private String updateSQL="update set member2 password=?, name=?, role=? where id=?";
	private String deleteSQL="delete from member2 where id=?";
	private String selectAllSQL="select * from member2";
	private String selectOneSQL="select * from member2 where id=?";
	
	public void insertMember2(Member2VO vo) {
		System.out.println("insertMember ����");
		conn=JDBC.getConnection();
		try {
			pstmt=conn.prepareStatement(insertSQL);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPassword());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getRole());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("insertMember ����");
			e.printStackTrace();
		} finally {
			System.out.println("insertMember ����");
			JDBC.close(conn, pstmt);
		}
	}
	public void updateMember2(Member2VO vo) {
		System.out.println("updateMember ����");
		conn=JDBC.getConnection();
		try {
			pstmt=conn.prepareStatement(updateSQL);
			pstmt.setString(1, vo.getPassword());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getRole());
			pstmt.setString(4, vo.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("updateMember ����");
			e.printStackTrace();
		} finally {
			System.out.println("updateMember ����");
			JDBC.close(conn, pstmt);
		}
		
	}
	public void deleteMember2(Member2VO vo) {
		System.out.println("deleteMember ����");
		conn=JDBC.getConnection();
		try {
			pstmt=conn.prepareStatement(deleteSQL);
			pstmt.setString(1, vo.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("deleteMember ����");
			e.printStackTrace();
		} finally {
			System.out.println("deleteMember ����");
			JDBC.close(conn, pstmt);
		}
	}
	public ArrayList<Member2VO> getMember2(Member2VO vo) {
		System.out.println("getMember ����");
		ArrayList<Member2VO> datas=new ArrayList<Member2VO>();
		conn=JDBC.getConnection();
		try {
			pstmt=conn.prepareStatement(selectAllSQL);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Member2VO data=new Member2VO();
				data.setId(rs.getString("id"));
				data.setPassword(rs.getString("password"));
				data.setName(rs.getString("name"));
				data.setRole(rs.getString("role"));
				datas.add(data);
			}
		} catch (SQLException e) {
			System.out.println("getMember ����");
			e.printStackTrace();
		} finally {
			System.out.println("getMember ����");
			JDBC.close(conn, pstmt, rs);
		}
		return datas;

	}
	public Member2VO selectMember2(Member2VO vo) {
		System.out.println("selectMember ����");
		Member2VO data=null;
		conn=JDBC.getConnection();
		try {
			pstmt=conn.prepareStatement(selectOneSQL);
			pstmt.setString(1, vo.getId());
			rs=pstmt.executeQuery();
			if(rs.next()) {
				data=new Member2VO();
				data.setId(rs.getString("id"));
				data.setPassword(rs.getString("password"));
				data.setName(rs.getString("name"));
				data.setRole(rs.getString("role"));
			}
		} catch (SQLException e) {
			System.out.println("selectMember ����");
			e.printStackTrace();
		} finally {
			System.out.println("selectMember ����");
			JDBC.close(conn, pstmt, rs);
		}
		return data;
	}

}

package model.message;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.common.JDBC;

public class MessageDAO {
	
	public ArrayList<MessageVO> getDBList(){ // 글 목록==ArrayList로 구현
		Connection conn=JDBC.connect(); // JDBC의 connect불러옴
		ArrayList<MessageVO> datas=new ArrayList(); // 어레이 리스트 생성
		PreparedStatement pstmt=null;
		try {
			String sql="select * from message order by mnum desc"; // 내림차순으로 정렬sql문
			pstmt=conn.prepareStatement(sql);
			ResultSet rs=pstmt.executeQuery(); // ResultSet 생성
			while(rs.next()) { // 데이터 불러오기
				MessageVO vo=new MessageVO();
				vo.setContent(rs.getString("content"));
				vo.setMnum(rs.getInt("mnum"));
				vo.setTitle(rs.getString("title"));
				vo.setWdate(rs.getDate("wdate"));
				vo.setWriter(rs.getString("writer"));
				datas.add(vo); // ArrayList에 추가
			}
			rs.close();
		}catch(Exception e){
			System.out.println("getDBList()에서 출력");
			e.printStackTrace();
		}finally {
			JDBC.disconnect(pstmt, conn);
		}
		return datas;
	}
	
	public MessageVO getDBData(MessageVO vo) {
		Connection conn=JDBC.connect();
		MessageVO data=null; // 받아올 data를 생성
		PreparedStatement pstmt=null;
		try {
			String sql="select * from message where mnum=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getMnum()); // mnum인 message를 변경
			ResultSet rs=pstmt.executeQuery(); // ResultSet 생성
			while(rs.next()) { // 데이터 불러오기
				data.setContent(rs.getString("content"));
				data.setMnum(rs.getInt("mnum"));
				data.setTitle(rs.getString("title"));
				data.setWdate(rs.getDate("wdate"));
				data.setWriter(rs.getString("writer"));
			}
			rs.close();
		}catch(Exception e){
			System.out.println("getDBData()에서 출력");
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
	public boolean updateDB(MessageVO vo) { // 인자 갯수,타입 변경시 전부 바꿔야하기때문에 인자로 VO를 받음
		Connection conn=JDBC.connect();
		boolean res=false;
		PreparedStatement pstmt=null;
		try {
			String sql="update message set writer=?, title=?, content=?, wdate=sysdate where=mnum=?"; // sysdate==현재날짜 변경위함
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, vo.getWriter());
			pstmt.setString(2, vo.getTitle());
			pstmt.setString(3, vo.getContent());
			pstmt.setDate(4, vo.getWdate());
			pstmt.setInt(5, vo.getMnum());
			pstmt.executeUpdate();
			res=true; // 업데이트가 됐으므로 true
		}
		catch(Exception e) {
			System.out.println("updaet()에서 출력");
			e.printStackTrace();
		}
		finally {
			JDBC.disconnect(pstmt, conn);
		}
		return res;
	}
}

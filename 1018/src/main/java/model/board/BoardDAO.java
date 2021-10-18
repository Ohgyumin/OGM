package model.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.client.ClientVO;
import model.common.JNDI;

public class BoardDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	boolean flag=false;

	String selectAll= "select * from board order by bnum desc"; // 모든 게시글 보기
	String insert="insert into board(bnum,userID,title,content,wdate) values (nvl((select max(bnum) from board),0)+1, ?, ?, ?, sysdate)"; // 게시글 등록
	
	public ArrayList<BoardVO> getDBList(ClientVO vo){ // 모든 게시글 보기
		ArrayList<BoardVO> datas = new ArrayList<BoardVO>();
		conn=JNDI.connect();
		
		
		try {
			pstmt=conn.prepareStatement(selectAll);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				BoardVO data = new BoardVO();
				data.setContent(rs.getString("content"));
				data.setBnum(rs.getInt("bnum"));
				data.setTitle(rs.getString("title"));
				data.setWdate(rs.getDate("wdate"));
				data.setUserID(rs.getString("userID"));
				datas.add(data);
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JNDI.disconnect(pstmt, conn);
		}
		return datas;
	
	}
	 public boolean write(BoardVO vo) { // 게시글 등록
		 conn=JNDI.connect();
		 
		 try {
			pstmt=conn.prepareStatement(insert);
			pstmt.setString(1, vo.getUserID());
			pstmt.setString(2, vo.getTitle());
			pstmt.setString(3, vo.getContent());
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

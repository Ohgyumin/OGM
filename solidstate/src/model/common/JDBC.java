package model.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JDBC {
	
	public static Connection connect() { // JDBC연결
		Connection conn=null;
		String jdbc_driver = "oracle.jdbc.driver.OracleDriver"; // 드라이버 지정
		String jdbc_url = "jdbc:oracle:thin:@localhost:1521:xe"; // url 지정
		try {
			Class.forName(jdbc_driver);
			conn=DriverManager.getConnection(jdbc_url,"oh","1234");
		}
		catch(Exception e){
			System.out.println("connect()에서출력");
			e.printStackTrace();
		}
		return conn;	
	}
	public static void disconnect(PreparedStatement pstmt,Connection conn) { // pstmt와conn닫기위해 인자로 받음
		try {
			pstmt.close();
			conn.close();
		}catch(Exception e){
			System.out.println("disconnect()에서 출력");
			e.printStackTrace();
		}
	}
	
}

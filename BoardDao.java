package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import dto.BoardDto;

public class BoardDao {
	public Connection getConnection() throws Exception {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbId = "testw8";
		String dbPw = "pass1234";
		
		Class.forName(driver);   // JDBC 드라이버 로딩.
		Connection conn = DriverManager.getConnection(url, dbId, dbPw);
								// DB접속을 시도 ---> Connection객체를 리턴.
		
		return conn;
	}
	public BoardDto getBoardDto(int bno) throws Exception {
		Connection conn = getConnection();
		
		String sql = "SELECT * FROM board WHERE bno=?";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, bno);
		
		ResultSet rs = pstmt.executeQuery();

		BoardDto dto = null;
		if(rs.next()) {
			String title = rs.getString("title");
			String content = rs.getString("content");
			String writer = rs.getString("writer");
			String writedate = rs.getString("writedate");
			dto = new BoardDto(bno, title, content, writer, writedate);
		}
		rs.close();
		pstmt.close();
		conn.close();
		return dto;
	}
	public ArrayList<BoardDto> getAllBoardList() throws Exception {
		ArrayList<BoardDto> list1 = new ArrayList<BoardDto>();
		
		Connection conn = getConnection();
		String sql = "SELECT * FROM board ORDER BY bno DESC";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			int bno = rs.getInt("bno");
			String title = rs.getString("title");
			String content = rs.getString("content");
			String writer = rs.getString("writer");
			String writedate = rs.getString("writedate");
			// rs.getNString() ---> NVARCHAR2 타입.
			// rs.getString() ----> VARCHAR2 타입.
			BoardDto dto = new BoardDto(bno, title, content, writer, writedate);
			list1.add(dto);
		}
		return list1;
	}
}





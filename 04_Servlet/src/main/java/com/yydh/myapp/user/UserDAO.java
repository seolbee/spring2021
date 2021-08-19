package com.yydh.myapp.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

import com.yydh.myapp.board.JDBCUtil;


@Repository
public class UserDAO {

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	private final String USER_GET = "SELECT * FROM users where id=? and password=?";
	
	
	public UserVO getUser(UserVO vo) {
		UserVO user = null;
		try {
			System.out.println("===> JDBC�� getUser() ��� ó��");
			
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(USER_GET);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPassword());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				user = new UserVO();
				user.setId(rs.getString("ID"));
				user.setPassword(rs.getString("PASSWORD"));
				user.setName(rs.getString("NAME"));
				user.setRole(rs.getString("ROLE"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, pstmt, conn);
		}
		return user;
	}
	
	
}

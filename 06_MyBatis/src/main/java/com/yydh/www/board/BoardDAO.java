package com.yydh.www.board;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Repository;
@Repository
public class BoardDAO {
	
	private SqlSessionFactory sqlSessionFactory;
	private final String namespace = "BoardMapper";
	
//	// JDBC ���� ����
//	private Connection conn = null;
//	private PreparedStatement pstmt = null;
//	private ResultSet rs = null;
	
//	// SQL ��ɾ��
//	private final String BOARD_INSERT = "INSERT INTO board(seq, title, writer, content) "
//			+ "VALUES((select nvl(max(seq),0)+1 from board),?,?,?)";
//	
//	private final String BOARD_UPDATE = "UPDATE board SET title=?, content=? WHERE seq=?";
//	private final String BOARD_DELETE = "DELETE board WHERE seq=?";
//	private final String BOARD_GET = "SELECT * FROM board WHERE seq=?";
//	private final String BOARD_LIST = "SELECT * FROM board ORDER BY SEQ DESC";
//	private final String BOARD_LIST_T = "select * from board where title like '%'||?||'%' order by seq desc";
	
	public BoardDAO() {
		InputStream inputStream = null;
		try {
			String resource = "mybatits-config.xml";
			inputStream = Resources.getResourceAsStream(resource);
		} catch (Exception e) {
			e.printStackTrace();
		}
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	// �� ���
	public void insertBoard(BoardVO vo) {
//		System.out.println("===> JDBC insertBoard() ��� ó��");
//		try {
//			conn = JDBCUtil.getConnection();
//			pstmt = conn.prepareStatement(BOARD_INSERT);
//			pstmt.setString(1, vo.getTitle());
//			pstmt.setString(2, vo.getWriter());
//			pstmt.setString(3, vo.getContent());
//			pstmt.executeUpdate();
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			JDBCUtil.close(pstmt, conn);
//		}
		SqlSession session = sqlSessionFactory.openSession();
		try {
			session.insert(, parameter)
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) session.close();
		}
	}
	
	
	// �� ����
	public void updateBoard(BoardVO vo) {
		System.out.println("===> JDBC updateBoard() ��� ó��");
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(BOARD_UPDATE);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setInt(3, vo.getSeq());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(pstmt, conn);
		}
	}
	
	// �� ����
	public void deleteBoard(int seq) {
//		System.out.println("===> JDBC deleteBoard() ��� ó��");
//		try {
//			conn = JDBCUtil.getConnection();
//			pstmt = conn.prepareStatement(BOARD_DELETE);
//			pstmt.setInt(1, seq);
//			pstmt.executeUpdate();
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			JDBCUtil.close(pstmt, conn);
//		}
		
		SqlSession session = sqlSessionFactory.openSession();
		try {
			session.delete(namespace+".deleteData", seq);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) session.close();
		}
	}	
	
	
	// �� �� ��ȸ
	public BoardVO getBoard(int seq) {
		System.out.println("===> JDBC getBoard() ��� ó��");
		BoardVO board = null;
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(BOARD_GET);
			pstmt.setInt(1, seq);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				board = new BoardVO();
				board.setSeq(rs.getInt("seq"));
				board.setTitle(rs.getString("title"));
				board.setWriter(rs.getString("writer"));
				board.setContent(rs.getString("content"));
				board.setRegDate(rs.getDate("regdate"));
				board.setCnt(rs.getInt("cnt"));
			}
			pstmt = conn.prepareStatement("UPDATE board set cnt=cnt+1 where seq=?");
			pstmt.setInt(1, seq);
			rs = pstmt.executeQuery();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(pstmt, conn);
		}
		return board;
	}
	
	
	// �� ��� ��ȸ
	public List<BoardVO> getBoardList() {
		System.out.println("===> JDBC getBoardList() ��� ó��");
		SqlSession session = sqlSessionFactory.openSession();
		List<BoardVO> boardList = null;
		try {
//			conn = JDBCUtil.getConnection();
//			pstmt = conn.prepareStatement(BOARD_LIST);
//			rs = pstmt.executeQuery();
			
			boardList = session.selectList(namespace + ".selectAll");
//			while(rs.next()) {
//				BoardVO board = new BoardVO();
//				board.setSeq(rs.getInt("seq"));
//				board.setTitle(rs.getString("title"));
//				board.setWriter(rs.getString("writer"));
//				board.setContent(rs.getString("content"));
//				board.setRegDate(rs.getDate("regdate"));
//				board.setCnt(rs.getInt("cnt"));
//				boardList.add(board);
//			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return boardList;
	}
	
	public List<BoardVO> searchBoardList(String keyword) {
		List<BoardVO> boardList = new ArrayList<BoardVO>();
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(BOARD_LIST_T);
			pstmt.setString(1, keyword);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardVO board = new BoardVO();
				board.setSeq(rs.getInt("seq"));
				board.setTitle(rs.getString("title"));
				board.setWriter(rs.getString("writer"));
				board.setContent(rs.getString("content"));
				board.setRegDate(rs.getDate("regdate"));
				board.setCnt(rs.getInt("cnt"));
				boardList.add(board);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(pstmt, conn);
		}
		return boardList;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}

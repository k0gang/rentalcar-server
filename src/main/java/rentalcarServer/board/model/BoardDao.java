package rentalcarServer.board.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import rentalcarServer.dbConnection;

public class BoardDao {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private static BoardDao boardDao = new BoardDao();

	public static BoardDao getInstance() {
		return boardDao;
	}

	public List<BoardResponseDto> findBoardAll() {
		List<BoardResponseDto> list = new ArrayList<BoardResponseDto>();
		conn = dbConnection.getConnection();
		String sql = "SELECT board_code,user_id,title,content,admin,reg_date FROM board order by admin desc , reg_date desc;";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int boardCode = rs.getInt(1);
				String userId = rs.getString(2);
				String title = rs.getString(3);
				String content = rs.getString(4);
				boolean admin = rs.getBoolean(5);
				Timestamp reg_date = rs.getTimestamp(6);
				BoardResponseDto board = new BoardResponseDto(boardCode, userId, title, content, admin, reg_date);
				list.add(board);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbConnection.close(conn, pstmt, rs);
		}

		return list;

	}

	public BoardResponseDto createBoard(BoardRequestDto boardRequestDto) {
		conn = dbConnection.getConnection();
		BoardResponseDto board = null;
		String userId = boardRequestDto.getUserId();
		String title = boardRequestDto.getTitle();
		String content = boardRequestDto.getContent();

		String sql = "INSERT INTO board (user_id, title, content, admin) VALUES (?, ?, ?, (SELECT admin FROM users where user_id = ? ))";

		try {
			pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, userId);
			pstmt.setString(2, title);
			pstmt.setString(3, content);
			pstmt.setString(4, userId);

			pstmt.executeUpdate();

			ResultSet rs = pstmt.getGeneratedKeys();
			if (rs.next()) {
				int boardId = rs.getInt(1);
				System.out.println(boardId);
				board = findBoard(boardId);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbConnection.close(conn, pstmt, rs);
		}
		return board;
	}

	public BoardResponseDto findBoard(int boardId) {
		conn = dbConnection.getConnection();
		BoardResponseDto board = null;
		String sql = "SELECT board_code,user_id,title,content,admin FROM board WHERE board_code = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				int boardCode = rs.getInt(1);
				String userId = rs.getString(2);
				String title = rs.getString(3);
				String content = rs.getString(4);
				boolean admin = rs.getBoolean(5);

				board = new BoardResponseDto(boardCode, userId, title, content, admin);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return board;
	}

	public boolean deleteBoard(BoardRequestDto boardRequestDto) {
		if (findBoard(boardRequestDto.getBoardCode()) == null) {
			return false;
		}

		try {
			String sql = "DELETE FROM board WHERE board_code=?";
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, boardRequestDto.getBoardCode());

			pstmt.execute();

			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean deleteBoard(BoardResponseDto boardResponseDto) {
		try {
			String sql = "DELETE FROM board WHERE board_code=?";
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, boardResponseDto.getBoardCode());

			pstmt.execute();

			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
		
	}

	public BoardResponseDto updateBoard(BoardRequestDto boardDto) {
		BoardResponseDto board = null;

		if (findBoard(boardDto.getBoardCode()) == null) {
			return board;
		}

		try {
			conn = dbConnection.getConnection();

			String sql = "UPDATE board SET title=?, content=? WHERE board_code=?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardDto.getTitle());
			pstmt.setString(2, boardDto.getContent());
			pstmt.setInt(3, boardDto.getBoardCode());

			System.out.println("boardDao 에서의 title : " + boardDto.getTitle());
			System.out.println("boardDao 에서의 content : " + boardDto.getContent());
			System.out.println("boardDao 에서의 boardCode : " + boardDto.getBoardCode());
			
			pstmt.execute();
			
			board = findBoard(boardDto.getBoardCode());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbConnection.close(conn, pstmt);
		}
		return board;
	}

}
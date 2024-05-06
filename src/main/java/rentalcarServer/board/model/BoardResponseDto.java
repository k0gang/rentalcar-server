package rentalcarServer.board.model;

import java.sql.Timestamp;

public class BoardResponseDto {
	private boolean admin;
    private String userId;
    private int boardCode;
    private String title;
    private String content;
    private Timestamp reg_date;
    
    @Override
    public String toString() {
    	return this.userId + this.boardCode;
    }
    
	public BoardResponseDto(int boardCode, String userId, String title, String content, boolean admin, Timestamp reg_date) {
		super();
		this.boardCode = boardCode;
		this.userId = userId;
		this.title = title;
		this.content = content;
		this.admin = admin;
		this.reg_date = reg_date;
	}
	
	public BoardResponseDto(int boardCode, String userId, String title, String content, boolean admin) {
		super();
		this.boardCode = boardCode;
		this.userId = userId;
		this.title = title;
		this.content = content;
		this.admin = admin;
	}
	
	public BoardResponseDto(Board board) {
		this.admin = board.isAdmin();
		this.userId = board.getUserId();
		this.boardCode = board.getBoardCode();
		this.title = board.getTitle();
		this.content = board.getContent();
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getBoardCode() {
		return boardCode;
	}

	public void setBoardCode(int boardCode) {
		this.boardCode = boardCode;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}

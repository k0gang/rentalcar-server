package rentalcarServer.board.model;

import java.sql.Timestamp;

public class BoardRequestDto {
	private boolean admin;
    private String userId;
    private int boardCode;
    private String title;
    private String content;
    private Timestamp regDate;
    
	public BoardRequestDto(boolean admin, String userId, int boardCode, String title, String content) {
		super();
		this.admin = admin;
		this.userId = userId;
		this.boardCode = boardCode;
		this.title = title;
		this.content = content;
	}
	
	public BoardRequestDto(int boardCode, String userId, String title, String content, Timestamp regDate) {
		super();
		this.boardCode = boardCode;
		this.userId = userId;
		this.title = title;
		this.content = content;
		this.regDate = regDate;
	}
	
	public BoardRequestDto(String userId, String title, String content) {
		super();
		this.userId = userId;
		this.title = title;
		this.content = content;
	}
    

	public BoardRequestDto() {
    	
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
	
	public Timestamp getRegDate() {
		return regDate;
	}
	
	public void setRegDate(Timestamp regDate) {
		this.regDate = regDate;
	}
    
}

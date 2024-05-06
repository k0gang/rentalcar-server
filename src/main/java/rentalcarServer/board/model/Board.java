package rentalcarServer.board.model;

import java.sql.Timestamp;

public class Board {
	private boolean admin;
    private String userId;
    private int boardCode;
    private String title;
    private String content;
    private Timestamp regDate;
    private Timestamp modDate;
    
	public Board(boolean admin, String userId, int boardCode, String title, String content, Timestamp regDate,
			Timestamp modDate) {
		super();
		this.admin = admin;
		this.userId = userId;
		this.boardCode = boardCode;
		this.title = title;
		this.content = content;
		this.regDate = regDate;
		this.modDate = modDate;
	}
	
	public Board(boolean admin, String userId, int boardCode, String title, String content) {
		super();
		this.admin = admin;
		this.userId = userId;
		this.boardCode = boardCode;
		this.title = title;
		this.content = content;
	}

	public boolean isAdmin() {
		return admin;
	}

	public String getUserId() {
		return userId;
	}

	public int getBoardCode() {
		return boardCode;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

	public Timestamp getRegDate() {
		return regDate;
	}

	public Timestamp getModDate() {
		return modDate;
	}
  
}

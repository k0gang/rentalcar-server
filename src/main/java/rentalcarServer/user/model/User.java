package rentalcarServer.user.model;

import java.security.Timestamp;

public class User {
	private String userId;
	private String userPassword;
	private String userName;
	private String userBirth;
	private String userTelecom;
	private String userPhone;
	private boolean admin;
	private Timestamp regDate;
	private Timestamp modDate;

	public String getUserId() {
		return userId;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public String getUserName() {
		return userName;
	}

	public String getUserBirth() {
		return userBirth;
	}

	public String getUserTelecom() {
		return userTelecom;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public boolean isAdmin() {
		return admin;
	}

	public Timestamp getRegDate() {
		return regDate;
	}

	public Timestamp getModDate() {
		return modDate;
	}
}

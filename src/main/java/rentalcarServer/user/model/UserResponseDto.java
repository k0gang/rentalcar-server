package rentalcarServer.user.model;

public class UserResponseDto {

	private String userId;
	private String userPassword;
	private String userName;
	private String userBirth;
	private String userTelecom;
	private String userPhone;
	private boolean admin;

	@Override
	public String toString() {
		return this.userId + this.userName;
	}
	
	public UserResponseDto(String userId, String userPassword, String userName, String userBirth, String userTelecom,
			String userPhone, boolean admin) {
		super();
		this.userId = userId;
		this.userPassword = userPassword;
		this.userName = userName;
		this.userBirth = userBirth;
		this.userTelecom = userTelecom;
		this.userPhone = userPhone;
		this.admin = admin;
	}
	
	public UserResponseDto(String userId, String userPassword, String userName, String userBirth, String userTelecom,
			String userPhone) {
		super();
		this.userId = userId;
		this.userPassword = userPassword;
		this.userName = userName;
		this.userBirth = userBirth;
		this.userTelecom = userTelecom;
		this.userPhone = userPhone;
	}

	public UserResponseDto(User user) {
		this.userId = user.getUserId();
		this.userPassword = user.getUserPassword();
		this.userName = user.getUserName();
		this.userBirth = user.getUserBirth();
		this.userTelecom = user.getUserTelecom();
		this.userPhone = user.getUserPhone();
		this.admin = user.isAdmin();
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserBirth() {
		return userBirth;
	}

	public void setUserBirth(String userBirth) {
		this.userBirth = userBirth;
	}

	public String getUserTelecom() {
		return userTelecom;
	}

	public void setUserTelecom(String userTelecom) {
		this.userTelecom = userTelecom;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
}

package rentalcarServer.user.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import rentalcarServer.dbConnection;
import rentalcarServer.util.PasswordCrypto;

public class UserDao {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private UserDao() {

	}

	private static UserDao instance = new UserDao(); // 싱글톤

	public static UserDao getInstance() {
		return instance;
	}

	public UserResponseDto findUserByIdAndPassword(String id, String password) {
		UserResponseDto user = null;

		try {
			conn = dbConnection.getConnection();

			String sql = "SELECT user_id, user_name, user_birth, user_telecom, user_phone, admin, user_password FROM users WHERE user_id=?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				String name = rs.getString(2);
				String birth = rs.getString(3);
				String telecom = rs.getString(4);
				String phone = rs.getString(5);
				boolean admin = rs.getBoolean(6);
				String encrypedPassword = rs.getString(7);

				if (PasswordCrypto.decrypt(password, encrypedPassword))
					user = new UserResponseDto(id, password, name, birth, telecom, phone, admin);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbConnection.close(conn, pstmt, rs);
		}
		return user;
	}

	public UserResponseDto createUser(UserRequestDto userDto) {

		try {
			conn = dbConnection.getConnection();

			String sql = "INSERT INTO users(user_id, user_password, user_name, user_birth, user_telecom, user_phone) VALUES (?, ?, ?, ?, ?, ?)";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, userDto.getUserId());
			pstmt.setString(2, PasswordCrypto.encrypt(userDto.getUserPassword()));
			pstmt.setString(3, userDto.getUserName());
			pstmt.setString(4, userDto.getUserBirth());
			pstmt.setString(5, userDto.getUserTelecom());
			pstmt.setString(6, userDto.getUserPhone());

			pstmt.execute();

			return findUserByIdAndPassword(userDto.getUserId(), userDto.getUserPassword());
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			dbConnection.close(conn, pstmt);
		}
		return null;
	}

}

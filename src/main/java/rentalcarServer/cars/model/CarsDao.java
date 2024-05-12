package rentalcarServer.cars.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import rentalcarServer.dbConnection;

public class CarsDao {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private CarsDao() {

	}

	private static CarsDao instance = new CarsDao();

	public static CarsDao getInstance() {
		return instance;
	}
	
	public int carSize() {
	    int size = 0;
	    conn = dbConnection.getConnection();
	    String sql = "SELECT COUNT(*) FROM cars";
	    
	    try {
	        pstmt = conn.prepareStatement(sql);
	        rs = pstmt.executeQuery();
	        if (rs.next()) {
	            size = rs.getInt(1);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	    	dbConnection.close(conn, pstmt, rs);
	    }
	    return size;
	}
	
	public List<CarsResponseDto> findCarAll() {
		List<CarsResponseDto> list = new ArrayList<CarsResponseDto>();
		
		conn = dbConnection.getConnection();
	    String sql = "SELECT car_code, car_num, car_abroad, car_brand, car_name, car_type, car_seat, car_oil, car_year, car_price FROM cars";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				int car_code = rs.getInt(1);
				String car_num = rs.getString(2);
				String car_abroad = rs.getString(3);
				String car_brand = rs.getString(4);
				String car_name = rs.getString(5);
				String car_type = rs.getString(6);
				String car_seat = rs.getString(7);
				String car_oil = rs.getString(8);
				int car_year = rs.getInt(9);
				int car_price = rs.getInt(10);
				
				CarsResponseDto car = new CarsResponseDto(car_code, car_num, car_abroad, car_brand, car_name, car_type, car_seat, car_oil, car_year, car_price);
				list.add(car);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbConnection.close(conn, pstmt, rs);
		}
		return list;
	}
	
	public List<CarsResponseDto> findValidCars(String startDateTime, String endDateTime) {
		List<CarsResponseDto> list = new ArrayList<CarsResponseDto>();
		
		conn = dbConnection.getConnection();
		try {
			String sql = "SELECT car_code, car_num, car_abroad, car_brand, car_name, car_type, car_seat, car_oil, car_year, car_price FROM cars WHERE car_code NOT IN (SELECT car_code FROM reservations WHERE ((borrow_date BETWEEN ? AND ?) OR (return_date BETWEEN ? AND ?) OR (borrow_date <= ? AND return_date >= ?)) AND status = '예약중')";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, startDateTime);
			pstmt.setString(2, endDateTime);
			pstmt.setString(3, startDateTime);
			pstmt.setString(4, endDateTime);
			pstmt.setString(5, startDateTime);
			pstmt.setString(6, endDateTime);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int car_code = rs.getInt(1);
				String car_num = rs.getString(2);
				String car_abroad = rs.getString(3);
				String car_brand = rs.getString(4);
				String car_name = rs.getString(5);
				String car_type = rs.getString(6);
				String car_seat = rs.getString(7);
				String car_oil = rs.getString(8);
				int car_year = rs.getInt(9);
				int car_price = rs.getInt(10);
				
				CarsResponseDto car = new CarsResponseDto(car_code, car_num, car_abroad, car_brand, car_name, car_type, car_seat, car_oil, car_year, car_price);
				list.add(car);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbConnection.close(conn, pstmt, rs);
		}
		return list;
	}
	
	public CarsResponseDto findCarsByCarCode(int carCode) {
		conn = dbConnection.getConnection();
		CarsResponseDto car = null;
		String sql = "SELECT car_code, car_num, car_abroad,car_brand,car_name,car_type,car_seat,car_oil,car_year,car_price FROM Cars WHERE car_code = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, carCode);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				String carNum = rs.getString(2);
				String carAbroad = rs.getString(3);
				String carBrand = rs.getString(4);
				String carName = rs.getString(5);
				String carType = rs.getString(6);
				String carSeat = rs.getString(7);
				String carOil = rs.getString(8);
				int carYear = rs.getInt(9);
				int carPrice = rs.getInt(10);
				
				car = new CarsResponseDto(carCode, carNum, carAbroad, carBrand, carName, carType, carSeat, carOil, carYear, carPrice);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			dbConnection.close(conn, pstmt, rs);
		}
		return car;
	}

}
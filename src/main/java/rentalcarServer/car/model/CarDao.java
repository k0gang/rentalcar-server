package rentalcarServer.car.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import rentalcarServer.dbConnection;

public class CarDao {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	private CarDao() {
	}

	private static CarDao carsDao = new CarDao();

	public static CarDao getInstance() {
		return carsDao;
	}

	public List<CarResponseDto> findCarsAll() {
		conn = dbConnection.getConnection();
		List<CarResponseDto> list = new ArrayList<CarResponseDto>();
		String sql = "SELECT car_code, car_num, car_abroad,car_brand,car_name,car_type,car_seat,car_oil,car_year,car_price FROM cars";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int carCode = rs.getInt(1);
				String carNum = rs.getString(2);
				String carAbroad = rs.getString(3);
				String carBrand = rs.getString(4);
				String carName = rs.getString(5);
				String carType = rs.getString(6);
				int carSeat = rs.getInt(7);
				String carOil = rs.getString(8);
				int carYear = rs.getInt(9);
				int carPrice = rs.getInt(10);
				String imageUrl = findImage(carName);

				CarResponseDto car = new CarResponseDto(carCode, carNum, carAbroad, carBrand, carName, carType,
						carSeat, carOil, carYear, carPrice,imageUrl);
				list.add(car);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbConnection.close(conn, pstmt, rs);
		}

		return list;

	}
	
	public List<CarResponseDto> findAvailableCars(String startDateTime, String endDateTime) {
        List<CarResponseDto> list = new ArrayList<>();
        conn = dbConnection.getConnection();       
        
        System.out.println(startDateTime);
        System.out.println(endDateTime);
        
        try {
            String sql = "SELECT car_code, car_num, car_abroad,car_brand,car_name,car_type,car_seat,car_oil,car_year,car_price FROM cars WHERE car_code NOT IN" +
                         "(SELECT car_code FROM reservations " +
                         "WHERE ((borrow_date BETWEEN ? AND ?) OR (return_date BETWEEN ? AND ?) OR (borrow_date<= ? AND return_date >= ?)) AND status = '예약중')";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, startDateTime);
            pstmt.setString(2, endDateTime);
            pstmt.setString(3, startDateTime);
            pstmt.setString(4, endDateTime);
            pstmt.setString(5, startDateTime);
            pstmt.setString(6, endDateTime);
         
      
            rs = pstmt.executeQuery();

            while (rs.next()) {
            	int carCode = rs.getInt(1);
				String carNum = rs.getString(2);
				String carAbroad = rs.getString(3);
				String carBrand = rs.getString(4);
				String carName = rs.getString(5);
				String carType = rs.getString(6);
				int carSeat = rs.getInt(7);
				String carOil = rs.getString(8);
				int carYear = rs.getInt(9);
				int carPrice = rs.getInt(10);
				String imageUrl = findImage(carName);

				CarResponseDto car = new CarResponseDto(carCode, carNum, carAbroad, carBrand, carName, carType,
						carSeat, carOil, carYear, carPrice,imageUrl);
				list.add(car);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        	dbConnection.close(conn, pstmt, rs);
        }

        return list;
    }

	private String findImage(String carName) {
		String url = "/resources/car-images/sonata.jpeg";
		return url;
	}

	public CarResponseDto findCarsByCarCode(int carCode) {
		conn = dbConnection.getConnection();
		CarResponseDto car = null;
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
				int carSeat = rs.getInt(7);
				String carOil = rs.getString(8);
				int carYear = rs.getInt(9);
				int carPrice = rs.getInt(10);
				String imageUrl = findImage(carName);
				car = new CarResponseDto(carCode, carNum, carAbroad, carBrand, carName, carType,
						carSeat, carOil, carYear, carPrice,imageUrl);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			dbConnection.close(conn, pstmt, rs);
		}
		
		return car;
	}

	
}
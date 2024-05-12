package rentalcarServer.reservations.model;

import java.sql.Timestamp;

public class Reservations {
	private int reservationNum;
	private String userId;
	private int carCode;
	private int carPrice;
	private Timestamp borrowDate;
	private Timestamp returnDate;
	private String status;
	private String carName;
	private Timestamp regDate;
	private Timestamp modDate;
	

	public Reservations(int reservationNum, String userId, int carCode, int carPrice, Timestamp borrowDate,
			Timestamp returnDate, String status, String carName) {
		super();
		this.reservationNum = reservationNum;
		this.userId = userId;
		this.carCode = carCode;
		this.carPrice = carPrice;
		this.borrowDate = borrowDate;
		this.returnDate = returnDate;
		this.status = status;
		this.carName = carName;
	}
	public Reservations(int reservationNum, String userId, int carCode, int carPrice, Timestamp borrowDate,
			Timestamp returnDate, String status, String carName, Timestamp regDate, Timestamp modDate) {
		super();
		this.reservationNum = reservationNum;
		this.userId = userId;
		this.carCode = carCode;
		this.carPrice = carPrice;
		this.borrowDate = borrowDate;
		this.returnDate = returnDate;
		this.status = status;
		this.carName = carName;
		this.regDate = regDate;
		this.modDate = modDate;
	}
	public int getReservationNum() {
		return reservationNum;
	}
	public String getUserId() {
		return userId;
	}
	public int getCarCode() {
		return carCode;
	}
	public int getCarPrice() {
		return carPrice;
	}
	public Timestamp getBorrowDate() {
		return borrowDate;
	}
	public String getStatus() {
		return status;
	}
	public Timestamp getReturnDate() {
		return returnDate;
	}
	public String getCarName() {
		return carName;
	}
	public Timestamp getRegDate() {
		return regDate;
	}
	public Timestamp getModDate() {
		return modDate;
	}
	
}

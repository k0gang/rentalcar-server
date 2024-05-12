package rentalcarServer.cars.model;

public class CarsRequestDto {
	private int carCode;
	private String carNum;
	private String carAbroad;
	private String carBrand;
	private String carName;
	private String carType;
	private String carSeat;
	private String carOil;
	private int carYear;
	private int carPrice;
	
	public CarsRequestDto() {
		// TODO Auto-generated constructor stub
	}
	
	public CarsRequestDto(int carCode, String carNum, String carAbroad, String carBrand, String carName, String carType,
			String carSeat, String carOil, int carYear, int carPrice) {
		super();
		this.carCode = carCode;
		this.carNum = carNum;
		this.carAbroad = carAbroad;
		this.carBrand = carBrand;
		this.carName = carName;
		this.carType = carType;
		this.carSeat = carSeat;
		this.carOil = carOil;
		this.carYear = carYear;
		this.carPrice = carPrice;
	}
	public int getCarCode() {
		return carCode;
	}
	public void setCarCode(int carCode) {
		this.carCode = carCode;
	}
	public String getCarNum() {
		return carNum;
	}
	public void setCarNum(String carNum) {
		this.carNum = carNum;
	}
	public String getCarAbroad() {
		return carAbroad;
	}
	public void setCarAbroad(String carAbroad) {
		this.carAbroad = carAbroad;
	}
	public String getCarBrand() {
		return carBrand;
	}
	public void setCarBrand(String carBrand) {
		this.carBrand = carBrand;
	}
	public String getCarName() {
		return carName;
	}
	public void setCarName(String carName) {
		this.carName = carName;
	}
	public String getCarType() {
		return carType;
	}
	public void setCarType(String carType) {
		this.carType = carType;
	}
	public String getCarSeat() {
		return carSeat;
	}
	public void setCarSeat(String carSeat) {
		this.carSeat = carSeat;
	}
	public String getCarOil() {
		return carOil;
	}
	public void setCarOil(String carOil) {
		this.carOil = carOil;
	}
	public int getCarYear() {
		return carYear;
	}
	public void setCarYear(int carYear) {
		this.carYear = carYear;
	}
	public int getCarPrice() {
		return carPrice;
	}
	public void setCarPrice(int carPrice) {
		this.carPrice = carPrice;
	}
	
	
}
